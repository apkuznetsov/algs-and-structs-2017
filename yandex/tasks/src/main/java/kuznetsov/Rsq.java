package kuznetsov;

public class Rsq {

    private int[] createPrefixSum(int[] nums) {
        int[] sums = new int[nums.length + 1];

        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        return sums;
    }

    public int rsq(int[] prefixSum, int leftIncl, int rightExcl) {
        return prefixSum[leftIncl] - prefixSum[rightExcl];
    }
}
