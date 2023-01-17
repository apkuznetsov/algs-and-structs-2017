package com.company;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Параллельная обработка.
 * По данным n процессорам и m задач определите, для каждой из задач,
 * каким процессором она будет обработана.
 * <p>
 * Вход.
 * Число процессоров n и последовательность чисел
 * t0, ..., tm-1, где ti – время, необходимое на обработку i-ой задачи.
 * Выход.
 * Для каждой задачи определите,
 * какой процессор и в какое время начнёт её обрабатывать,
 * предполагая, что каждая задача поступает на обработку
 * первому освободившемуся процессору.
 */

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int counterForProcs = scanner.nextInt();
    int counterForTasks = scanner.nextInt();

    long[] tasks = new long[counterForTasks];
    for (int i = 0; i < counterForTasks; i++) {
      tasks[i] = scanner.nextInt();
    }

    PriorityQueue<Processor> queue = new PriorityQueue<>();
    for (int i = 0; i < counterForProcs; i++) {
      queue.add(new Processor(i, 0));
    }

    for (int i = 0; i < counterForTasks; i++) {
      Processor processor = queue.poll();

      int number = processor.id;
      long time = processor.seconds;
      System.out.println(number + " " + time);

      processor.seconds = processor.seconds + tasks[i];

      queue.add(processor);
    }
  }

  private static class Processor implements Comparable<Processor> {
    int id;
    long seconds;

    public Processor(int id, long seconds) {
      this.id = id;
      this.seconds = seconds;
    }

    @Override
    public int compareTo(Processor o) {
      int result = (int) (this.seconds - o.seconds);
      return result == 0 ? this.id - o.id : result;
    }
  }

}
