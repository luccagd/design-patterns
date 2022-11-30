package iterator.implementation;

import iterator.implementation.iterators.Iterator;
import iterator.implementation.menus.Menu;
import iterator.implementation.menus.MenuItem;
import java.util.List;

public class Waitress {
  List<Menu> menus;

  public Waitress(List<Menu> menus) {
    this.menus = menus;
  }

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
}
