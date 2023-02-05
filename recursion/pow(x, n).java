package kuznetsov;

class Main {

  public static void main(String[] args) {
    System.out.println(
        myPow(2, -2147483648)
    );
  }

  public static double myPow(double x, int n) {
    double res;

    if (x == 0) {
      res = 0;
    } else if (n == 1) {
      res = x;
    } else {
      res = myPowHelper(x, Math.abs(n));
    }

    res = n >= 0 ? res : 1.0 / res;
    return res;
  }

  public static double myPowHelper(double x, int n) {
    if (n == 1 || n == -1) {
      return x;
    }

    double res = myPowHelper(x * x, n / 2);
    res = (n % 2 == 0) ? res : res * x;
    return res;
  }

}
