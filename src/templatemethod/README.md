# Template Method

### Definição oficial
> O Padrão Template Method define o esqueleto de um algoritmo dentro de um método, trnasferindo alguns de seus passos para as subclasses. O Template Method permite que as subclasses redefinam certos passos de um algoritmo sem alterar a estrutura do prórpio algoritmo.

<p align="center">
  <img src="https://refactoring.guru/images/patterns/diagrams/template-method/structure.png?id=924692f994bff6578d8408d90f6fc459" />
</p>

### Aplicabilidade
Use o padrão Template Method:
* quando você quer deixar os clientes sobrescreverem apenas etapas particulares de um algoritmo, mas não todo o algoritmo e sua estrutura.
* quando você tem várias classes que contém algoritmos quase idênticos com algumas diferenças menores. Como resultado, você pode querer modificar todas as classes quando o algoritmo muda.

<br>

### Prós e contras

:white_check_mark: Você pode deixar clientes sobrescreverem apenas certas partes de um algoritmo grande, tornando-os menos afetados por mudanças que acontecem por outras partes do algoritmo.

:white_check_mark: Você pode elevar o código duplicado para uma superclasse.

:x: Alguns clientes podem ser limitados ao fornecer o esqueleto de um algoritmo.

:x: Você pode violar o princípio de substituição de Liskov ao suprimir uma etapa padrão de implementação através da subclasse.

:x: Implementações do padrão Template Method tentem a ser mais difíceis de se manter quanto mais etapas eles tiverem.

### Referências
[Head First! Design Patterns](https://www.amazon.com.br/Head-First-Design-Patterns-Freeman/dp/0596007124)

[Refactoring Guru - Template Method](https://refactoring.guru/pt-br/design-patterns/template-method)

[Otávio Miranda - Template Method Teoria](https://www.youtube.com/watch?v=-nSOKE4f2gA)

[Otávio Miranda - Template Method Prática](https://www.youtube.com/watch?v=Adosr_aCTMI)
