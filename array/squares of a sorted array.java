package kuznetsov;

public class Main {

  public static void main(String[] args) {
    System.out.println(

    );
  }

  private int pow(int num) {
    return num * num;
  }

  public int[] sortedSquares(int[] nums) {
    if (nums.length == 0) {
      return nums.clone();
    }
    if (nums.length == 1) {
      int[] temp = nums.clone();
      temp[0] = pow(temp[0]);
      return temp;
    }

    int[] res = new int[nums.length];
    int wrtIdx = nums.length - 1;
    int left = 0;
    int right = nums.length - 1;

    int powedLeftNum = pow(nums[left]);
    int powedRightNum = pow(nums[right]);
    while (left != right) {
      if (powedLeftNum > powedRightNum) {
        res[wrtIdx] = powedLeftNum;
        left++;
        powedLeftNum = pow(nums[left]);
      } else {
        res[wrtIdx] = powedRightNum;
        right--;
        powedRightNum = pow(nums[right]);
      }

      wrtIdx--;
    }
    res[wrtIdx] = pow(nums[left]);

    return res;
  }

}
