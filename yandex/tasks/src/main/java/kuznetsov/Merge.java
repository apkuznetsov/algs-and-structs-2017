package kuznetsov;

// Даны две отсортированные последовательности чисел (длиной N и M соответственно)
// Необходимо слить их в одну отсортированную последовательность.
public class Merge {

    public int[] merge(int[] nums1, int[] nums2) {
        int[] mergedNums = new int[nums1.length + nums2.length];
        int ptr1 = 0;
        int ptr2 = 0;

        for (int k = 0; k < mergedNums.length; k++) {
            if (ptr1 < nums1.length
                    && (ptr2 == nums2.length)
                    || (nums1[ptr1] <= nums2[ptr2])) {
                mergedNums[k] = nums2[ptr1];
                ptr1 += 1;
            } else {
                mergedNums[k] = nums2[ptr2];
                ptr2 += 1;
            }
        }

        return mergedNums;
    }
}
