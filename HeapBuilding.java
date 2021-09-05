package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Построение кучи.
 * Переставить элементы заданного массива чисел так, чтобы он удовлетворял свойству мин-кучи.
 * <p>
 * Вход.
 * Массив чисел A[0...n-1].
 * Выход.
 * Переставить элементы массива так, чтобы выполнялись неравенства
 * A[i] <= A[2i+1] и A[i] <= A[2i+2] для всех i.
 */

public class Main {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int size = scan.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = scan.nextInt();
            }

            List<Swapper> swappers = heapify(array);

            System.out.println(swappers.size());
            for (Swapper swapper : swappers) {
                System.out.println(swapper.from + " " + swapper.to);
            }
        }
    }

    public static List<Swapper> heapify(int[] array) {
        HeapBuilder builder = new HeapBuilder(array);
        builder.heapify();

        return builder.history();
    }

    public static class HeapBuilder {
        private final int[] data;
        private final int size;
        private final List<Swapper> history;

        public HeapBuilder(int[] array) {
            this.data = array;
            this.size = array.length;
            this.history = new ArrayList<>();
        }

        public List<Swapper> history() {
            return history;
        }

        public void heapify() {
            for (int i = data.length / 2; i >= 0; i--) {
                siftDown(i);
            }
        }

        private void siftDown(int i) {
            int left = leftIndex(i);
            int right = rightIndex(i);

            while (left <= size - 1) {
                if (right > size - 1) {
                    if (data[i] > data[left]) {
                        swap(data, i, left);
                    }
                    break;
                }

                if (data[i] > data[left]) {
                    if (data[i] <= data[right]) {
                        swap(data, i, left);
                        i = left;
                    } else {
                        int min = data[left] > data[right]
                                ? right
                                : left;
                        swap(data, i, min);
                        i = min;
                    }
                } else if (data[i] > data[right]) {
                    swap(data, i, right);
                    i = right;
                } else {
                    break;
                }

                left = leftIndex(i);
                right = rightIndex(i);
            }
        }

        private int leftIndex(int i) {
            return i * 2 + 1;
        }

        private int rightIndex(int i) {
            return i * 2 + 2;
        }

        private void swap(int[] array, int i, int j) {
            Swapper swapper = new Swapper(i, j);
            swapper.swap(array);

            history.add(swapper);
        }
    }

    public static class Swapper {
        public final int from;
        public final int to;

        public Swapper(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public void swap(int[] array) {
            assert array.length > from
                    && array.length > to;

            int temp = array[from];
            array[from] = array[to];
            array[to] = temp;
        }
    }
}
