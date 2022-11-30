package iterator.implementation;

import iterator.implementation.menus.DinerMenu;
import iterator.implementation.menus.Menu;
import iterator.implementation.menus.PancakeHouseMenu;
import java.util.List;

public class MenuTestDrive {
  public static void main(String[] args) {
    List<Menu> menus = List.of(new PancakeHouseMenu(), new DinerMenu());

    Waitress waitress = new Waitress(menus);
    waitress.printMenu();
  }
}
