# Exemplo de implementação

### Cenário
Temos uma empresa de café que oferece diferentes bebidas cafeinadas e diversos tipos de condimentos (como leite, soja, mocha, etc.) para adicionar à bebida. Cada bebida e cada condimento possui seu próprio valor.

O objetivo é receber um pedido de uma bebida (com ou sem condimentos), e retornar uma descrição informando o nome da bebida e todos os seus condimentos, e também informar o seu custo total (valor da bebida somado com o valor de todos os seus condimentos).

Podemos dizer que:
* estamos decorando a nossa bebida com condimentos. Os condimentos são nossos `Decorators`.
* a nossa bebida será decorada pelos condimentos. Ela é o nosso `Component`.

<br>

## Sem o padrão Decorator
Sem a utilização do padrão, poderíamos criar uma classe abstrata `Beverage` para representar uma bebida. Em seguida, criaríamos subclasses concretas para representar cada bebida disponível (por exemplo, `DecafWithMilk`, `DarkRoastWithMilkAndMocha`, `DarkRoastWithSoy`).

Essa abordagem causaria uma explosão de classes, pois para cada possível combinação de bebida e condimentos, seria necessária uma nova classe para representá-la. Além disso, pense em um cenário em que o preço de um dos condimentos mude. A alteração teria que ser feita em cada uma das classes onde o condimento é usado.

Até poderíamos criar uma classe para representar cada condimento, e utilizar a composição para criar as bebidas. Mas nesse caso, perdemos a flexibilidade de criar diferentes combinações em tempo de execução.

<br>

## Com o padrão decorator
No padrão Decorator, teremos uma classe abstrata (ou interface) para representar as bebidas genéricas, e subclasses concretas para representar cada bebida disponível.

Depois disso, criaremos as classes decoradoras (que nesse caso vão representar os condimentos). Cada classe decoradora deve ter uma variável de instância que representa qual bebida estamos decorando.

As classes decoradoras devem ser do mesmo tipo que as classes que elas irão decorar. Neste caso, para indicar que uma classe é um condimento, criamos a classe abstrata `CondimentDecorator`, e esta classe por sua vez herda a mesma classe utilizada para representar as bebidas (para que tenham o mesmo tipo).

```java
// Classe que representa uma bebida. 'Beverage' é a classe abstrata utilizada para generalizar as bebidas.

public class Expresso extends Beverage {

    public Expresso() {
        description = "Expresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
```

```java
// Classe que generaliza o condimento
public abstract class CondimentDecorator extends Beverage {
  public abstract String getDescription();
}

// Classe que representa um condimento concreto(nossos decoradores). 
// Para indicar que este é um condimento, herdamos de CondimentDecorator, que por sua vez herda de Beverage.
public class Mocha extends CondimentDecorator {
  Beverage beverage;

  public Mocha(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double cost() {
    return .20 + beverage.cost();
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Mocha";
  }
}
```

<br>

Dessa forma, cada decorator irá adicionar sua descrição e seu valor ao preço total da bebida. Caso o valor de um desses condimentos mude, não precisamos alterar em múltiplos pontos do código.

A seguir podemos ver um exemplo de como decorar uma bebida com condimentos (um Expresso com mocha e creme):
```java
Beverage expresso = new Expresso();

expresso = new Mocha(expresso);
expresso = new Whip(expresso);
```