import java.util.Scanner;
public class SimpleTaxCalc {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {calculateTax(); }
    
        static void calculateTax() {
        System.out.print("Enter your annual income: ");
        int income = input.nextInt();

        double tax = 0;

        if (income < 0) {
            System.out.println("Invalid income entered.");
        } else if (income <= 250000) {
            tax = 0;
        } else if (income <= 400000) {
            tax = (income - 250000) * 0.10;
        } else if (income <= 800000) {
            tax = (income - 400000) * 0.15 + 15000;
        } else if (income <= 2000000) {
            tax = (income - 800000) * 0.20 + 75000;
        } else if (income <= 8000000) {
            tax = (income - 2000000) * 0.25 + 335000;
        } else {
            tax = (income - 8000000) * 0.30 + 2195000;
        }
        System.out.println("Total tax payable: " + tax);
    }
}
//Marcus G. Guido BSCS254