package decorator.implementation.beverages;

public class DarkRoastCoffe extends Beverage {

  public DarkRoastCoffe() {
    description = "Dark Roast Coffe";
  }

  @Override
  public double cost() {
    return .99;
  }
}
