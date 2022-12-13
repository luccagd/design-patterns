package decorator.implementation;

import decorator.implementation.beverages.Beverage;
import decorator.implementation.beverages.DarkRoastCoffe;
import decorator.implementation.beverages.Expresso;
import decorator.implementation.beverages.HouseBlend;
import decorator.implementation.decorators.Mocha;
import decorator.implementation.decorators.Soy;
import decorator.implementation.decorators.Whip;

public class StarbuzzCoffeTestDrive {

  public static void main(String[] args) {
    Beverage expresso = new Expresso();
    System.out.println(expresso.getDescription() + " $" + expresso.cost());

    Beverage darkRoastCoffe = new DarkRoastCoffe();
    darkRoastCoffe = new Mocha(darkRoastCoffe);
    darkRoastCoffe = new Mocha(darkRoastCoffe);
    darkRoastCoffe = new Whip(darkRoastCoffe);
    System.out.println(darkRoastCoffe.getDescription() + " $" + darkRoastCoffe.cost());

    Beverage houseBlend = new HouseBlend();
    houseBlend = new Soy(houseBlend);
    houseBlend = new Mocha(houseBlend);
    houseBlend = new Whip(houseBlend);
    System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
  }
}
