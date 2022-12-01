# Exemplo de implementação

**Cenário:** temos uma máquina de goma de mascar, na qual podemos inserir uma moeda para receber uma goma. Esta máquina passa por diferentes estados conforme o seu uso, sendo eles:
* Sem moeda
* Recebeu moeda
* Goma vendida
* Gomas acabaram



Conforme recebe determinadas ações, desejamos que a nossa máquina gerencie o seu estado interno, passando de um estado a outro e que nos informe se determinada ação é inválida para o estado atual.

## Sem o padrão State
Quando uma ação é executada na nossa máquina de goma de mascar, ela deve verificar se a ação é válida para o seu estado atual.

Para fazer essa verificação, ela deve ter uma instrução `if` verificando cada possível estado em que ela pode estar e dando uma resposta apropriada caso a ação seja inválida, ou executando a ação caso ela seja válida e alterando a máquina para outro estado.

Isso facilmente quebra o princípio aberto/fechado do SOLID, pois para cada novo estado que a máquina possuir, várias instruções `if` devem ser criadas. A complexidade ao longo do tempo tende a aumentar muito e o código fica mais suscetível a erros a cada nova alteração.

*Um pequeno exemplo de código de uma máquina de goma de mascar que gerencia seu estado através de instruções `if`*
```java
final static int SOLD_OUT = 0;
final static int NO_QUARTER = 1;
final static int HAS_QUARTER = 2;
final static int SOLD = 3;

int state = SOLD_OUT;

public void insertQuarter() {
    if (state == HAS_QUARTER) {
        System.out.println("You can't insert another quarter");
    } else if (state == NO_QUARTER) {
        state = HAS_QUARTER;
        System.out.println("You inserted a quarter");
    } else if (state == SOLD_OUT) {
        System.out.println("You can't insert a quarter, the machine is sold out");
    } else if (state == SOLD) {
        System.out.println("Please wait, we're already giving you a gumball");
    }
}

public void ejectQuarter() {
    if (state == HAS_QUARTER) {
        System.out.println("Quarter returned");
        state = NO_QUARTER;
    } else if (state == NO_QUARTER) {
        System.out.println("You haven't inserted a quarter");
    } else if (state == SOLD) {
        System.out.println("Sorry, you already turned the crank");
    } else if (state == SOLD_OUT) {
        System.out.println("You can't eject, you haven't inserted a quarter");
    }
}

public void turnCrank() {
    if (state == SOLD) {
        System.out.println("Turning twice doesn't get you another gumball");
    } else if (state == NO_QUARTER) {
        System.out.println("You turned but there's no quarter");
    } else if (state == SOLD_OUT) {
        System.out.println("You turned, but there are no gumballs");
    } else if (state == HAS_QUARTER) {
        System.out.println("You turned...");
        state = SOLD;
        dispense();
    }
}
```

## Com o padrão State
Quando aplicamos o padrão State, separamos cada estado da máquina em uma classe específica. Cada uma dessas classes que representam os estados deve implementar uma interface que generaliza o comportamento de um estado.

Na classe que representa a máquina de goma de mascar, precisamos adicionar uma variável de instância para casa possível estado que ela pode estar.

Precisamos também criar uma variável que indique qual o estado da máquina no momento, e vamos delegar para este estado as ações que forem solicitadas para a máquina. Cada estado deve ser reponsável por dizer se ação é inválida para ele ou não, e deve ser responsável também por indicar qual o próximo estado que a máquina deve ir (caso a ação seja válida).
```java
private State soldOutState;
private State noQuarterState;
private State hasQuarterState;
private State soldState;

private State state = soldOutState;

// Método construtor aqui...

public void insertQuarter() {
    state.insertQuarter();
}

public void ejectQuarter() {
    state.ejectQuarter();
}

public void turnCrank() {
    state.turnCrank();
}
```

<br>

*Exemplo de como um dos estados lida com as ações solicitadas a ele:*
```java
public class HasQuarterState implements State {
    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }
```
