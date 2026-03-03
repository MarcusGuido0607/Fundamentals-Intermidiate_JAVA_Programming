import java.util.Scanner;
public class comparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;
// INPUT AREA ---------------------------------------------------------------------------------------
        do {
            System.out.print("Enter first number: ");
            int num1 = input.nextInt();

            System.out.print("Enter second number: ");
            int num2 = input.nextInt();

// Comparison results ------------------------------------------------------------------------------------
            System.out.println("num1 == num2 : " + (num1 == num2));
            System.out.println("num1 != num2 : " + (num1 != num2));
            System.out.println("num1 > num2  : " + (num1 > num2));
            System.out.println("num1 >= num2 : " + (num1 >= num2));
            System.out.println("num1 < num2  : " + (num1 < num2));
            System.out.println("num1 <= num2 : " + (num1 <= num2));

// Ask user if they want to continue ------------------------------------------------------------------
            System.out.print("Do you want to continue? (y/n): ");
            choice = input.next();

        } while (choice.equalsIgnoreCase("y"));

        System.out.println("Program ended.");
        input.close();
    }
}
