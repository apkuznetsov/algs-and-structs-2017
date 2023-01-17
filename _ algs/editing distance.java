package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

    String first;
    String second;

    int[][] d;
    boolean[][] calculated;

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private int editingDistance(int n, int m) {
        if (n == 0 && m == 0) return 0;
        if (n == 0) return m;
        if (m == 0) return n;

        if (calculated[n][m]) {
            return d[n][m];
        }

        int res1 = editingDistance(n, m - 1) + 1;
        int res2 = editingDistance(n - 1, m) + 1;
        int res3 = editingDistance(n - 1, m - 1)
                + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);

        int res = Math.min(Math.min(res1, res2), res3);
        calculated[n][m] = true;
        d[n][m] = res;

        return res;
    }

    private void run() throws IOException {
        Scanner in = new Scanner(new FileInputStream("input.txt"));

        first = in.next();
        second = in.next();

        d = new int[first.length() + 1][second.length() + 1];

        for (int n = 0; n <= first.length(); n++) {
            for (int m = 0; m <= second.length(); m++) {
                if (n == 0 && m == 0) d[n][m] = 0;
                else if (n == 0) d[n][m] = m;
                else if (m == 0) d[n][m] = n;
                else {
                    int res1 = d[n][m - 1] + 1;
                    int res2 = d[n - 1][m] + 1;
                    int res3 = d[n - 1][m - 1]
                            + (first.charAt(n - 1) == second.charAt(m - 1) ? 0 : 1);

                    int res = Math.min(Math.min(res1, res2), res3);

                    d[n][m] = res;
                }
            }
        }

        System.out.println(d[first.length()][second.length()]);
    }

    static class Generate {
        public static void main(String[] args) throws FileNotFoundException {
            PrintWriter out = new PrintWriter("input.txt");
            Random random = new Random();

            int counter = 10_000;
            for (int i = 1; i <= 1000; i++) {
                out.print((char) ('a' + random.nextInt(26)));
            }
            out.println();

            for (int i = 1; i <= 1000; i++) {
                out.print((char) ('a' + random.nextInt(26)));
            }
            out.println();

            out.close();
        }
    }

}
