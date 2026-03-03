import java.util.Scanner;
 
public class PriceMethod {
 
    public static void main(String[] args) {
        calculatePrice();
    }
 
    public static void calculatePrice() {
    Scanner input = new Scanner(System.in);
 
        // Input Section
        System.out.print("Enter Price of item 1: ");
        float item1 = input.nextFloat();
 
        System.out.print("Enter Price of item 2: ");
        float item2 = input.nextFloat();
 
        System.out.print("Enter Price of item 3: ");
        float item3 = input.nextFloat();
 
        // Computation
        float total = item1 + item2 + item3;
        float average = total / 3;
        float taxRate = 0.12f;
        float amount = total + (taxRate * total);
 
        // Output Results
        System.out.println("\n--- Results ---");
        System.out.println("Total Price     : " + total);
        System.out.println("Average Price   : " + average);
        System.out.println("Total with 12% tax : " + amount);
 
        input.close(); // Closing Scanner to avoid resource leak
    }
}