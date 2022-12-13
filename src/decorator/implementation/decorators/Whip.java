package decorator.implementation.decorators;

import decorator.implementation.beverages.Beverage;

public class Whip extends CondimentDecorator {
  Beverage beverage;

  public Whip(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double cost() {
    return .10 + beverage.cost();
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", Whip";
  }
}
