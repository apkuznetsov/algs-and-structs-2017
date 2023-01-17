package kuznetsov;

import java.util.Arrays;

public class Main {
  
  public static void main(String[] args) {
    int[] nums = new int[] {-1, -100, 3, 99};
    int k = 2;
    System.out.println(Arrays.toString(nums));
    rotate(nums, k);
    System.out.println(Arrays.toString(nums));
  }

  public static void rotate(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

}
