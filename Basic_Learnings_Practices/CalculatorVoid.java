import java.util.Scanner;
public class CalculatorVoid {
    static Scanner input = new Scanner(System.in); 
    public static void main(String[] args) {
        GetValues();
    }

    static void GetValues() {
//VARIABLES -------------------------------------------------------------------------------------
        int num1 = 0;
        int num2 = 0;
//INPUT AREA -------------------------------------------------------------------------------------        
        System.out.println("Enter two numbers: ");
        num1 = input.nextInt();
        num2 = input.nextInt();
//METHOD NAME -----------------------------------------------------------------------------------
        Sum(num1, num2);
        Diff(num1, num2);
        Product(num1, num2);
        Quotient(num1, num2);
        Modulo(num1, num2);
    }
//PROCESS CALCULATION AREA --------------------------------------------------------------------------    
    static void Sum(int num1, int num2){
            int sum = num1 + num2;
            DisplaySum(sum); 
        }
    static void Diff(int num1, int num2){
            int diff = num1 - num2;
            DisplayDiff(diff); 
        }
    static void Product(int num1, int num2){
            int prod = num1 * num2;
            DisplayProduct(prod); 
        }
    static void Quotient(int num1, int num2){   
            float quo = 0.00f;
            quo = (float)(num1) / num2;
            DisplayQuotient(quo); 
        }

    static void Modulo(int num1, int num2){
            int mod = num1 % num2;
            DisplayModulo(mod); 
        }

//DISPLAY AREA ----------------------------------------------------------------------------------------
        static void DisplaySum(int sum) {
            System.out.println("The Sum of the two is: " +sum);
        }

        static void DisplayDiff(int diff) {
            System.out.println("The Difference of the two is: " +diff);
        }

        static void DisplayProduct(int prod) {
            System.out.println("The Product of the two is: " +prod);
        }

        static void DisplayQuotient (float quo) {
            System.out.println("The quotient of the two is: " +quo);
        }

        static void DisplayModulo (int mod) {
            System.out.println("The remainder of the two is: " +mod);
        }
}
