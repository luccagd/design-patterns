package observer.implementation.subjects;

import observer.implementation.observers.Observer;

public interface Subject {
  void registerObserver(Observer observer);
  void removeObserver(Observer observer);
  void notifyObservers();
}
