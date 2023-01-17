package kuznetsov;

import java.util.Scanner;

/**
 * https://stepic.org/lesson/Наибольшая-возрастающая-подпоследовательность-13257/step/6?unit=3442
 * https://sites.google.com/site/indy256/algo/lis_nlogn
 * http://e-maxx.ru/algo/longest_increasing_subseq_log
 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 * http://www.capacode.com/array/longest-increasing-subsequence-in-on-log-n-time/
 */

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int[] a = new int[in.nextInt()];
    for (int i = 0; i < a.length; i++) {
      a[i] = in.nextInt();
    }

    int[] lis = lis(a);
    System.out.println(lis.length);

    for (int li : lis) {
      System.out.print(li + " ");
    }
  }

  public static int[] lis(int[] a) {
    int[] tail = new int[a.length];
    int[] prev = new int[a.length];

    int len = 0;
    int pos;
    for (int i = 0; i < a.length; i++) {
      pos = lowerBound(a, tail, len, a[i]);

      if (pos == len) {
        ++len;
      }

      prev[i] = pos > 0 ? tail[pos - 1] : -1;
      tail[pos] = i;
    }

    int[] res = new int[len];
    for (int i = tail[len - 1]; i >= 0; i = prev[i]) {
      --len;
      res[len] = i + 1;
    }

    return res;
  }

  public static int lowerBound(int[] a, int[] tail, int len, int key) {
    int lower = -1;
    int higher = len;

    while (higher - lower > 1) {
      int mid = (lower + higher) >>> 1;

      if (a[tail[mid]] >= key) {
        lower = mid;
      } else {
        higher = mid;
      }
    }

    return higher;
  }

}
