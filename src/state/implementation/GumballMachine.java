package state.implementation;

import state.implementation.states.HasQuarterState;
import state.implementation.states.NoQuarterState;
import state.implementation.states.SoldOutState;
import state.implementation.states.SoldState;
import state.implementation.states.State;

public class GumballMachine {

  private State soldOutState;
  private State noQuarterState;
  private State hasQuarterState;
  private State soldState;

  private State state = soldOutState;
  private int count = 0;

  public GumballMachine(int numberGumballs) {
    soldOutState = new SoldOutState(this);
    noQuarterState = new NoQuarterState(this);
    hasQuarterState = new HasQuarterState(this);
    soldState = new SoldState(this);

    this.count = numberGumballs;
    if (numberGumballs > 0) {
      state = noQuarterState;
    }
  }
  
  public void insertQuarter() {
    state.insertQuarter();
  }

  public void ejectQuarter() {
    state.ejectQuarter();
  }

  public void turnCrank() {
    state.turnCrank();
    state.dispense();
  }

  public void setState(State state) {
    this.state = state;
  }

  public void releaseBall() {
    System.out.println("A gumball comes rolling out the slot...");
    if (count != 0) {
      count -= 1;
    }
  }

  public State getSoldOutState() {
    return soldOutState;
  }

  public State getNoQuarterState() {
    return noQuarterState;
  }

  public State getHasQuarterState() {
    return hasQuarterState;
  }

  public State getSoldState() {
    return soldState;
  }

  public State getState() {
    return state;
  }

  public int getCount() {
    return count;
  }

  @Override
  public String toString() {
    StringBuffer result = new StringBuffer();
    result.append("\nMighty Gumball, Inc.");
    result.append("\nJava-enabled Standing Gumball Model #2004");
    result.append("\nInventory: " + count + " gumballs");
    result.append("\n");

    return result.toString();
  }
}
