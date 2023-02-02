package kuznetsov;

import java.io.*;
import java.util.Random;

class Main {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private int[] merge(int[] a, int[] b) {
        int ia = 0;
        int ib = 0;
        int[] c = new int[a.length + b.length];

        for (int ic = 0; ic < c.length; ic++) {
            if (ib == b.length || (ia < a.length && a[ia] < b[ib])) {
                c[ic] = a[ia];
                ia++;
            } else {
                c[ic] = b[ib];
                ib++;
            }
        }

        return c;
    }

    private int[] mergeSort(int[] a) {
        if (a.length == 1) {
            return a;
        }

        int len = a.length;
        int mid = len / 2;

        int[] left = new int[mid];
        int[] right = new int[len - mid];

        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, len - mid);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public void run() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input.txt"));
        int numbersCounter = Integer.parseInt(input.readLine());
        int[] a = new int[numbersCounter];

        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < numbersCounter; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }
    }

    static class Generate {
        public static void main(String[] args) throws FileNotFoundException {
            PrintWriter printWriter = new PrintWriter("input.txt");

            int testSize = 100_000;
            Random random = new Random();
            printWriter.println(testSize);

            for (int i = 0; i < testSize; i++) {
                printWriter.print(random.nextInt() + " ");
            }

            printWriter.close();
        }
    }

}
