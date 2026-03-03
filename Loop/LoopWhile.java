import java.util.Scanner;
public class LoopWhile {
    static Scanner scanner = new Scanner(System.in);
    public static final String RED = "\u001B[31m";
    public static void main(String[] args) {
        int result = countPositiveNumbers();       
        System.out.println(RED +"You entered " + result + " positive numbers.");
    }

    public static int countPositiveNumbers() {
        int count = 0;
        int number;

        while (true) {
            System.out.print(RED +"Enter a number: ");
            number = scanner.nextInt();

            if (number < 0) {
                break;
            }
            count++;
        }
        return count;
    }
}
//Marcus G. Guido BSCS254