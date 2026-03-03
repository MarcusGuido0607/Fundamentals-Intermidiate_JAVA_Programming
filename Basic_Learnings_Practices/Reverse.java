import java.util.Scanner;
public class Reverse {
    public static void main(String[] args)  {
    Scanner input = new Scanner (System.in);


//INPUT AREA -----------------------------------------------------------------------------------------
        System.out.println("Please Input your First Number: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();
        int num4 = input.nextInt();
        int num5 = input.nextInt();

// OUTPUT AREA -----------------------------------------------------------------------------------------
        System.out.println("");
        System.out.println("This are the Reversed numbers: ");
        System.out.println(num5);
        System.out.println(num4);
        System.out.println(num3);
        System.out.println(num2);
        System.out.println(num1);
    }
}
