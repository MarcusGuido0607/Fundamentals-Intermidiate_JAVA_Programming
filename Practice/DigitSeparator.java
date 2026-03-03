import java.util.Scanner;
public class DigitSeparator {
static Scanner input = new Scanner(System.in);
    
    public static int getThousands(int num) {return num / 1000;}
 
    public static int getHundreds(int num) {return (num / 100) % 10;}

    public static int getTens(int num) {return (num / 10) % 10;}
 
    public static int getOnes(int num) {return num % 10;}
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
       
        System.out.print("Enter a 4-digit number: ");
        int number = input.nextInt();
 
        
        System.out.println("\nNumber entered: " + number);
        System.out.println("Thousands: " + getThousands(number));
        System.out.println("Hundreds: " + getHundreds(number));
        System.out.println("Tens: " + getTens(number));
        System.out.println("Ones: " + getOnes(number));

    }
}