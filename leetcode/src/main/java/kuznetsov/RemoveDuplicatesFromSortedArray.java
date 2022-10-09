package kuznetsov;

// Given an integer array nums sorted in non-decreasing order,
// remove the duplicates in-place such that each unique element appears only once.
// The relative order of the elements should be kept the same.
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int wtIdx = 0;
        for (int rdIdx = 1; rdIdx < nums.length; rdIdx++) {
            if (nums[wtIdx] != nums[rdIdx]) {
                wtIdx++;
                nums[wtIdx] = nums[rdIdx];
            }
        }

        return wtIdx + 1;
    }
}
