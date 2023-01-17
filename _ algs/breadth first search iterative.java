package kuznetsov;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
  }

  public static int breadthFirstSearch(Node root, Node target) {
    Queue<Node> nodesProcessing = new ArrayDeque<>();
    Set<Node> nodesVisited = new HashSet<>();

    int stepsCounter = 0;
    nodesProcessing.add(root);
    nodesVisited.add(root);

    while (!nodesProcessing.isEmpty()) {
      int size = nodesProcessing.size();

      for (int i = 0; i < size; ++i) {
        Node curr = nodesProcessing.poll();
        if (curr == target) {
          return stepsCounter;
        }

        for (Node next : curr.neighbors) {
          if (!nodesVisited.contains(next)) {
            nodesProcessing.add(next);
            nodesVisited.add(next);
          }
        }
      }

      stepsCounter = stepsCounter + 1;
    }

    return -1;
  }

}

class Node {

  public Node[] neighbors;

}