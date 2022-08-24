package kuznetsov;

// Дана последовательность чисел длинной N и M запросов.
// Запросы: <<Сколько нулей на полуинтервале [L, R)>>.
public class CountZeroes {

    private int[] createPrefixSum(int[] nums) {
        int[] sums = new int[nums.length + 1];

        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            int cnt = nums[i - 1] > 0 ? 0 : 1;
            sums[i] = sums[i - 1] + cnt;
        }

        return sums;
    }

    public int rsq(int[] prefixSum, int leftIncl, int rightExcl) {
        return prefixSum[leftIncl] - prefixSum[rightExcl];
    }
}
