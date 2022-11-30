# Exemplo de implementação

**Cenário:** aqui vamos utilizar o mesmo cenário de cardápios mostrado no [exemplo de implementação do padrão Iterator](https://github.com/luccagdias/design-patterns/tree/main/iterator), onde queríamos imprimir na tela diferentes cardápios de um restaurante. 

Porém, agora temos uma pequena diferença: os cardápios podem ter tanto itens como também outros cardápios dentro dele (como um sub cardápio). Isso faz com que tenhamos uma estrutura de árvore, onde as folhas (leaf) são os itens e os nós (nodes) são outros cardápios.

<br>

### Sem o padrão Composite
Como agora temos uma uma estrutura de árvore, onde podemos ter tanto itens como outros cardápios, a iteração sobre esses objetos se tornam um problema, pois são de tipos diferentes.
Uma saída seria ter duas coleções, uma para itens e outras para cardápios, mas isso traz mais complexidade e repetição de código.

O polimorfismo pode nos ajudar nisso.

<br>

### Com o padrão Composite
Primeiro precisamos generalizar o conceito de itens e cardápios e tratá-los de uma mesma maneira.

Criamos uma classe abstrata `MenuComponent` que contém os comportamentos tanto de itens como de cardápios. Todos os métodos por padrão irão lançar uma `UnsupportedOperationException` , para que suas classes filhas sobrescrevam apenas métodos que façam sentido para seu contexto.
```java
public abstract class MenuComponent {

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
    
    public String getName() {
        throw new UnsupportedOperationException();
    }
    
    public String getDescription() {
        throw new UnsupportedOperationException();
    }
    
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
    
    public void print() {
        throw new UnsupportedOperationException();
    }
}
```
<br>

Depois disso, criamos as classes `Menu` (que representa o cardápio) e `MenuItem` (que representa um item do cardápio), e fazemos com que elas herdem de `MenuComponent`.
Nessas novas duas classes, sobrescrevemos apenas os métodos que fazem sentido para seu contexto.

Exemplo: não faz sentido que a classe `MenuItem` sobrescreva o método `getChild(int i)`, pois ela é um item do cardápio (portanto não tem "filhos"). Porém, faz sentido que a classe `Menu` sobrescreva este método, pois ela é um cardápio e pode ter filhos (como já comentado, esses "filhos" podem ser tanto itens como outros cardápios).



```java
// Classe que representa um cardápio

public class Menu extends MenuComponent {
  List<MenuComponent> menuComponents = new ArrayList<>();
  String name;
  String description;

  public Menu(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public void add(MenuComponent menuComponent) {
    menuComponents.add(menuComponent);
  }

  public void remove(MenuComponent menuComponent) {
    menuComponents.remove(menuComponent);
  }

  public MenuComponent getChild(int i) {
    return menuComponents.get(i);
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void print() {
    System.out.print("\n" + getName());
    System.out.println(", " + getDescription());
    System.out.println("---------------------");

    for (MenuComponent menuComponent : menuComponents) {
      menuComponent.print();
    }
  }
}
```

```java
// Classe que representa um item do cardápio

public class MenuItem extends MenuComponent {
  String name;
  String description;
  boolean vegetarian;
  double price;

  public MenuItem(String name, String description, boolean vegetarian, double price) {
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public double getPrice() {
    return price;
  }

  public void print() {
    System.out.print("   " + getName());
    if (isVegetarian()) {
      System.out.print("(v)");
    }

    System.out.println(", " + getPrice());
    System.out.println("    -- " + getDescription());
  }
}
```
