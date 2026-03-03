import java.util.Scanner;
public class PalindromeCheck {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {inputPalindromeCheck();}

        static void inputPalindromeCheck() {
        System.out.print("Enter a 3-digit number: ");
        int number = input.nextInt();
        checkPalindrome(number);
    }
 
    static void checkPalindrome(int number) {
        int hundreds = number / 100;         
        int ones = number % 10;              
 
        if (hundreds == ones) 
            {System.out.println(number + " is a palindrome.");} 
        else 
            {System.out.println(number + " is not a palindrome.");}
    }
}

//Marcus G. Guido BSCS 254