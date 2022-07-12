package com.company;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Расстановка скобок в коде
 * Sample Input 1:
 * ([](){([])})
 * Sample Output 1:
 * Success
 * Sample Input 2:
 * ()[]}
 * Sample Output 2:
 * 5
 * Sample Input 3:
 * {{[()]]
 * Sample Output 3:
 * 7
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isBalanced(sc.next()));
    }

    private static String isBalanced(String str) {
        char or = 40;   // (
        char cr = 41;   // )
        char os = 91;   // [
        char cs = 93;   // ]
        char ob = 123;  // {
        char cb = 125;  // }

        LinkedList<Bracket> stack = new LinkedList<>();

        char c;
        boolean isBracket;
        boolean isOpened;
        Bracket b;

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            isBracket = or == c || os == c || ob == c || cr == c || cs == c || cb == c;

            if (isBracket) {
                isOpened = or == c || os == c || ob == c;

                if (isOpened) {
                    stack.push(new Bracket(c, i));
                } else if (!stack.isEmpty()) {
                    b = stack.peek();

                    if (or == b.c && c != cr) return String.valueOf(++i);
                    if (os == b.c && c != cs) return String.valueOf(++i);
                    if (ob == b.c && c != cb) return String.valueOf(++i);

                    stack.pop();
                } else {
                    i++;
                    return String.valueOf(i);
                }
            }
        }

        if (stack.isEmpty()) return "Success";

        return String.valueOf(++stack.getFirst().i);
    }

    private static class Bracket {
        private final char c;
        private int i;

        private Bracket(char c, int i) {
            this.c = c;
            this.i = i;
        }
    }
}
