package kuznetsov;

import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    System.out.println(

    );
  }

  public int fourSumCount(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
    HashMap<Integer, Integer> sum_to_counter = new HashMap<Integer, Integer>();
    for (int a : arr1) {
      for (int b : arr2) {
        sum_to_counter.put(a + b, sum_to_counter.getOrDefault(a + b, 0) + 1);
      }
    }

    int count = 0;
    for (int c : arr3) {
      for (int d : arr4) {
        count += sum_to_counter.getOrDefault(-c - d, 0);
      }
    }

    return count;
  }

}
