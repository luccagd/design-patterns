package iterator.implementation.iterators;

import iterator.implementation.menus.MenuItem;
import java.util.List;

public class PancakeHouseMenuIterator implements Iterator {
  List<MenuItem> menuItems;
  int position = 0;

  public PancakeHouseMenuIterator(List<MenuItem> menuItems) {
    this.menuItems = menuItems;
  }

  @Override
  public boolean hasNext() {
    if (position >= menuItems.size()) {
      return false;
    }
    return true;
  }

  @Override
  public Object next() {
    MenuItem menuItem = menuItems.get(position);
    position++;
    return menuItem;
  }
}
