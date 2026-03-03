import java.util.Random;
import java.util.Scanner;
public class LoopDoWhile {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {Guessing ();}
    static void Guessing(){ 
    Random rand = new Random ();
    int secretNumber = rand.nextInt(100)+1;
    int guess, attempts = 0;
        
        do {
            System.out.print("Guess a number between 1 and 100: ");
            guess = input.nextInt();
            attempts++;
            if (guess < secretNumber) {
                System.out.println("Too low, try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high, try again.");
            } else {
                System.out.println("Correct! You guessed it in " + attempts + " attempts.");
            }
        } while (guess != secretNumber);
     }
}
//Marcus G. Guido BSCS254