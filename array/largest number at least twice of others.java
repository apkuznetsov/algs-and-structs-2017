package kuznetsov;

public class Main {

  public static void main(String[] args) {
    System.out.println(
        dominantIndex(new int[] {0, 0, 3, 2})
    );
  }

  public static int dominantIndex(int[] nums) {
    int max = -1;
    int prevMax = -1;
    int idxMax = -1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        prevMax = max;
        max = nums[i];
        idxMax = i;
      } else if (nums[i] > prevMax) {
        prevMax = nums[i];
      }
    }

    return max >= 2 * prevMax ? idxMax : -1;
  }

}
