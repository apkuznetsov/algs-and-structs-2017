package kuznetsov;

import java.io.File;
import java.io.FileNotFoundException;
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

  Node root = new Node(null, null);

  public static void main(String[] args) throws FileNotFoundException {
    long startTime = System.currentTimeMillis();
    new Main().run();
    long finishTime = System.currentTimeMillis();
    //System.out.println(finishTime - startTime + " ms");
  }

  private void insert(char letter, String letterCode) {
    Node currNode = root;

    int lastIndex = letterCode.length() - 1;
    for (int i = 0; i < lastIndex; i++) {
      if (letterCode.charAt(i) == '0') {
        if (currNode.left == null) {
          currNode.left = new Node(null, null);
        }
        currNode = currNode.left;
      } else if (letterCode.charAt(i) == '1') {
        if (currNode.right == null) {
          currNode.right = new Node(null, null);
        }
        currNode = currNode.right;
      }
    }

    if (letterCode.charAt(lastIndex) == '0') {
      currNode.left = new Leaf(letter);
    } else if (letterCode.charAt(lastIndex) == '1') {
      currNode.right = new Leaf(letter);
    }
  }

  private String decode(String letterCode) {
    StringBuilder sb = new StringBuilder();
    Node currNode = root;

    for (int i = 0; i < letterCode.length(); i++) {
      if (currNode instanceof Leaf) {
        sb.append(((Leaf) currNode).symbol);
        currNode = root;
      }

      if (letterCode.charAt(i) == '0') {
        currNode = currNode.left;
      } else if (letterCode.charAt(i) == '1') {
        currNode = currNode.right;
      }
    }

    if (currNode instanceof Leaf) {
      sb.append(((Leaf) currNode).symbol);
    }

    return sb.toString();
  }

  private void run() throws FileNotFoundException {
    Scanner input = new Scanner(new File("input.txt"));
    int lettersCounter = input.nextInt();
    int lenCounter = input.nextInt();
    System.out.println(lettersCounter);
    System.out.println(lenCounter);
    String line = input.nextLine();

    char letter;
    String letterCode;
    for (int i = 0; i < lettersCounter; i++) {
      line = input.nextLine();
      letter = line.charAt(0);
      letterCode = line.substring(3);

      insert(letter, letterCode);
    }

    line = input.nextLine();
    System.out.println(line);

    System.out.println(decode(line));
  }

  static class Node {
    Node left;
    Node right;

    public Node(Node left, Node right) {
      this.left = left;
      this.right = right;
    }
  }

  static class Leaf extends Node {
    char symbol;

    public Leaf(char symbol) {
      super(null, null);
      this.symbol = symbol;
    }
  }
}
