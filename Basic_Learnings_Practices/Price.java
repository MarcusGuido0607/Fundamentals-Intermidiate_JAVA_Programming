import java.util.Scanner;
public class Price {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

// Input Section -----------------------------------------------------------------------------------------
        System.out.print("Enter Price of item 1: ");
        float item1 = input.nextFloat();
      
        System.out.print("Enter Price of item 2: ");
        float item2 = input.nextFloat();

        System.out.print("Enter Price of item 3: ");
        float item3 = input.nextFloat();

// Computation ------------------------------------------------------------------------------------------
        float total = item1 + item2 + item3;
        float average = (item1 + item2 + item3) /3;
        float totalwtax = total * .12f;
        float amount = totalwtax + total;

// Output Results-----------------------------------------------------------------------------------------
        System.out.println("___________________________________");
        System.out.println("Total Price: " + total);
        System.out.println("Average Price: " + average);
        System.out.println("Total with 12% tax: " + amount);
        }
}
