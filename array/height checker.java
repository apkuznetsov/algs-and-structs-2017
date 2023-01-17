package kuznetsov;

import java.util.Arrays;

public class Main {
  
  public static void main(String[] args) {
  }

  public int heightChecker(int[] unsortedHeights) {
    int[] sortedHeights = unsortedHeights.clone();
    Arrays.sort(sortedHeights);

    int counter = 0;
    for (int i = 0; i < unsortedHeights.length; i++) {
      if (unsortedHeights[i] != sortedHeights[i]) {
        counter++;
      }
    }

    return counter;
  }

}
