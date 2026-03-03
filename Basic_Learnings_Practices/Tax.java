import java.util.Scanner;
public class Tax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input Section
        System.out.print("Enter the total bill amount (no tax, no tip): ");
        double bill = input.nextDouble();

        System.out.print("Enter tax rate: ");
        double taxRate = input.nextDouble();

        System.out.print("Enter tip rate: ");
        double tipRate = input.nextDouble();

        System.out.print("Enter the number of people to split the bill: ");
        int people = input.nextInt();

        // Echoing inputs
        System.out.println("Total Bill Amount: " + bill);
        System.out.println("Tax: " + taxRate);
        System.out.println("Tip: " + tipRate);
        System.out.println("# of people: " + people);

        // Computation
        double taxAmount = bill * taxRate / 100;
        double tipAmount = bill * tipRate / 100;
        double totalAmount = bill + taxAmount + tipAmount;
        double perPerson = totalAmount / people;

        // Output Results
        System.out.println("___________________________________");
        System.out.println("\nTotal Tax Amount: " + taxAmount);
        System.out.println("Tip Amount: " + tipAmount);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Each person should pay " + perPerson);
    }
}
