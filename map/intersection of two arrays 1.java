package kuznetsov;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    int[] nums1 = new int[] {1, 2, 2, 1};
    int[] nums2 = new int[] {2, 2};
    int[] intersectArr = intersection(nums1, nums2);
    System.out.println(Arrays.toString(intersectArr));
  }

  public static int[] intersection(int[] nums1, int[] nums2) {
    int[] longerArr = nums1.length > nums2.length ? nums1 : nums2;
    int[] shorterArr = nums1.length <= nums2.length ? nums1 : nums2;

    Set<Integer> longerSet = new HashSet<>(longerArr.length);
    for (int n : longerArr) {
      longerSet.add(n);
    }

    Set<Integer> intersectSet = new HashSet<>(shorterArr.length);
    for (int n : shorterArr) {
      if (longerSet.contains(n)) {
        intersectSet.add(n);
      }
    }

    int[] intersectArr = new int[intersectSet.size()];
    int i = 0;
    for (int n : intersectSet) {
      intersectArr[i] = n;
      i++;
    }
    return intersectArr;
  }

}
