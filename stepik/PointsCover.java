import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private void run() {
        Scanner input = new Scanner(System.in);

        int segmentsCounter = input.nextInt();

        Segment[] segments = new Segment[segmentsCounter];
        for (int i = 0; i < segmentsCounter; i++) {
            segments[i] = new Segment(input.nextInt(), input.nextInt());
        }

        Arrays.sort(segments);
        List<Integer> set = new ArrayList<>();
        int currPoint = -1;

        for (Segment segment : segments) {
            if (currPoint < segment.left) {
                currPoint = segment.right;
                set.add(currPoint);
            }
        }

        System.out.println(set.size());
        for (int point : set) {
            System.out.print(point + " ");
        }
    }

    static class Segment implements Comparable<Segment> {
        int left;
        int right;

        public Segment(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "Segment {" +
                    "left=" + left +
                    ", right=" + right +
                    "}";
        }

        @Override
        public int compareTo(Segment o) {
            return Integer.compare(right, o.right);
        }
    }
}
