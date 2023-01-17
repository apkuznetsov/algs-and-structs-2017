package kuznetsov;

import java.util.Set;

public class Main {

  public static void main(String[] args) {
  }

  public boolean dfs(Node curr, Node target, Set<Node> visited) {
    if (curr == target) {
      return true;
    }

    for (Node next : curr.neighbors) {
      if (!visited.contains(next)) {
        visited.add(next);
        if (dfs(next, target, visited)) {
          return true;
        }
      }
    }

    return false;
  }

  static class Node {

    Node[] neighbors;

  }

}
