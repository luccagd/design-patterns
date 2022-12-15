# Singleton

### Definição oficial
> O Padrão Singleton garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a ela.

<p align="center">
  <img src="https://refactoring.guru/images/patterns/diagrams/singleton/structure-pt-br.png?id=151e5e19974d89c1382c5a92899784c4" />
</p>

<br>

### Aplicabilidade
Use o padrão Singleton:
* quando uma classe em seu programa deve ter apenas uma instância disponível para todos seus clientes; por exemplo, um objeto de base de dados único compartilhado por diferentes partes do programa.
* quando você precisa de um controle mais estrito sobre as variáveis globais.

<br>

### Prós e contras

:white_check_mark: Você pode ter certeza que uma classe só terá uma única instância.

:white_check_mark: Você ganha um ponto de acesso global para aquela instância.

:white_check_mark: O objeto singleton é inicializado somente quando for pedido pela primeira vez.

:x: Viola o princípio de responsabilidade única. O padrão resolve dois problemas de uma só vez.

:x: O padrão Singleton pode mascarar um design ruim, por exemplo, quando os componentes do programa sabem muito sobre cada um.

:x: O padrão requer tratamento especial em um ambiente multithreaded para que múltiplas threads não possam criar um objeto singleton várias vezes.

:x: Pode ser difícil realizar testes unitários do código cliente do Singleton porque muitos frameworks de testes dependem de herança quando produzem objetos simulados. Já que o construtor da classe singleton é privado e sobrescrever métodos estáticos é impossível na maioria das linguagens, você terá que pensar em uma maneira criativa de simular o singleton. Ou apenas não escreva os testes. Ou não use o padrão Singleton.

<br>

### Referências
[Head First! Design Patterns](https://www.amazon.com.br/Head-First-Design-Patterns-Freeman/dp/0596007124)

[Refactoring Guru - Singleton](https://refactoring.guru/pt-br/design-patterns/singleton)

[Otávio Miranda - Singleton Teoria](https://www.youtube.com/watch?v=x9h8MgAvi_I)

[Otávio Miranda - Singleton Prática](https://www.youtube.com/watch?v=JnCWTbICOWg)
