package iterator.implementation.iterators;

import iterator.implementation.menus.MenuItem;

public class DinerMenuIterator implements Iterator {
  MenuItem[] items;
  int position = 0;

  public DinerMenuIterator(MenuItem[] items) {
    this.items = items;
  }

  @Override
  public boolean hasNext() {
    if (position >= items.length || items[position] == null) {
      return false;
    }

    return true;
  }

  @Override
  public Object next() {
    MenuItem menuItem = items[position];
    position++;
    return menuItem;
  }
}
