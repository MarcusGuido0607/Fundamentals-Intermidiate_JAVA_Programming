import java.util.Scanner;
 
public class PriceVoid {
static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        GetValues(); 
    }
 
//PAG DECLARE VARIABLE VALUES ----------------------------------------------------------------     
    static void GetValues() {
        float item1 = 0;
        float item2 = 0;
        float item3 = 0;

//INPUT AREA -------------------------------------------------------------------------------------
        System.out.print("Enter Price of item 1: ");
        item1 = input.nextFloat();

        System.out.print("Enter Price of item 2: ");
        item2 = input.nextFloat();
 
        System.out.print("Enter Price of item 3: ");
        item3 = input.nextFloat();

//METHOD NAME ------------------------------------------------------------------------------
        Total(item1, item2, item3);
        Average(item1, item2, item3);
        TotalWithTax(item1, item2, item3);
    }

//PROCESS AREA -------------------------------------------------------------------------------------------- 
        static void Total(float a, float b, float c) {
        float total = a + b + c;
        DisplayTotal(total);
    }
        static void Average(float a, float b, float c) {
        float average = (a + b + c) / 3;
        DisplayAverage(average);
    }
 
        static void TotalWithTax(float a, float b, float c) {
        float total = a + b + c;
        float totalWithTax = total + (total * 0.12f);
        DisplayTotalWithTax(totalWithTax);
    }
 

//DISPLAY sa CODE ---------------------------------------------------------------------------------------
        static void DisplayTotal(float total) {
        System.out.println("Total Price: " + total);
    }
 
        static void DisplayAverage(float avg) {
        System.out.println("Average Price: " + avg);
    }
 
        static void DisplayTotalWithTax(float taxed) {
        System.out.println("Total with 12% Tax: " + taxed);
    }
}


