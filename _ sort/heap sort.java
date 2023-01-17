package kuznetsov;

public class Main {

  public static void print(int[] arr) {
      for (int i : arr) {
          System.out.print(i + " ");
      }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = {12, 11, 13, 5, 6, 7};

    Main main = new Main();
    main.sortWithHeap(arr);

    System.out.println("sorted array ... ");
    print(arr);
  }

  public void sortWithHeap(int[] arr) {
    int len = arr.length;

      for (int i = len / 2 - 1; i >= 0; i--) {
          heapify(arr, len, i);
      }

    for (int i = len - 1; i >= 0; i--) {
      int bucket = arr[0];
      arr[0] = arr[i];
      arr[i] = bucket;

      heapify(arr, i, 0);
    }
  }

  public void heapify(int[] arr, int heapSize, int iRoot) {
    int iLargest = iRoot;
    int iLeft = 2 * iRoot + 1;
    int iRight = 2 * iRoot + 2;

      if (iLeft < heapSize && arr[iLeft] > arr[iLargest]) {
          iLargest = iLeft;
      }

      if (iRight < heapSize && arr[iRight] > arr[iLargest]) {
          iLargest = iRight;
      }

    if (iLargest != iRoot) {
      int bucket = arr[iRoot];
      arr[iRoot] = arr[iLargest];
      arr[iLargest] = bucket;

      heapify(arr, heapSize, iLargest);
    }
  }
}
