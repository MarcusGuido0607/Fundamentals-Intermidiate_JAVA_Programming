import java.util.Scanner;
public class LoopWhilePractice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number;
        int sum = 0;

        System.out.print("Enter a number: ");
        number = input.nextInt();

        while (number != 0) {
            sum += number;
            System.out.print("Enter a number: ");
            number = input.nextInt();
        }

        System.out.println("The sum is: " + sum);

        input.close();
    }
}
