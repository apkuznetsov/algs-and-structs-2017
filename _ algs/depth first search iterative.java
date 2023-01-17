package kuznetsov;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
  }

  public static boolean dfs(Node root, Node target) {
    Set<Node> visited = new HashSet<>();
    Stack<Node> stack = new Stack<>();
    stack.add(root);

    while (!stack.isEmpty()) {
      Node curr = stack.pop();
      if (curr == target) {
        return true;
      }

      for (Node next : curr.neighbors) {
        if (!visited.contains(next)) {
          visited.add(next);
          stack.push(next);
        }
      }
    }

    return false;
  }

  static class Node {

    Node[] neighbors;

  }

}
