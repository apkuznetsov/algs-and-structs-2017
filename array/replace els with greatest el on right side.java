package kuznetsov;

import java.util.Arrays;

// Given an array arr,
// replace every element in that array with the greatest element among the elements to its right,
// and replace the last element with -1.
//
// After doing so, return the array.
public class ReplaceElsWithGreatestElOnRightSide {

  public static void main(String[] args) {
    int[] a = {17, 18, 5, 4, 6, 1};
    a = replaceElements(a);
    System.out.println(Arrays.toString(a));
  }

  public static int[] replaceElements(int[] arr) {
      if (arr == null) {
          return arr;
      }
    if (arr.length == 1) {
      arr[0] = -1;
      return arr;
    }

    int lastIdx = arr.length - 1;
    int max = arr[lastIdx];
    arr[lastIdx] = -1;
    lastIdx--;

    for (int i = lastIdx; i >= 0; i--) {
      int currVal = arr[i];
      arr[i] = max;
      max = Math.max(max, currVal);
    }

    return arr;
  }

}
