package kuznetsov;

class Main {

  public static void main(String[] args) {
    System.out.println(
        myPow(2, -2147483648)
    );
  }

  public static double myPow(double x, int n) {
    double res = myPowHelper(x, Math.abs(n));
    res = n >= 0 ? res : 1.0 / res;
    return res;
  }

  public static double myPowHelper(double x, int n) {
    if (x == 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }

    double res = myPowHelper(x * x, n / 2);
    res = n % 2 == 0 ? res : x * res;
    return res;
  }

}
