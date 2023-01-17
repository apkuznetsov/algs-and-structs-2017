/* Для двух строк напишите метод, определяющий,
 * является ли одна строка перестановкой другой. */

package kuznetsov;

public class Main {

  public static void main(String[] args) {
  }

  public boolean isPermutation(String x, String y) {
    if (x.length() != y.length()) {
      return false;
    }

    int[] checkingArr = new int[256];

    char[] xChars = x.toCharArray();
    for (char ch : xChars) {
      checkingArr[ch]++;
    }

    for (int i = 0; i < y.length(); i++) {
      int ch = y.charAt(i);
      checkingArr[ch]--;
      if (checkingArr[ch] < 0) {
        return false;
      }
    }

    return true;
  }
}
