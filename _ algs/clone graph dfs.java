package kuznetsov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
  
  public static void main(String[] args) {
  }

  public Node cloneGraph(Node node) {
    HashMap<Node, Node> visited_to_clone = new HashMap<>();
    return dfs(node, visited_to_clone);
  }

  public Node dfs(Node node, HashMap<Node, Node> visited_to_clone) {
    if (node == null) {
      return null;
    }

    if (visited_to_clone.containsKey(node)) {
      return visited_to_clone.get(node);
    }

    Node clone = new Node(node.val);
    visited_to_clone.put(node, clone);

    for (Node next : node.neighbors) {
      clone.neighbors.add(dfs(next, visited_to_clone));
    }

    return clone;
  }

}

class Node {

  public int val;
  public List<Node> neighbors;

  public Node() {
    this(0, new ArrayList<>());
  }

  public Node(int val) {
    this(val, new ArrayList<>());
  }

  public Node(int val, List<Node> neighbors) {
    this.val = val;
    this.neighbors = neighbors;
  }

}
