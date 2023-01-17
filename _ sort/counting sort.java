package kuznetsov;

import java.util.Arrays;

public class CountingSorting {

  public void sort(int[] nums) {
    int minVal = Arrays.stream(nums).min().getAsInt();
    int maxVal = Arrays.stream(nums).max().getAsInt();
    int uniqueCnt = maxVal - minVal + 1;
    int[] minusedRepetitNums = new int[uniqueCnt];

    for (int num : nums) {
      int minusedCurrVal = num - minVal;
      int oldValCnt = minusedRepetitNums[minusedCurrVal];
      minusedRepetitNums[minusedCurrVal] = oldValCnt + 1;
    }

    int currNumsIdx = 0;
    for (int i = 0; i < minusedRepetitNums.length; i++) {
      int valCnt = minusedRepetitNums[i];
      int currVal = i + minVal;
      for (int j = 0; j < valCnt; j++) {
        nums[currNumsIdx] = currVal;
        currNumsIdx++;
      }
    }
  }
    
}
