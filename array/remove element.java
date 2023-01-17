package kuznetsov;

// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
// The relative order of the elements may be changed.
public class RemoveElement {

  public int removeElement(int[] nums, int val) {
    int wrIdx = 0;

    for (int rdIdx = 0; rdIdx < nums.length; rdIdx++) {
      if (nums[rdIdx] != val) {
        nums[wrIdx] = nums[rdIdx];
        wrIdx++;
      }
    }

    return wrIdx;
  }
    
}
