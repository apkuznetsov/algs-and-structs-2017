package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Хеширование цепочками
 * <p>
 * Ваша цель в данной задаче — реализовать такую схему,
 * используя таблицу с m ячейками и полиномиальной хеш-функцией на строках.
 * <p>
 * Формат входа.
 * Первая строка размер хеш-таблицы m.
 * Следующая строка содержит количество запросов n.
 * Каждая из последующих n строк содержит запрос одного из перечисленных четырёх типов:
 * – add string: добавить строку string в таблицу. Если такая строка уже есть, проигнорировать запрос;
 * – del string: удалить строку string из таблицы. Если такой строки нет, проигнорировать запрос;
 * – find string: вывести «yes» или «no» в зависимости от того, есть в таблице строка string или нет;
 * – check i: вывести i-й список; если i-й список пуст, вывести пустую строку.
 * Формат выхода.
 * Для каждого из запросов типа find и check выведите результат в отдельной строке.
 */

public class Main {
    private static final BigInteger P = BigInteger.valueOf(1_000_000_007L);
    private static final BigInteger X = BigInteger.valueOf(263L);

    private static final String ADD = "add";
    private static final String DEL = "del";
    private static final String FIND = "find";
    private static final String CHECK = "check";
    private static final String YES = "yes";
    private static final String NO = "no";

    private final Node[] data;

    public Main(int size) {
        this.data = new Node[size];
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {

            Main hashMap = new Main(scan.nextInt());
            int requestsCounter = scan.nextInt();

            for (int i = 0; i < requestsCounter; i++) {
                switch (scan.next()) {
                    case ADD:
                        hashMap.add(scan.next());
                        break;
                    case DEL:
                        hashMap.del(scan.next());
                        break;
                    case FIND:
                        boolean doesContain = hashMap.find(scan.next());
                        System.out.println(doesContain ? YES : NO);
                        break;
                    case CHECK:
                        List<String> values = hashMap.check(scan.nextInt());
                        System.out.println(String.join(" ", values));
                }
            }
        }
    }

    private static int hash(String value, int m) {
        BigInteger h = BigInteger.ZERO;
        BigInteger x = BigInteger.ONE;

        for (char c : value.toCharArray()) {
            BigInteger temp = x.multiply(BigInteger.valueOf(c)).mod(P);
            h = h.add(temp).mod(P);
            x = x.multiply(X).mod(P);
        }

        return h.mod(BigInteger.valueOf(m)).intValue();
    }

    public void add(String value) {
        int hash = hash(value, data.length);

        Node curr = data[hash];
        while (curr != null) {
            if (curr.value.equals(value)) {
                return;
            }

            curr = curr.next;
        }

        Node node = new Node(value);
        node.next = data[hash];
        data[hash] = node;
    }

    public void del(String value) {
        int hash = hash(value, data.length);

        Node prev = null;
        Node curr = data[hash];
        while (curr != null) {
            if (curr.value.equals(value)) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    data[hash] = curr.next;
                }
                break;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    public boolean find(String value) {
        int hash = hash(value, data.length);

        Node curr = data[hash];
        while (curr != null) {
            if (curr.value.equals(value)) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }

    public List<String> check(int bucket) {
        List<String> result = new ArrayList<>();

        Node curr = data[bucket];
        while (curr != null) {
            result.add(curr.value);
            curr = curr.next;
        }

        return result;
    }

    private static class Node {
        public final String value;
        public Node next;

        private Node(String value) {
            this.value = value;
        }
    }
}
