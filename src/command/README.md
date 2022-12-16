# Command

### Definição oficial
> O Padrão Command encapsula uma solicitação como um objeto, o que lhe permite parametrizar outros objetos com diferentes solicitações, enfileirar ou registrar solicitações e implementar recursos de cancelamento de operações.

<p align="center">
  <img src="https://refactoring.guru/images/patterns/diagrams/command/structure.png?id=1cd7833638f4c43630f4a84017d31195" />
</p>

### Aplicabilidade
Use o padrão Command:
* quando você quer parametrizar objetos com operações.
* Quando você quer colocar operações em fila, agendar sua execução, ou executá-as remotamente.
* quando você quer implementar operações reversíveis.

<br>

### Prós e contras

:white_check_mark: Princípio de responsabilidade única. Você pode desacoplar classes que invocam operações de classes que fazem essas operações.

:white_check_mark: Princípio aberto/fechado. Você pode introduzir novos comandos na aplicação sem quebrar o código cliente existente.

:white_check_mark: Você pode implementar desfazer/refazer.

:white_check_mark: Você pode implementar a execução adiada de operações.

:white_check_mark: Você pode montar um conjunto de comandos simples em um complexo.

:x: O código pode ficar mais complicado uma vez que você está introduzindo uma nova camada entre remetente e destinatários.

<br>

### Referências
[Head First! Design Patterns](https://www.amazon.com.br/Head-First-Design-Patterns-Freeman/dp/0596007124)

[Refactoring Guru - Command](https://refactoring.guru/pt-br/design-patterns/command)

[Otávio Miranda - Command Teoria](https://www.youtube.com/watch?v=WwDnYXr7jqk)

[Otávio Miranda - Command Prática](https://www.youtube.com/watch?v=-lRzadP9kJQ)
