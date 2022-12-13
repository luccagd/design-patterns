package decorator.implementation.decorators;

import decorator.implementation.beverages.Beverage;

public class Soy extends CondimentDecorator {
  Beverage beverage;

  public Soy(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double cost() {
    return .15 + beverage.cost();
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Soy";
  }
}
