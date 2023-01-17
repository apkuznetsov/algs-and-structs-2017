package kuznetsov;

public class SelectionSort {

  public static int[] sortWithSelection(int[] array) {

    for (int i = 0; i < array.length - 1; i++) {

      int indexOfMin = i; // the index of the found min

      /* iterating over the unsorted subarray to find the min */
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[indexOfMin]) {
          indexOfMin = j;
        }
      }

      /* Exchanging the found min and the current element */
      int min = array[indexOfMin];
      array[indexOfMin] = array[i];
      array[i] = min;
    }

    return array;
  }
}
