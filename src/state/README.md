# State

### Definição oficial
> O Padrão State permite que um objeto altere o seu comportamento quando o seu estado interno muda. O ojbeto parecerá ter mudado de classe

<p align="center">
  <img src="https://refactoring.guru/images/patterns/diagrams/state/structure-pt-br.png?id=758acf6e428ac1e9703cca2f9d92a5ac" />
</p>
<br>

### Aplicabilidade
Utilize o padrão State:
* quando você tem um objeto que se comporta de maneira diferente dependendo do seu estado atual, quando o número de estados é enorme, e quando o código estado específico muda com frenquência.
* quando você tem uma classe populada com condicionais gigantes que alteram como a classe se comporta de acordo com os valores atuais dos campos da classe.
* quando você tem muito código duplicado em muitos estados parecidos e transições de uma máquina de estado baseada em condições.

<br>

### Prós e contras
:white_check_mark: Princípio de responsabilidade única. Organiza o código relacionado a estados particulares em classes separadas.

:white_check_mark: Princípio aberto/fechado. Introduz novos estados sem mudar classes de estado ou contexto existentes.

:white_check_mark: Simplifica o código de contexto ao eliminar condicionais de máquinas de estados pesadas.

<br>

:x: Aplicar o padão pode ser um exagero se a máquina de estado só tem alguns estados ou raramente muda eles

<br>

### Referências
[Head First! Design Patterns](https://www.amazon.com.br/Head-First-Design-Patterns-Freeman/dp/0596007124)

[Refactoring Guru - State](https://refactoring.guru/pt-br/design-patterns/state)

[Otávio Miranda - State Teoria](https://www.youtube.com/watch?v=tSTPS2oHDmw)

[Otávio Miranda - State Prática](https://www.youtube.com/watch?v=a1JoummFS04)
