package kuznetsov;

// Given an array nums of integers, return how many of them contain an even number of digits.
public class FindNumbers {

    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int evensCnt = 0;

        for (int num : nums) {
            if (countDigits(num) % 2 == 0) {
                evensCnt++;
            }
        }

        return evensCnt;
    }

    private static int countDigits(int number) {
        int cnt = 1;

        while (number / 10 > 0) {
            cnt++;
            number = number / 10;
        }

        return cnt;
    }
}
