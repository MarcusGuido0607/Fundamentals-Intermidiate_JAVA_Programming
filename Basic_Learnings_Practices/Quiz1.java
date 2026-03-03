import java.util.Scanner;
public class Quiz1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Enter the principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the annual interest rate in percent: ");
        double rate = input.nextDouble();

        System.out.print("Enter the number of years: ");
        double time = input.nextDouble();

        // Calculate Simple Interest
        double simpleInterest = (principal * rate * time) / 100;

        // Calculate Total Amount
        double totalAmount = principal + simpleInterest;

        // Output
        System.out.printf("Simple Interest: %.5f\n", simpleInterest);
        System.out.printf("Total Amount: %.4f\n", totalAmount);

        input.close();
    }
}
