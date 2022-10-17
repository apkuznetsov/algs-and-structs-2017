package kuznetsov;

// Given an array of integers arr, return true if and only if it is a valid mountain array.
//
// Recall that arr is a mountain array if and only if:
// 1) arr.length >= 3
// 2) There exists some i with 0 < i < arr.length - 1 such that:
// *  arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// *  arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
public class ValidMountainArray {

    public boolean validMountainArray(int[] a) {
        boolean isSmallArray = (a == null || a.length < 3);
        if (isSmallArray) return false;

        boolean isIncreasing = a[0] < a[1];
        if (!isIncreasing) return false;

        for (int i = 1; i < a.length; i++) {
            boolean isPlateau = (a[i - 1] == a[i]);
            if (isPlateau) return false;

            if (isIncreasing) {
                boolean isPeak = (a[i - 1] > a[i]);
                if (isPeak) isIncreasing = false;
            } else {
                boolean isNotDecreasing = (a[i - 1] < a[i]);
                if (isNotDecreasing) return false;
            }
        }

        boolean wasPeakReached = !isIncreasing;
        return wasPeakReached;
    }
}
