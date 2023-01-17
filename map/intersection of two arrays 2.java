package kuznetsov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    int[] nums1 = new int[] {4, 9, 5};
    int[] nums2 = new int[] {9, 4, 9, 8, 4};
    int[] intersectArr = intersect(nums1, nums2);
    System.out.println(Arrays.toString(intersectArr));
  }

  public static int[] intersect(int[] a, int[] b) {
    int[] longerArr = a.length > b.length ? a : b;
    int[] shorterArr = a.length <= b.length ? a : b;
    Map<Integer, TwoCounters> map = new HashMap<>(shorterArr.length);

    for (int currKey : shorterArr) {
      TwoCounters oldVal = map.get(currKey);
      if (oldVal == null) {
        map.put(currKey, new TwoCounters(1, 0));
      } else {
        oldVal.counterA = oldVal.counterA + 1;
      }
    }

    for (int currKey : longerArr) {
      TwoCounters oldVal = map.get(currKey);
      if (oldVal != null) {
        oldVal.counterB = oldVal.counterB + 1;
      }
    }

    ArrayList<Integer> intersectArrlist = new ArrayList<>();
    for (Map.Entry<Integer, TwoCounters> e : map.entrySet()) {
      int key = e.getKey();
      TwoCounters val = e.getValue();
      int cnt = Math.min(val.counterA, val.counterB);
      while (cnt > 0) {
        intersectArrlist.add(key);
        --cnt;
      }
    }

    return intersectArrlist.stream().mapToInt(i -> i).toArray();
  }


  private static class TwoCounters {
    private int counterA;
    private int counterB;

    private TwoCounters(int counterA, int counterB) {
      this.counterA = counterA;
      this.counterB = counterB;
    }
  }
}
