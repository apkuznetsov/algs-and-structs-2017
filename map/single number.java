package kuznetsov;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Main {

  public static void main(String[] args) {

  }

  public int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int k : nums) {
      Integer oldV = map.get(k);
      int newV = (oldV == null) ? 1 : oldV + 1;
      map.put(k, newV);
    }

    for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
      if (kv.getValue() == 1) {
        return kv.getKey();
      }
    }

    throw new NoSuchElementException();
  }

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      if (set.contains(n)) {
        return true;
      }
      set.add(n);
    }
    return false;
  }

}
