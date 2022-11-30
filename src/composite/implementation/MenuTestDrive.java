package composite.implementation;

import composite.implementation.menus.Menu;
import composite.implementation.menus.MenuComponent;
import composite.implementation.menus.MenuItem;

public class MenuTestDrive {
  public static void main(String[] args) {
    MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
    MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
    MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

    MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

    allMenus.add(pancakeHouseMenu);
    allMenus.add(dinerMenu);

    pancakeHouseMenu.add(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99));
    pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99));
    pancakeHouseMenu.add(new MenuItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49));
    pancakeHouseMenu.add(new MenuItem("Waffles", "Waffles with your choice of blueberries or strawberries", true, 3.59));

    dinerMenu.add(new MenuItem("Vegetarian BLT", "(Fakin´) Bacon with lettuce & tomato on whole wheat", true, 2.99));
    dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
    dinerMenu.add(new MenuItem("Soup of de day", "Soup of the day, with a side of potato salad", false, 3.29));
    dinerMenu.add(new MenuItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05));
    dinerMenu.add(dessertMenu);

    dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flake crust, topped with vanilla ice cream", true, 1.59));

    Waitress waitress = new Waitress(allMenus);
    waitress.printMenu();
  }
}
