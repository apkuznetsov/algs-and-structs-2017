package kuznetsov;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
  }

  public Node cloneGraph(Node head) {
    if (head == null) {
      return null;
    }

    Map<Node, Node> map = new HashMap<>();
    Node clonedHead = new Node(head.val, new ArrayList<>());
    map.put(head, clonedHead);

    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(head);

    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      Node clonedCurr = map.get(curr);

      for (Node neighbor : curr.neighbors) {
        Node clonedNeighbor;
        if (!map.containsKey(neighbor)) {
          clonedNeighbor = new Node(neighbor.val, new ArrayList<>());
          map.put(neighbor, clonedNeighbor);
          queue.offer(neighbor);
        } else {
          clonedNeighbor = map.get(neighbor);
        }
        clonedCurr.neighbors.add(clonedNeighbor);
      }
    }

    return clonedHead;
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
