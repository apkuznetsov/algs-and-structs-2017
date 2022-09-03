package kuznetsov;

// Дана отсортированная последовательность чисел длиной N и число K.
// Необходимо найти количество пар чисел А, Б, таких что Б-А > К.
public class CountPairsWithDiffGreaterThanK {

    public int countPairsWithDiffGreaterThanK(int[] sortedNums, int k) {
        int left = 0;
        int right = 0;
        int cnt = 0;

        for (int i = 0; i < sortedNums.length; i++) {
            while (right < sortedNums.length
                    && (sortedNums[left] - sortedNums[right] <= k)) {
                right++;
            }

            cnt += (sortedNums.length - right);
        }

        return cnt;
    }
}
