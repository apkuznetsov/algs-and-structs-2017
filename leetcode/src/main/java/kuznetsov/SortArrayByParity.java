package kuznetsov;

// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
// Return any array that satisfies this condition.
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] a) {
        int i = 0, j = a.length - 1;

        while (i < j) {
            if (a[i] % 2 > a[j] % 2) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }

            if (a[i] % 2 == 0) i++;
            if (a[j] % 2 == 1) j--;
        }

        return a;
    }
}
