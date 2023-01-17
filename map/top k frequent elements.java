package kuznetsov;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 1, 1, 2, 2, 3, 3, 3, 3};
    int k = 2;

    System.out.println(
        Arrays.toString(topKFrequent(nums, k))
    );
  }

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    return map.entrySet().stream()
        .sorted((Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2)
            -> Integer.compare(e2.getValue(), e1.getValue()))
        .limit(k)
        .mapToInt(Map.Entry::getKey)
        .toArray();
  }

}
