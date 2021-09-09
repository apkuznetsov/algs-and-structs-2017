import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int currTerm = 1;

        while (number > 2 * currTerm) {
            number -= currTerm;
            output.append(currTerm).append(" ");

            currTerm++;
        }
        output.append(number);

        System.out.println(currTerm);
        System.out.println(output);
    }
}
