package kuznetsov;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    int[] a = new int[] {1, 2, 3, 1};
    int k = 3;

    System.out.println(
        containsNearbyDuplicate(a, k)
    );
  }

  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);

    for (int i = 0; i < nums.length; i++) {
      int key = nums[i];
      Integer val = map.get(key);
      if (val == null) {
        map.put(key, i);
      } else {
        boolean isDuplicate = Math.abs(i - val) <= k;
        if (isDuplicate) {
          return true;
        } else {
          map.put(key, i);
        }
      }
    }

    return false;
  }

}
