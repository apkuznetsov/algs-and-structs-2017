package kuznetsov;

import java.io.*;
import java.util.Random;

class Main {

    int[] a;
    int[] temp;
    long counter = 0;

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private void merge(int left, int mid, int right) {
        // a[l..m-1] a[m..r-1] -> temp[l..r-1] -> a[l..r-1]
        int i = left;
        int j = mid;

        for (int k = left; k < right; k++) {
            if (j == right || (i < mid && a[i] <= a[j])) {
                temp[k] = a[i];
                i++;
            } else {
                counter += mid - i;
                temp[k] = a[j];
                j++;
            }
        }

        System.arraycopy(temp, left, a, left, right - left);
    }

    private void mergeSort(int left, int right) {
        if (right <= left + 1) return;
        // a[l..r-1] -> a[l..m-1] a[m..r-1]

        int mid = (left + right) >> 1;

        mergeSort(left, mid);
        mergeSort(mid, right);

        merge(left, mid, right);
    }

    public void run() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input.txt"));
        int numbersCounter = Integer.parseInt(input.readLine());
        a = new int[numbersCounter];

        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < numbersCounter; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }

        temp = new int[numbersCounter];
        mergeSort(0, numbersCounter);
        System.out.println(counter);
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
