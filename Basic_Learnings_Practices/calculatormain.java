import java.util.Scanner;

public class calculatormain {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
//OVERALL INT/FLOAT/DOUBLE FUNCTIONS AND OPERATORS ------------------------------------------------------
        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        int diff = 0;
        int mul = 0;
        int div = 0;
        int mod = 0;
// method call ---------------------------------------------------------------------------------------
        num1 = enterNum1();
        num2 = enterNum2();
// OPERATORS FUNCTION ---------------------------------------------------------------------------------
        sum = findSum(num1, num2);
        diff = findDiff(num1, num2);
        mul = findMul(num1, num2);
        div = findDiv(num1, num2);
        mod = findMod(num1, num2);
// DISPLAY FUNCTION ---------------------------------------------------------------------------------
        displaySum(sum);
        displayDif(diff);
        displayMul(mul);
        displayDiv(div);
        displayMod(mod);

    }
// INPUT AREA -----------------------------------------------------------------------------------------
    static int enterNum1(){
        int num1 = 0;
        System.out.println("Enter first number: ");
        num1 = input.nextInt();

        return num1;
    }

    static int enterNum2(){
        int num2 = 0;
        System.out.println("Enter second number: ");
        num2 = input.nextInt();

        return num2;
    }

//CALCULATIONS PROCESS AREA --------------------------------------------------------------------------
    static int findSum(int num1, int num2){
        int sum = 0;
        sum = num1 + num2;
    return sum;
    }
    static int findDiff(int num1, int num2){
        int diff = 0;
        diff = num1 - num2;
    return diff;
    }
    static int findMul(int num1, int num2){
        int mul = 0;
        mul = num1 * num2;
    return mul;
    }
    static int findDiv(int num1, int num2){
        int div = 0;
        div = num1 * num2;
    return div;
    }
    static int findMod(int num1, int num2){
        int mod = 0;
        mod = num1 * num2;
    return mod;
    }

// DISPLAY OUTPUT AREA ----------------------------------------------------------------------
    static void displaySum(int sum){
        System.out.println("The sum of the two numbers is " +sum);
    }
    static void displayDif(int diff){
        System.out.println("The sum of the two numbers is " +diff);
    }
    static void displayMul(int mul){
        System.out.println("The sum of the two numbers is " +mul);
    }
    static void displayDiv(int div){
        System.out.println("The sum of the two numbers is " +div);
    }
    static void displayMod(int mod){
        System.out.println("The sum of the two numbers is " +mod);
    }
}
