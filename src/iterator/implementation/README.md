# Exemplo de implementação

**Cenário:** desejamos imprimir na tela diferentes cardápios de um restaurante. Cada cardápio utiliza uma estrutura de dados diferente para armazenar seus itens.

*Obs.: O Java já fornece, por padrão, Iteradores para grande parte de suas estruturas de dados. A idéia aqui foi entender como podemos criar um Iterator personalizado (como para arrays por exemplo, para o qual Java não fornece um Iterator).*

<br>

### Sem o padrão Iterator
Sem utilizar o padrão Iterator teríamos que implementar (no cliente) um loop para cada cardápio que existisse no restaurante.

Por mais que todos os cardápios implementassem uma interface `Menu` para utilizar o polimorfismo, as estruturas de dados utilizadas pelos cardápios são diferentes, então teríamos que criar um loop para cada cardápio de qualquer forma.

```java
PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
List<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();

DinerMenu dinerMenu = new DinerMenu();
MenuItem[] lunchItems = dinerMenu.getMenuItems();

for (MenuItem menuItem : breakfastItems) {
    System.out.print(menuItem.getName() + ", ");
    System.out.print(menuItem.getPrice() + " -- ");
    System.out.println(menuItem.getDescription());
}

for (int i = 0; i < dinerMenu.getNumberOfItems(); i++) {
    MenuItem menuItem=lunchItems[i];
    System.out.print(menuItem.getName()+", ");
    System.out.print(menuItem.getPrice()+" -- ");
    System.out.println(menuItem.getDescription());
}
```

Isso fere o princípio aberto/fechado do SOLID, pois a cada novo cardápio que fosse criado teríamos que adicionar um novo loop para iterar sobre seus itens.

<br>

### Com o padrão Iterator
Utilizando as classes iteradoras para cada cardápio, podemos deixar a iteração sobre cada cardápio mais genérica.

Esse caso respeita o princípio aberto/fechado pois não precisamos implementar um novo loop para cada cardápio que for criado, basta adicioná-lo na lista de cardápios a serem iterados.
```java
List<Menu> menus = List.of(new PancakeHouseMenu(), new DinerMenu());

public void printMenu() {
        for (Menu menu : menus) {
            Iterator menuIterator = menu.createIterator();
            printMenu(menuIterator);
        }
    }

private void printMenu(Iterator iterator) {
    while (iterator.hasNext()) {
        MenuItem menuItem = (MenuItem) iterator.next();
        System.out.print(menuItem.getName() + ", ");
        System.out.print(menuItem.getPrice() + " -- ");
        System.out.println(menuItem.getDescription());
    }
    System.out.println();
}
```