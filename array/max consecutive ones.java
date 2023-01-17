package kuznetsov;

// Given a binary array nums, return the maximum number of consecutive 1's in the array.
public class FindMaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int currCnt = 0;
        int maxCnt = 0;

        for (int num : nums) {
            if (num == 0) {
                maxCnt = Math.max(currCnt, maxCnt);
                currCnt = 0;
            } else if (num == 1) {
                currCnt++;
            }
        }

        maxCnt = Math.max(currCnt, maxCnt);
        return maxCnt;
    }
}