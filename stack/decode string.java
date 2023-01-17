package kuznetsov;

import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    //String s = "3[a]2[bc]";
    //String s = "3[a2[c]]";
    String s = "2[abc]3[cd]ef";
    System.out.println(
        decodeString(s)
    );
  }

  public static String decodeString(String s) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sbWord = new StringBuilder();
    StringBuilder sbNumber = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);

      if (curr != ']') {
        stack.push(curr);
        continue;
      }

      while (stack.peek() != '[') {
        sbWord.append(stack.pop());
      }
      stack.pop(); // pop "["
      while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
        sbNumber.append(stack.pop());
      }
      int number = Integer.parseInt(sbNumber.reverse().toString());
      String word = sbWord.reverse().toString().repeat(number);
      for (int j = 0; j < word.length(); j++) {
        stack.push(word.charAt(j));
      }
      sbWord.setLength(0);
      sbNumber.setLength(0);
    }

    StringBuilder sb = new StringBuilder(s.length() * 2);
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }

}
