# Exemplo de implementação

**Cenário:** através de um controle remoto queremos controlar diversos aparelhos eletrônicos de uma só vez (lâmpadas, ventiladores, aparelho de som, etc.).

Esse controle remoto possui diversos slots onde podem ser inseridos comandos. Normalmente em cada slot é adicionado um par de comandos: um comando "On" e um comando "Off". Queremos que seja possível trocar, em tempo de execução, o comando presente em um desses slots.

*Exemplo: se um slot se encarrega de controlar uma lâmpada, queremos poder trocar o comando desse slot para passar a controlar uma TV.*

No exemplo da lâmpada, podemos dizer que:
* A lâmpada é quem vai receber a solicitação e de fato executar o comando. Ela é nosso `Receiver`.
* Quem envia e tem contato direto com a lâmpada é o comando inserido no slot do controle. O comando é o nosso `Command`.
* Quem invoca o comando para ele ser executado é o controle remoto. Ele é o nosso `Invoker`.



<br>

## Sem o padrão Command
Sem aplicar o padrão Command, teremos uma implementação muito acoplada entre o `Receiver` e o `Invoker`. Criando esse acoplamento, perdemos a flexibilidade de alterar em tempo de execução qual o comando presente no slot do controle remoto.

Além disso, cada vez que quiséssemos alterar qual dispositivo determinado slot controla, seria necessária uma alteração muito grande no `Invoker`. Dessa forma a classe se tornaria pouco flexível e difícil de manter.

<br>

## Com o padrão Command
Com o padrão Command, inserimos um intermediário entre o `Invoker` (o controle remoto) e o `Receiver` (a lâmpada). Esse intermediário é o `Command`.

Implementando com esse intermediário, o controle remoto nunca precisa saber se está lidando com uma lâmpada, uma TV ou um aparelho de som. Tudo que ele precisa saber é que possui um `Command` (interface comum a todos os comandos). Inserindo comandos nos slots do controle nos permite também criar fluxos de "desfazer", uma fila de comandos, um histórico de executação de comantos, etc. As possibilidades são grandes e bastante flexíveis já que não estaremos mais acolados ao `Receiver`.

Para isso, precisamos de uma classe para fazer o papel do `Invoker` (nesse casso essa classe representa o controle remoto). O controle irá possuir diversos comandos, não sabendo qual dispositivo exatamente ele está controlando, tudo que ele sabe é que possui um array de `Command`. Podemos *settar* um comando para um dos slots do controle através do método `setCommand(int slot, Command onCommand, Command offCommand)`
```java
// Classe que representa o Invoker e possui um array de comandos (on e off) que podem ser executados

public class RemoteControlWithUndo {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControlWithUndo() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
          onCommands[i] = noCommand;
          offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }
}
```

<br>

Depois implementamos um `Command` (exemplo implementando um comando para ligar uma lâmpada). Esse comando precisa ter uma referência para um `Receiver` (que é quem de fato vai executar a ação esperada, e nesse caso nosso Receiver é a lâmpada). O nosso comando irá delegar para a lâmpada, através do método `execute()` a ação a ser executada.
```java
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
```