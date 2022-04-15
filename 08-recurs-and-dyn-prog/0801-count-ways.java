/* 8.1. Ребёнок поднимается по лестнице из n ступене.
 * За один шаг он может переместиться на одну, две или три ступеньки.
 * Реализуйте метод, рассчитывающий кол-во возможных
 * вариантов перемещния ребёнка по лестнице. */

package ssau.kuznetsov;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    }

    int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1, memo)
                    + countWays(n - 2, memo)
                    + countWays(n - 3, memo);
            return memo[n];
        }
    }
}
