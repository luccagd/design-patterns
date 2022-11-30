# Iterator

### Definição oficial
> O Padrão Iterator fornece uma maneira de acessar sequencialmente os elementos de um objeto agregado sem expor a sua representação subjacente.

<p align="center">
  <img src="https://refactoring.guru/images/patterns/diagrams/iterator/structure.png" />
</p>
<br>

### Aplicabilidade
Utilize o padrão Iterator:
* quando você quer que seu código seja capaz de percorrer diferentes estruturas de dados ou quando os tipos dessas estruturas são desconhecidos de antemão.
* quando sua coleção tiver uma estrutura de dados compelxa por debaixo dos panos, mas você quer esconder a complexiadade dela de seus clientes (seja por motivos de conveniência ou segurança).
* para reduzir a duplicação de código de travessia em sua aplicação.

<br>

### Prós e contras
:white_check_mark: Princípio de responsabilidade única. Você pode limpar o código cliente e as coleções ao extrair os pesados algoritmos de travessia para classes separadas.

:white_check_mark: Princípio aberto/fechado. Você pode implementar novos tipos de coleções e iteradores e passá-los para o código existente sem quebrar coisa alguma.

:white_check_mark: Você pode iterar sobre a mesma coleção em paralelo porque cada objeto iterador contém seu próprio estado de iteração.

:white_check_mark: Pelas mesmmas razões você pode atrasar uma iteração e continuá-la quando necessário.

<br>

:x: Aplicar o padrão pode ser um preciosimo se sua aplicação só trabalha com coleções simples.

:x: Usar um iterator pode ser menos eficiente que percorrer elementos de algumas coleções especializadas diretamente.

<br>

### Referências
[Head First! Design Patterns](https://www.amazon.com.br/Head-First-Design-Patterns-Freeman/dp/0596007124)

[Refactoring Guru - Iterator](https://refactoring.guru/pt-br/design-patterns/iterator)

[Otávio Miranda - Iterator Teoria](https://www.youtube.com/watch?v=7ndeSYdmOdE)
