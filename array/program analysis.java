package com.company;

import java.util.Scanner;

/**
 * Система равенств и неравенств
 * <p>
 * Проверить, можно ли присвоить переменным целые значения,
 * чтобы выполнить заданные
 * равенства вида xi = xj и
 * неравенства вида xp != xq.
 * <p>
 * Вход.
 * Число переменных n, а также список
 * равенств вида xi = xj и
 * неравенства вида xp != xq.
 * <p>
 * Выход.
 * Проверить, выполнима ли данная система.
 */

public class Main {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {

      int varsCounter = in.nextInt();
      int eqsCounter = in.nextInt();
      int ineqsCounter = in.nextInt();

      Pair[] eqs = new Pair[eqsCounter];
      for (int i = 0; i < eqsCounter; i++) {
        eqs[i] = new Pair(in.nextInt(), in.nextInt());
      }

      Pair[] ineqs = new Pair[ineqsCounter];
      for (int i = 0; i < ineqsCounter; i++) {
        ineqs[i] = new Pair(in.nextInt(), in.nextInt());
      }

      System.out.println(isAchievable(varsCounter, eqs, ineqs) ? 1 : 0);
    }
  }

  public static boolean isAchievable(int varsCounter, Pair[] eqs, Pair[] ineqs) {
    int[] parents = new int[varsCounter];
    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }

    for (Pair eq : eqs) {
      parents[eq.first - 1] = eq.second - 1;
    }

    for (Pair ineq : ineqs) {
      int first = getParent(ineq.first - 1, parents);
      int second = getParent(ineq.second - 1, parents);

      if (first == second) {
        return false;
      }
    }

    return true;
  }

  private static int getParent(int root, int[] parents) {
    while (parents[root] != root) {
      root = parents[root];
    }

    return root;
  }

  public static class Pair {
    private final int first;
    private final int second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

}
