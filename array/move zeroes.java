package kuznetsov;

import java.util.Arrays;

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.
public class MoveZeroes {
    
  public static void main(String[] args) {
    int[] a = {0, 1, 0, 3, 12};
    moveZeroes(a);
    System.out.println(Arrays.toString(a));
  }

  public static void moveZeroes(int[] nums) {
    int wrtIdx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[wrtIdx] = nums[i];
        wrtIdx++;
      }
    }

    for (int i = wrtIdx; i < nums.length; i++) {
      nums[wrtIdx] = 0;
    }
  }

}
