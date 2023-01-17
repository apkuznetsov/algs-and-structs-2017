package kuznetsov;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    long startTime = System.currentTimeMillis();
    new Main().run();
    long finishTime = System.currentTimeMillis();
    System.out.println(finishTime - startTime + " ms");
  }

  public static int binarySearchIterative(int[] array, int value) {
    int left = 0;
    int right = array.length - 1;

    while (right >= left) {
      int middle = (left + right) >> 1;
      if (array[middle] == value) {
        return middle;
      } else if (array[middle] > value) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return -1;
  }

  public void run() throws FileNotFoundException {
    Scanner in = new Scanner(new File("input.txt"));

    int numbersCounter = in.nextInt();
    int[] numbers = new int[numbersCounter];
    for (int i = 0; i < numbersCounter; i++) {
      numbers[i] = in.nextInt();
    }

    int requestsCounter = in.nextInt();
    int[] requests = new int[requestsCounter];
    for (int i = 0; i < requestsCounter; i++) {
      requests[i] = in.nextInt();
    }

    for (int i = 0; i < requestsCounter; i++) {
      int position = binarySearchIterative(numbers, requests[i]);
      System.out.print(position + " ");
    }
    System.out.println();
  }

  public static class Generate {
    public static void main(String[] args) throws FileNotFoundException {
      new Generate().run();
    }

    private void run() throws FileNotFoundException {
      PrintWriter printWriter = new PrintWriter("input.txt");
      Random random = new Random();

      int numbersCounter = 100_000;
      int[] a = new int[numbersCounter];
      for (int i = 0; i < numbersCounter; i++) {
        a[i] = random.nextInt(1_000_000_000);
      }
      Arrays.sort(a);

      int requestsCounter = 100_000;
      int[] b = new int[requestsCounter];
      for (int i = 0; i < requestsCounter; i++) {
        b[i] = a[random.nextInt(numbersCounter)];
      }

      printWriter.print(numbersCounter);
      for (int i = 0; i < numbersCounter; i++) {
        printWriter.print(" " + a[i]);
      }
      printWriter.println();

      printWriter.print(requestsCounter);
      for (int i = 0; i < requestsCounter; i++) {
        printWriter.print(" " + b[i]);
      }

      printWriter.close();
    }
  }

}
