package com.company;

import java.util.Scanner;

/**
 * Телефонная книга
 * <p>
 * Реализовать структуру данных, эффективно обрабатывающую запросы вида
 * add number name, del number и find number.
 * <p>
 * Вход.
 * Последовательность запросов вида add number name, del number и find number,
 * где number — телефонный номер, содержащий не более семи знаков, а name — короткая строка.
 * Выход.
 * Для каждого запроса find number выведите соответствующее имя или сообщите,
 * что такой записи нет.
 */

class Main {
    private static final int MAX_NUMBER = 10_000_000;
    private static final String ADD = "add";
    private static final String DEL = "del";
    private static final String FIND = "find";
    private static final String NOT_FOUND = "not found";
    private final String[] store = new String[MAX_NUMBER];

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            Main main = new Main();

            int inputCounter = in.nextInt();
            for (int i = 0; i < inputCounter; i++) {
                switch (in.next()) {
                    case ADD:
                        main.add(in.nextInt(), in.next());
                        break;
                    case DEL:
                        main.del(in.nextInt());
                        break;
                    case FIND:
                        String name = main.find(in.nextInt());
                        System.out.println(name != null ? name : NOT_FOUND);
                        break;
                }
            }
        }
    }

    public void add(int number, String name) {
        store[number] = name;
    }

    public void del(int number) {
        store[number] = null;
    }

    public String find(int number) {
        return store[number];
    }
}
