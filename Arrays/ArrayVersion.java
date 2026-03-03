import java.util.Scanner;
public class ArrayVersion {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        
// Input ----------------------------------------------------------------------------------------------------------------------
        System.out.print("Enter number of students: ");
        int n = input.nextInt();
        int[] grades = new int[n];

// Loop Process --------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade for student " + (i + 1) + " (max 100): ");
            int grade = input.nextInt();

            if (grade > 100) {
                System.out.println("\033[31mError: Grade must be a maximum of 100.\033[0m");
                i--;
            } 
            else if (grade < 0){
                System.out.println("\033[31mError: Grade must not be Negative.\033[0m");
                i--;  
            }
            else {
                grades[i] = grade;
            }
        }

        int highest = grades[0];
        int lowest = grades[0];
        int sum = 0;

        for (int grade : grades) {
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
            sum += grade;
        }

        float average = (float) sum / n;

// Output ------------------------------------------------------------------------------------------------------------------------
        String line = "\033[32m**************************************************\033[0m";  
        System.out.println(line);
        System.out.println("\033[34m*            Student Grades Summary             *\033[0m");
        System.out.println(line);

// FIXED ALIGNMENT ------------------------------------------------------------------------------------------------------------------
        System.out.printf("\033[33m* Highest grade: %-30d*\033[0m\n", highest);
        System.out.printf("\033[33m* Lowest grade:  %-30d*\033[0m\n", lowest);
        System.out.printf("\033[33m* Average grade: %-30.2f*\033[0m\n", average);

        System.out.println(line);
    }
}
