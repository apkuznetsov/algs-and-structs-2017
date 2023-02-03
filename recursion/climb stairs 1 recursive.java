package kuznetsov;

import java.util.HashMap;

class Main {

  private static final HashMap<Integer, Integer> cache = new HashMap<>();

  public static void main(String[] args) {
    System.out.println(
        climbStairs(44)
    );
  }

  public static int climbStairs(int n) {
    if (cache.containsKey(n)) {
      return cache.get(n);
    }

    int result;
    if (n == 0) {
      result = 1;
    } else if (n < 0) {
      result = 0;
    } else {
      result = climbStairs(n - 1) + climbStairs(n - 2);
    }
    cache.put(n, result);

    return result;
  }

}
