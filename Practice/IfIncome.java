import java.util.Scanner;
public class IfIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get salary input
        System.out.print("Enter your monthly salary: ");
        int salary = sc.nextInt();

        // Check income range and print message
        if (salary >= 100000) {
            System.out.println("High income.");
        } else if (salary >= 50000) {
            System.out.println("Middle income.");
        } else if (salary >= 20000) {
            System.out.println("Low income.");
        } else {
            System.out.println("Very low income.");
        }
    }
}
