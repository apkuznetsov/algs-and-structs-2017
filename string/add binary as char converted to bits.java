package kuznetsov;

public class Main {
  public static void main(String[] args) {
    System.out.println(
        addBinary("111", "1")
    );
  }

  public static String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();

    int aIdx = a.length() - 1;
    int bIdx = b.length() - 1;
    int carry = 0;

    while (aIdx >= 0 || bIdx >= 0) {
      int sum = carry;
      if (aIdx >= 0) {
        sum += a.charAt(aIdx) - '0';
      }
      if (bIdx >= 0) {
        sum += b.charAt(bIdx) - '0';
      }
      aIdx--;
      bIdx--;
      sb.insert(0, sum % 2);
      carry = sum / 2;
    }

    if (carry > 0) {
      sb.insert(0, 1);
    }

    return sb.toString();
  }
}
