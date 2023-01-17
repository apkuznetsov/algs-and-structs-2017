package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);

        int w = in.nextInt();
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int[][] d = new int[n + 1][w + 1];

        for (int i = 0; i < n; i++) {
            d[i][0] = 0;
        }

        for (int i = 0; i < w; i++) {
            d[0][i] = 0;
        }

        Arrays.sort(a);

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= w; i++) {
                d[j][i] = d[j - 1][i];

                if (i >= a[j - 1]) {
                    d[j][i] = Math.max(d[j][i], d[j - 1][i - a[j - 1]] + a[j - 1]);
                }
            }
        }

        System.out.println(d[n][w]);
    }
}
