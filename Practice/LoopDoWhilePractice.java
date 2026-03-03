import java.util.Scanner;

public class LoopDoWhilePractice {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            choice = menu();
            processMenu(choice);
        } while (choice != 5);
    }

    static int menu() {
        System.out.println("\n--- Calculator Menu ---");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return input.nextInt();
    }

    static void processMenu(int choice) {
        int num1, num2, result;

        if (choice == 1) {
            System.out.print("Enter first number: ");
            num1 = input.nextInt();
            System.out.print("Enter second number: ");
            num2 = input.nextInt();
            result = num1 + num2;
            System.out.println("Result: " + result);
        } else if (choice == 2) {
            System.out.print("Enter first number: ");
            num1 = input.nextInt();
            System.out.print("Enter second number: ");
            num2 = input.nextInt();
            result = num1 - num2;
            System.out.println("Result: " + result);
        } else if (choice == 3) {
            System.out.print("Enter first number: ");
            num1 = input.nextInt();
            System.out.print("Enter second number: ");
            num2 = input.nextInt();
            result = num1 * num2;
            System.out.println("Result: " + result);
        } else if (choice == 4) {
            System.out.print("Enter first number: ");
            num1 = input.nextInt();
            System.out.print("Enter second number: ");
            num2 = input.nextInt();

            if (num2 == 0) {
                System.out.println("Error: Cannot divide by zero!");
            } else {
                result = num1 / num2;
                System.out.println("Result: " + result);
            }
        } else if (choice == 5) {
            System.out.println("Exiting program. Goodbye!");
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }
}
