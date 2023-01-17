package kuznetsov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

class Generate {
  public static void main(String[] args) {
    new Generate().run();
  }

  private void run() {
    int len = 10_000;
    Random random = new Random();

    for (int i = 0; i < len; i++) {
      System.out.print((char) ('a' + random.nextInt(26)));
    }
  }
}

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    long startTime = System.currentTimeMillis();
    new Main().run();
    long finishTime = System.currentTimeMillis();
    System.out.println(finishTime - startTime + " ms");
  }

  private void run() throws FileNotFoundException {
    Scanner input = new Scanner(new File("input.txt"));
    String s = input.next();

    Map<Character, Integer> charToFreqs = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (charToFreqs.containsKey(c)) {
        charToFreqs.put(c, charToFreqs.get(c) + 1);
      } else {
        charToFreqs.put(c, 1);
      }
    }

    Map<Character, Node> charToNodes = new HashMap<>();
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    for (Map.Entry<Character, Integer> entry : charToFreqs.entrySet()) {
      LeafNode node = new LeafNode(entry.getKey(), entry.getValue());

      charToNodes.put(entry.getKey(), node);
      priorityQueue.add(node);
    }

    int sum = 0;
    while (priorityQueue.size() > 1) {
      Node first = priorityQueue.poll();
      Node second = priorityQueue.poll();

      InternalNode node = new InternalNode(first, second);
      priorityQueue.add(node);

      sum += node.sum;
    }

    if (charToFreqs.size() == 1) {
      sum = s.length();
    }
    System.out.println(charToFreqs.size() + " " + sum);
    Node root = priorityQueue.poll();

    if (charToFreqs.size() == 1) {
      root.buildCode("0");
    } else {
      root.buildCode("");
    }

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      stringBuilder.append(charToNodes.get(c).code);
    }

    System.out.println(stringBuilder);
  }

  static class Node implements Comparable<Node> {
    final int sum;
    String code;

    public Node(int sum) {
      this.sum = sum;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(sum, o.sum);
    }

    void buildCode(String code) {
      this.code = code;
    }
  }

  static class InternalNode extends Node {
    Node left;
    Node right;

    public InternalNode(Node left, Node right) {
      super(left.sum + right.sum);
      this.left = left;
      this.right = right;
    }

    @Override
    void buildCode(String code) {
      super.buildCode(code);
      left.buildCode(code + "0");
      right.buildCode(code + "1");
    }
  }

  static class LeafNode extends Node {
    char symbol;

    public LeafNode(char symbol, int frequency) {
      super(frequency);
      this.symbol = symbol;
    }

    void buildCode(String code) {
      super.buildCode(code);
      System.out.println(symbol + ": " + code);
    }
  }
}
