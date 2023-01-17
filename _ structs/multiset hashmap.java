package kuznetsov;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashmapMultiset<E> implements Multiset<E> {

  private final Map<E, Integer> map = new HashMap<>();

  @Override
  public void add(E elem) {
    if (map.containsKey(elem)) {
      map.put(elem, map.get(elem) + 1);
    } else {
      map.put(elem, 1);
    }
  }

  @Override
  public void remove(E elem) {
    Integer multiplicity = map.get(elem);

    if (multiplicity == 1) {
      map.remove(elem);
    } else if (multiplicity != null && multiplicity > 1) {
      map.put(elem, map.get(elem) - 1);
    }
  }

  @Override
  public void union(Multiset<E> other) {
    Set<E> otherSet = other.toSet();

    for (E otherElem : otherSet) {
      map.put(otherElem,
          Math.max(
              other.getMultiplicity(otherElem),
              this.getMultiplicity(otherElem)));
    }
  }

  @Override
  public void intersect(Multiset<E> other) {
    Set<E> thisSet = toSet();

    for (var elem : thisSet) {
      if (!other.contains(elem)) {
        map.remove(elem);
      } else {
        map.put(elem,
            Math.min(
                getMultiplicity(elem),
                other.getMultiplicity(elem)));
      }
    }
  }

  @Override
  public int getMultiplicity(E elem) {
    Integer multiplicity = map.get(elem);

    if (multiplicity == null) {
      return 0;
    } else {
      return multiplicity;
    }
  }

  @Override
  public boolean contains(E elem) {
    return getMultiplicity(elem) > 0;
  }

  @Override
  public int numberOfUniqueElements() {
    return map.size();
  }

  @Override
  public int size() {
    int size = 0;

    for (int multiplicity : map.values()) {
      size += multiplicity;
    }

    return size;
  }

  @Override
  public Set<E> toSet() {
    // Creating a new HashSet<> object helps us avoid ConcurrentModificationException.
    // It is thrown when we try to iterate over elements of Map and modify them at the same time
    return new HashSet<>(map.keySet());
  }

}
