package kuznetsov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Обход двоичного дерева.
 * Построить in-order, pre-order и post-order
 * обходы данного двоичного дерева.
 *
 * Вход.
 * Двоичное дерево.
 * Выход.
 * Все его вершины в трёх разных порядках:
 * in-order, pre-order и post-order.
 *
 * Формат входа.
 * Первая строка содержит число вершин n.
 * Вершины дерева пронумерованы числами от 0 до n−1.
 * Вершина 0 является корнем.
 * Каждая из следующих n строк содержит информацию о вершинах
 * 0, 1, ..., n−1: i-я строка задаёт числа keyi, lefti и righti, где
 * key i — ключ вершины i,
 * left i — индекс левого сына вершины i,
 * right i — индекс правого сына вершины i.
 * Если у вершины i нет одного или обоих сыновей,
 * соответствующее значение равно −1.
 * Формат выхода.
 * Три строки: in-order, pre-order и post-order обходы.
 */

public class Main {

  private static String[] inputLines;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int linesCounter = Integer.parseInt(in.readLine());
    inputLines = new String[linesCounter];

    for (int i = 0; i < linesCounter; i++) {
      inputLines[i] = in.readLine();
    }

    Tree root = buildTree(null, 0);

    root.inOrder(root);
    System.out.println();

    root.preOrder(root);
    System.out.println();

    root.postOrder(root);

    in.close();
  }

  private static Tree buildTree(Tree root, int i) {
    String[] inputLine = inputLines[i].split(" ");

    int key = Integer.parseInt(inputLine[0]);
    int left = Integer.parseInt(inputLine[1]);
    int right = Integer.parseInt(inputLine[2]);

    Tree newTree = new Tree(key);

    newTree.parent = root;

    if (left != -1) {
      newTree.left = buildTree(newTree, left);
    }

    if (right != -1) {
      newTree.right = buildTree(newTree, right);
    }

    return newTree;
  }

  private static class Tree {
    int key;
    Tree parent;
    Tree left;
    Tree right;

    Tree(int key) {
      this.key = key;
    }

    void inOrder(Tree root) {
      if (root != null) {
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
      }
    }

    void preOrder(Tree root) {
      if (root != null) {
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
      }
    }

    void postOrder(Tree root) {
      if (root != null) {
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.key + " ");
      }
    }
  }
    
}
