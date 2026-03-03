import java.util.Scanner;
public class LoopForSum {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter a positive integer: ");
        int N = input.nextInt();
        int result = calculateSum(N);
        System.out.println("The sum of the first " + N + " natural numbers is: " + result);
    }

    public static int calculateSum(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }
        return sum;
    }
}
//Marcus G. Guido BSCS254