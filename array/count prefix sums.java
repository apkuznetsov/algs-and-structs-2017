package kuznetsov;

import java.util.LinkedHashMap;
import java.util.Map;

// Дана последовательность чисел длиной N.
// Необходимо найти количество отрезков с нулевой суммой.
public class CountZeroSumRanges {

  private Map<Integer, Integer> countPrefixSums(int[] nums) {
    Map<Integer, Integer> m = new LinkedHashMap<>();
    m.put(0, 1);

    int currSum = 0;
    for (int i = 0; i < nums.length; i++) {
      currSum += nums[0];
      if (m.containsKey(currSum)) {
        int lastVal = m.get(currSum);
        m.put(currSum, lastVal + 1);
      } else {
        m.put(currSum, 1);
      }
    }

    return m;
  }

  public int countZeroSumRanges(Map<Integer, Integer> prefixSums) {
    int rangesCnt = 0;
    for (Map.Entry<Integer, Integer> e : prefixSums.entrySet()) {
      int sumCnt = e.getValue();
      rangesCnt += sumCnt * (sumCnt - 1) / 2;
    }

    return rangesCnt;
  }
  
}
