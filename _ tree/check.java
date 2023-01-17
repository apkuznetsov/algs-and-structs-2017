package kuznetsov;

import java.util.Scanner;

/*
 * Проверка свойства дерева поиска.
 * Проверить, является ли данное двоичное дерево деревом поиска.
 *
 * Дереву разрешается содержать равные ключи,
 * но они всегда должны находиться в правом поддереве.
 * Формально, двоичное дерево называется деревом поиска,
 * если для любой вершины её ключ больше всех ключей из её левого поддерева
 * и не меньше всех ключей из правого поддерева.
 *
 * Вход.
 * Двоичное дерево.
 * Выход.
 * Проверить, является ли оно корректным деревом поиска:
 * верно ли, что для любой вершины дерева её ключ больше всех ключей
 * в левом поддереве данной вершины и меньше всех ключей в правом поддереве.
 *
 * Вы тестируете реализацию двоичного дерева поиска.
 * У вас уже написан код, который ищет, добавляет и удаляет ключи,
 * а также выводит внутреннее состояние структуры данных после каждой операции.
 * Вам осталось проверить, что в каждый момент дерево остаётся корректным деревом поиска.
 * Другими словами, вы хотите проверить, что для дерева корректно работает поиск,
 * если ключ есть в дереве, то процедура поиска его обязательно найдёт,
 * если ключа нет — то не найдёт.
 *
 * Формат входа.
 * Первая строка содержит число вершин n.
 * Вершины дерева пронумерованы числами от 0 до n−1.
 * Вершина 0 является корнем.
 * Каждая из следующих n строк содержит информацию о вершинах 0, 1, ..., n−1:
 * i-я строка задаёт числа key i, left i и right i, где
 * key i — ключ вершины i,
 * left i — индекс левого сына вершины i,
 * right i — индекс правого сына вершины i.
 * Если у вершины i нет одного или обоих сыновей,
 * соответствующее значение равно −1.
 * Формат выхода.
 * Выведите «CORRECT», если дерево является корректным деревом поиска,
 * и «INCORRECT» в противном случае.
 */

class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int linesCounter = in.nextInt();
    Node[] nodes = new Node[linesCounter];
    int[] keys = new int[linesCounter];
    int[] lefts = new int[linesCounter];
    int[] rights = new int[linesCounter];

    for (int i = 0; i < linesCounter; i++) {
      nodes[i] = new Node();
      keys[i] = in.nextInt();
      lefts[i] = in.nextInt();
      rights[i] = in.nextInt();
    }

    for (int i = 0; i < linesCounter; i++) {
      nodes[i].key = keys[i];
      if (lefts[i] > -1) {
        nodes[i].left = nodes[lefts[i]];
      }
      if (rights[i] > -1) {
        nodes[i].right = nodes[rights[i]];
      }
    }

    if (nodes.length == 0) {
      System.out.println("CORRECT");
    } else {
      System.out.println(isBst(nodes[0], Long.MIN_VALUE, Long.MAX_VALUE) ? "CORRECT" : "INCORRECT");
    }
  }

  static boolean isBst(Node node, long min, long max) {
    if (node == null) {
      return true;
    }

    if (node.key < min || node.key >= max) {
      return false;
    }

    return (isBst(node.left, min, node.key)
        && isBst(node.right, node.key, max));
  }

  private static class Node {
    int key;
    Node left;
    Node right;
  }

}
