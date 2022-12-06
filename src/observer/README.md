# Observer

### Definição oficial
> O Padrão Observer define a dependência um-para-muitos entre objetos para que quando um objeto mude de estado todos os seus dependentes sejam avisados automaticamente.

<p align="center">
  <img src="https://refactoring.guru/images/patterns/diagrams/observer/structure.png?id=365b7e2b8fbecc8948f34b9f8f16f33c" />
</p>

<br>

### Aplicabilidade
Utilize o padrão Observer:
* quando você precisa notificar vários objetos sobre a mudança de estado de outro(s) objeto(s).

<br>

### Prós e contras
:white_check_mark: Princípio aberto/fechado. Você pode introduzir novas classes assinantes sem ter que mudar o código da publicadora (e vice versa se existe uma interface publicadora).

:white_check_mark: Você pode estabelecer relações entre objetos durante a execução.

<br>

:x: Assinantes são notificados em ordem aleatória. Pode ser complexo ou impossível manter a ordem em que as notificações são enviadas.

<br>

### Referências
[Head First! Design Patterns](https://www.amazon.com.br/Head-First-Design-Patterns-Freeman/dp/0596007124)

[Refactoring Guru - Observer](https://refactoring.guru/pt-br/design-patterns/observer)

[Otávio Miranda - Observer Teoria](https://www.youtube.com/watch?v=iMV1aHaijhQ)

[Otávio Miranda - Observer Prática](https://www.youtube.com/watch?v=qjvKY1pk2dU)
