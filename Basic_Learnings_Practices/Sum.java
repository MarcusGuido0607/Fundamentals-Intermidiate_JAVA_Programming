
import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        ComputeSum();

    }

    static void ComputeSum() {
        Scanner input = new Scanner(System.in);

        //DECLARATION & INITIALIZATION
        //Declaration means you are declaring the type of data the variable will accept
        //Initialization means you are giving a starting/initial value to your variable
        int num1 = 0;
        int num2 = 0;
        int sum = 0;

        //INPUT
        System.out.println("Enter 2 numbers: ");
        num1 = input.nextInt();
        num2 = input.nextInt();

        //PROCESS
        sum = num1 + num2;

        //OUTPUT
        System.out.println("The sum of the 2 numbers is  " + sum);

        input.close();

    }
}
