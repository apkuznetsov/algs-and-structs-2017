package kuznetsov;

public class Main {

  public static void main(String[] args) {
    System.out.println(
        pivotIndex(new int[] {2,1,-1})
    );
  }

  public static int pivotIndex(int[] nums) {
    int leftCounter = 0;
    int rightCounter = 0;

    for (int i = 1; i < nums.length; i++) {
      rightCounter += nums[i];
    }
    if (leftCounter == rightCounter) {
      return 0;
    }

    for (int i = 1; i < nums.length; i++) {
      leftCounter += nums[i - 1];
      rightCounter -= nums[i];
      if (leftCounter == rightCounter) {
        return i;
      }
    }

    return -1;
  }

}
