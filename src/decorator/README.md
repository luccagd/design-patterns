# Decorator

### Definição Oficial
> O Padrão Decorator anexa responsabilidades adicionais a um objeto dinamicamente. Os decoradores fornecem uma alternativa flexível de subclasse para estender a funcionalidade.

<p align="center">
  <img src="https://refactoring.guru/images/patterns/diagrams/decorator/structure-indexed.png?id=09401b230a58f2249e4c9a1195d485a0" />
</p>

<br>

### Aplicabilidade
Utilize o padrão Decorator:
* quando você precisa ser capaz de projetar comportamentos adicionais para objetos em tempo de execução sem quebrar o código que usa esses objetos.
* quando é complicado ou imposível estender o comportamento de um objeto usando herança.

<br>

### Prós e contras

:white_check_mark: Você pode estender o comportamento de um objeto sem fazer uma nova subclasse.

:white_check_mark: Você pode adicionar ou remover responsabilidades de um objeto em tempo de execução.

:white_check_mark: Você pode combinar diversos comportamentos ao envolver o objeto com múltiplos decoradores.

:white_check_mark: Princípio de responsabilidade única. Você pode dividir uma classe monolítica que implementa muitas possíveis variantes de um comportamento em diversas classes menores.

:x: É difícil remover um invólucro de uma pilha de invólucros.

:x: É difícil implementar um decorador de tal maneira que seu comportamento não dependa da ordem da pilha de decoradores.

:x: A configuração inicial do código de camadas pode ficar bastante feia.

<br>

### Referências
[Head First! Design Patterns](https://www.amazon.com.br/Head-First-Design-Patterns-Freeman/dp/0596007124)

[Refactoring Guru - Decorator](https://refactoring.guru/pt-br/design-patterns/decorator)

[Otávio Miranda - Decorator Teoria](https://www.youtube.com/watch?v=p3Dh7VjxudE)

[Otávio Miranda - Decorator Prática](https://www.youtube.com/watch?v=IjigJlX8hMM)
