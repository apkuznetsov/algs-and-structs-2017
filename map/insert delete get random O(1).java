package kuznetsov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

  public static void main(String[] args) {

    // Init an empty set.
    RandomizedSet randomSet = new RandomizedSet();

    System.out.println(randomSet.remove(0));
    System.out.println(randomSet.remove(0));
    System.out.println(randomSet.insert(0));
    System.out.println(randomSet.insert(0));
    System.out.println(randomSet.insert(0));

    System.out.println(randomSet.getRandom());

    System.out.println(randomSet.remove(0));
    System.out.println(randomSet.insert(0));
  }

  static class RandomizedSet {

    ArrayList<Integer> arrlist;
    Map<Integer, Integer> map; // val => its index in list
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
      arrlist = new ArrayList<>();
      map = new HashMap<>();
      random = new Random();
    }

    public int getRandom() {
      int randIdx = random.nextInt(arrlist.size());
      return arrlist.get(randIdx);
    }

    public boolean insert(int val) {
      if (map.containsKey(val)) {
        return false;
      }

      int idx = arrlist.size();
      arrlist.add(val);
      map.put(val, idx);

      return true;
    }

    public boolean remove(int val) {
      if (!map.containsKey(val)) {
        return false;
      }

      int idx = map.get(val);
      int lastVal = arrlist.get(arrlist.size() - 1);

      arrlist.set(idx, lastVal);
      arrlist.remove(arrlist.size() - 1);
      map.put(lastVal, idx);
      map.remove(val);

      return true;
    }

  }

}