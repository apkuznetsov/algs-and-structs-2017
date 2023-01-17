package kuznetsov;

import java.util.Arrays;

public class Main {
  
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(plusOne(new int[] {9}))
    );
  }

  public static int[] plusOne(int[] digits) {
    int plusOne = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      plusOne = digits[i] + 1;
      if (plusOne == 10) {
        digits[i] = 0;
      } else {
        digits[i] = plusOne;
        break;
      }
    }

    if (plusOne == 10) {
      int[] newDigits = new int[digits.length + 1];
      newDigits[0] = 1;
      System.arraycopy(digits, 0, newDigits, 1, digits.length - 1 + 1);
      return newDigits;
    }

    return digits;
  }

}
