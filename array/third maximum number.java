package kuznetsov;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println(
        thirdMax(new int[] {1, 2, 2})
    );
  }

  public static int thirdMax(int[] nums) {
    if (nums.length <= 2) {
      int max = nums[0];
      for (int i = 1; i < nums.length; i++) {
        max = Math.max(max, nums[i]);
      }
      return max;
    }

    Integer[] threeMaxesNullable = new Integer[3];
    threeMaxesNullable[0] = nums[0];
    int lastIdx = 0;
    boolean isFullThreeMaxes = false;

    for (int i = 1; i < nums.length; i++) {
      int val = nums[i];

      if (threeMaxesNullable[1] == null
          && val != threeMaxesNullable[0]) {
        threeMaxesNullable[1] = val;
      } else if (threeMaxesNullable[2] == null && threeMaxesNullable[1] != null
          && (val != threeMaxesNullable[0] && val != threeMaxesNullable[1])) {
        threeMaxesNullable[2] = val;
        lastIdx = i;
        isFullThreeMaxes = true;
        break;
      }
    }

    if (!isFullThreeMaxes) {
      if (threeMaxesNullable[1] == null) {
        return threeMaxesNullable[0];
      } else {
        return threeMaxesNullable[0] > threeMaxesNullable[1] ? threeMaxesNullable[0] :
            threeMaxesNullable[1];
      }
    }

    Arrays.sort(threeMaxesNullable);

    for (int i = lastIdx + 1; i < nums.length; i++) {
      int val = nums[i];

      if (val > threeMaxesNullable[2]) {
        threeMaxesNullable[0] = threeMaxesNullable[1];
        threeMaxesNullable[1] = threeMaxesNullable[2];
        threeMaxesNullable[2] = val;
      } else if (val < threeMaxesNullable[2]
          && val > threeMaxesNullable[1]) {
        threeMaxesNullable[0] = threeMaxesNullable[1];
        threeMaxesNullable[1] = val;
      } else if (val < threeMaxesNullable[1]
          && val > threeMaxesNullable[0]) {
        threeMaxesNullable[0] = val;
      }
    }

    return threeMaxesNullable[0];
  }

}