package decorator.implementation.decorators;

import decorator.implementation.beverages.Beverage;

public abstract class CondimentDecorator extends Beverage {
  public abstract String getDescription();
}
