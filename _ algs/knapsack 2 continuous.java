import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("KnapsackInput.txt"));

        int itemsCounter = input.nextInt();
        int knapsackCapacity = input.nextInt();

        Item[] items = new Item[itemsCounter];
        for (int i = 0; i < itemsCounter; i++) {
            items[i] = new Item(input.nextInt(), input.nextInt());
        }

        Arrays.sort(items);

        double result = 0;
        for (Item item : items) {
            if (item.weight <= knapsackCapacity) {
                result += item.cost;
                knapsackCapacity -= item.weight;
            } else {
                result += (double) item.cost * knapsackCapacity / item.weight;
                break;
            }
        }

        System.out.println(result);
    }

    static class Item implements Comparable<Item> {
        int cost;
        int weight;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        public String toString() {
            return "Item {" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    "}";
        }

        @Override
        public int compareTo(Item o) {
            long r1 = (long) cost * o.weight;
            long r2 = (long) o.cost * weight;

            return -Long.compare(r1, r2);
        }
    }
}
