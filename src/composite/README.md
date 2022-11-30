# Composite

### Definição oficial
> O Padrão Composite permite que você componha objetos em estruturas de árvore para representar hierarquias parte-todo. Com esse padrão, os cientes podem tratar objetos individuais ou composições de objetos de maneira uniforme.

<br>

### Aplicabilidade
Utilize o padrão Composite:
* quando você tem que implementar uma estrutura de objetos tipo árvore.
* quando você quer que o código trate tanto os objetos simples como os compostos de forma uniforme.

<br>

### Prós e contras
:white_check_mark: Você pode trabalhar com estruturas de árvore complexas mais convenientemente: utilize o polimorfismo e a recursão a seu favor.

:white_check_mark: Princípio aberto/fechado. Você pode introduzir novos tipos de elemento na aplicação sem quebrar o código existente, o que agora funciona com a árvore de objetos.
<br>

:x: Pode ser difícil providenciar uma interface comum para classes cuja funcionalidade difere muito. Em certos cenários, você precisaria generalizar muito a interface compontente, fazendo dela uma interface de difícil compreensão.

:x: Dependendo da estrutura, pode quebrar o princípio da segregação de interface (ISP). Objetos do tipo "Leaf" (folha) tentem a ter métodos que não usam ou não fazem nada.

<br>

### Referências
[Head First! Design Patterns](https://www.amazon.com.br/Head-First-Design-Patterns-Freeman/dp/0596007124)

[Refactoring Guru - Composite](https://refactoring.guru/pt-br/design-patterns/composite)

[Otávio Miranda - Composite Teoria](https://www.youtube.com/watch?v=I0RqHDFQjVY)
