package kuznetsov;

import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    String[] tokens = new String[] {"2", "1", "+", "3", "*"};
    System.out.println(
        evalRPN(tokens)
    );
  }

  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String t : tokens) {
      switch (t) {
        case "+": {
          int b = stack.pop();
          int a = stack.pop();
          stack.push(a + b);
          break;
        }
        case "-": {
          int b = stack.pop();
          int a = stack.pop();
          stack.push(a - b);
          break;
        }
        case "*": {
          int b = stack.pop();
          int a = stack.pop();
          stack.push(a * b);
          break;
        }
        case "/": {
          int b = stack.pop();
          int a = stack.pop();
          stack.push(a / b);
          break;
        }
        default: {
          stack.push(Integer.parseInt(t));
          break;
        }
      }
    }

    return stack.pop();
  }

}
