package kuznetsov;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {

  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> mapValToIdx = new HashMap<>();

    for (int idx2 = 0; idx2 < nums.length; idx2++) {
      Integer idx1 = mapValToIdx.get(target - nums[idx2]);
      if (idx1 != null) {
        return new int[] {idx1, idx2};
      }
      mapValToIdx.put(nums[idx2], idx2);
    }

    return null;
  }

}
