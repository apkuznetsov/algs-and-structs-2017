package kuznetsov;

public class Main {

  public static void main(String[] args) {
//    int[] nums = new int[] {1, 1, 1, 1, 1};
//    int target = 3;
    int[] nums = new int[] {1, 0};
    int target = 1;

    System.out.println(
        findTargetSumWays(nums, target)
    );
  }

  public static int findTargetSumWays(int[] nums, int target) {
    return findTargetSumWaysRecursive(nums, target, 0, 0);
  }

  public static int findTargetSumWaysRecursive(int[] nums, int target, int currIdx, int currSum) {
    if (currIdx >= nums.length) {
      return 0;
    }

    if (currIdx == (nums.length - 1)) {
      int a = (currSum + nums[currIdx]) == target ? 1 : 0;
      int b = (currSum - nums[currIdx]) == target ? 1 : 0;
      return a + b;
    }

    int counter = 0;
    counter += findTargetSumWaysRecursive(nums, target, currIdx + 1, currSum + nums[currIdx]);
    counter += findTargetSumWaysRecursive(nums, target, currIdx + 1, currSum - nums[currIdx]);
    return counter;
  }

}
