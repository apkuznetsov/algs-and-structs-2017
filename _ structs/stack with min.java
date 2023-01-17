package kuznetsov;

import java.util.Stack;

public class Main {

  public static void main(String[] args) {
  }

  public static class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
      stack = new Stack<>();
      minStack = new Stack<>();
    }

    public void push(int val) {
      if (stack.isEmpty()) {
        stack.push(val);
        minStack.push(val);
      } else {
        int min = Math.min(val, minStack.peek());
        stack.push(val);
        minStack.push(min);
      }
    }

    public void pop() {
      if (stack.isEmpty()) {
        return;
      }
      stack.pop();
      minStack.pop();
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      return minStack.peek();
    }

  }

}
