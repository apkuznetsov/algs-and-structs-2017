package kuznetsov;

import java.util.Arrays;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
    System.out.println(
        Arrays.toString(dailyTemperatures(temperatures))
    );
  }

  public static int[] dailyTemperatures(int[] temps) {
    int[] ans = new int[temps.length];
    Stack<Integer> stack = new Stack<>();

    for (int currIdx = 0; currIdx < temps.length; currIdx++) {
      while (stack.size() > 0 && temps[currIdx] > temps[stack.peek()]) {
        ans[stack.peek()] = currIdx - stack.peek();
        stack.pop();
      }
      stack.push(currIdx);
    }

    return ans;
  }

}
