package kuznetsov;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    System.out.println(
        findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1})
    );
  }

  public static List<Integer> findDisappearedNumbers(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];
      int idx = Math.abs(val) - 1;

      int tempVal = nums[idx];
      if (tempVal > 0) {
        nums[idx] = -tempVal;
      }
    }

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        list.add(i + 1);
      }
    }

    return list;
  }

}
