package kuznetsov;

// Задана отсортированная по неубыванию последовательность из N чисел и число X.
public class BinarySearch {

    public static int binarySearch(int[] sortedNums, int x) {
        int resIdx = -1;
        int left = 0;
        int right = sortedNums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (sortedNums[mid] > x) {
                right = mid - 1;
            } else if (sortedNums[mid] < x) {
                left = mid + 1;
            } else if (sortedNums[mid] == x) {
                resIdx = mid;
                break;
            }
        }

        return resIdx;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 6, 7, 8};
        int x = 6;

        System.out.println(binarySearch(nums, x));
    }
}
