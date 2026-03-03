import java.util.Scanner;
public class LeapYear {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {inputYear();}

        static void inputYear() {
        System.out.print("Enter a year: ");
        int year = input.nextInt();
        checkLeapYear(year);   
    }

    
    static void checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) 
            {System.out.println(year + " is a leap year.");        } 
        
        else 
            {System.out.println(year + " is not a leap year.");   }
    }
}

//Marcus G. Guido BSCS254