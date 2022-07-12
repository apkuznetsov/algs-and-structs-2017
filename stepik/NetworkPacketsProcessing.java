package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Обработка сетевых пакетов.
 * Реализовать обработчик сетевых пакетов.
 * <p>
 * Вход.
 * Размер буфера size и число пакетов n, а также две последовательности arrival1, ..., arrivaln
 * и duration1, ..., durationn, обозначающих время поступления и длительность обработки n пакетов.
 * Выход.
 * Для каждого из данных n пакетов необходимо вывести время начала его обработки или −1,
 * если пакет не был обработан (это происходит в случае, когда пакет поступает в момент,
 * когда в буфере компьютера уже находится size пакетов).
 */

public class Main {

    public static int TIME = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] inputStr = in.readLine().split(" ");
        int size = Integer.parseInt(inputStr[0]);
        int counter = Integer.parseInt(inputStr[1]);

        Deque<Integer> queue = new LinkedBlockingDeque<>(size);

        for (int i = 0; i < counter; i++) {
            inputStr = in.readLine().split(" ");
            int newArrival = Integer.parseInt(inputStr[0]);
            int newDuration = Integer.parseInt(inputStr[1]);

            // убрать пакеты, у которых время окончания на момент прихода нового закончилось
            while (!queue.isEmpty() && queue.peek() <= newArrival) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                System.out.println(newArrival);

                if (newArrival > newDuration) {
                    TIME = newArrival + newDuration;
                } else {
                    TIME = newDuration;
                }

                queue.add(newArrival + newDuration);

            } else if (queue.size() < size) {
                System.out.println(queue.getLast());

                TIME += newDuration;
                queue.add(newDuration + queue.getLast());

            } else {
                System.out.println(-1);
            }
        }
    }
}
