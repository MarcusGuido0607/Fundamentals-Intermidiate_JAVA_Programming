import java.util.Scanner;
public class arithmetic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            // Input integers
            System.out.print("Enter first number: ");
            int num1 = input.nextInt();

            System.out.print("Enter second number: ");
            int num2 = input.nextInt();

            // Arithmetic operations
            System.out.println("num1 + num2 = " + (num1 + num2));
            System.out.println("num1 - num2 = " + (num1 - num2));
            System.out.println("num1 * num2 = " + (num1 * num2));

            if (num2 != 0) { // Avoid division by zero
                System.out.println("num1 / num2 = " + (num1 / num2));
                System.out.println("num1 % num2 = " + (num1 % num2));
            } else {
                System.out.println("Cannot divide by zero.");
            }

            // Ask to continue
            System.out.print("Do you want to continue? (y/n): ");
            choice = input.next();

        } while (choice.equalsIgnoreCase("y"));

        System.out.println("Program ended.");
        input.close();
    }
}
