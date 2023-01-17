package kuznetsov;

import java.util.LinkedList;

/**
 * Расстановка скобок в коде
 * Sample Input 1:
 * ([](){([])})
 * Sample Output 1:
 * Success
 * Sample Input 2:
 * ()[]}
 * Sample Output 2:
 * 5
 * Sample Input 3:
 * {{[()]]
 * Sample Output 3:
 * 7
 */

public class Main {
  
  public static void main(String[] args) {
    //String s = "()";
    //String s = "()[]{}";
    String s = "(]";

    System.out.println(isValid(s));
  }

  private static boolean isValid(String str) {
    char or = 40;   // (
    char cr = 41;   // )
    char os = 91;   // [
    char cs = 93;   // ]
    char ob = 123;  // {
    char cb = 125;  // }

    LinkedList<Character> stack = new LinkedList<>();

    for (int i = 0; i < str.length(); i++) {
      char curr = str.charAt(i);

      boolean isBracket =
          (or == curr || os == curr || ob == curr || cr == curr || cs == curr || cb == curr);
      if (!isBracket) {
        continue;
      }

      boolean isOpened = (or == curr || os == curr || ob == curr);
      if (isOpened) {
        stack.push(curr);
        continue;
      }

      if (stack.isEmpty()) {
        return false;
      }

      char peeked = stack.peek();
      if (or == peeked && curr != cr) {
        return false;
      }
      if (os == peeked && curr != cs) {
        return false;
      }
      if (ob == peeked && curr != cb) {
        return false;
      }

      stack.pop();
    }

    return stack.isEmpty();
  }

}
