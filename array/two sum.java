package kuznetsov;

public class Main {

  public static void main(String[] args) {
  }

  public int[] twoSum(int[] n, int target) {
    int left = 0;
    int right = n.length - 1;

    while (left < right) {
      int curr = n[left] + n[right];

      if (curr == target) {
        return new int[] {left + 1, right + 1};
      }

      if (curr > target) {
        right--;
      } else {
        left++;
      }
    }

    return new int[0];
  }

}
