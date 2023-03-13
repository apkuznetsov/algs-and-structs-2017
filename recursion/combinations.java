package kuznetsov;

import java.util.ArrayList;
import java.util.List;

class Main {

  public static void main(String[] args) {
  }

  public static List<List<Integer>> combine(int lastNumber, int combSize) {
    List<List<Integer>> allCombs = new ArrayList<>();
    combineHelper(allCombs, new ArrayList<>(), 1, lastNumber, combSize);
    return allCombs;
  }

  public static void combineHelper(
      List<List<Integer>> allCombs, List<Integer> currComb,
      int startNumber, int lastNumber,
      int combLevel) {

    if (combLevel == 0) {
      allCombs.add(new ArrayList<>(currComb));
      return;
    }

    for (int i = startNumber; i <= lastNumber; i++) {
      currComb.add(i);
      combineHelper(allCombs, currComb, i + 1, lastNumber, combLevel - 1);
      currComb.remove(currComb.size() - 1);
    }
  }

}
