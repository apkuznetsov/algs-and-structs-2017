package kuznetsov;

import java.util.Arrays;

// Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
// Note that elements beyond the length of the original array are not written.
// Do the above modifications to the input array in place and do not return anything.
public class DuplicateZeros {

    public static void main(String[] args) {
        int[] a = {0, 1, 7, 6, 0, 2, 0, 7};
        //int[] a = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(a);
        System.out.println(Arrays.toString(a));
    }

    public static void duplicateZeros(int[] arr) {
        int dupsCnt = 0;
        int lastIdx = arr.length - 1;
        for (int left = 0; left <= lastIdx - dupsCnt; left++) {
            if (arr[left] == 0) {
                if (left == lastIdx - dupsCnt) {
                    arr[lastIdx] = 0;
                    lastIdx--;
                    break;
                }
                dupsCnt++;
            }
        }

        int wrtIdx = lastIdx;
        int trimmedLastIdx = lastIdx - dupsCnt;
        int currEl;
        for (int right = trimmedLastIdx; right >= 0; right--) {
            currEl = arr[right];
            if (currEl == 0) {
                arr[wrtIdx] = currEl;
                wrtIdx--;
            }
            arr[wrtIdx] = currEl;
            wrtIdx--;
        }
    }
}
