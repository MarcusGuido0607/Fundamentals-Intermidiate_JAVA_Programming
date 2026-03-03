import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListVersion_MultiArray {
    static Scanner input = new Scanner(System.in);

//Colors of texts ----------------------------------------------------------------------------------------------------------------
    public static final String RESET = "\033[0m"; // Reset
    public static final String RED = "\033[0;31m"; // Red
    public static final String GREEN = "\033[0;32m"; // Green
    public static final String YELLOW = "\033[0;33m"; // Yellow
    public static final String BLUE = "\033[0;34m"; // Blue
    public static final String CYAN = "\033[0;36m"; // Cyan
    public static final String BOLD = "\033[1m"; // Bold

    public static void main(String[] args) {

// Input -------------------------------------------------------------------------------------------------------------------------
        System.out.print(CYAN + BOLD + "Enter number of students: " + RESET);
        int numStudents = input.nextInt();
        System.out.print(CYAN + BOLD + "Enter number of subjects per student: " + RESET);
        int numSubjects = input.nextInt();
        
        ArrayList<ArrayList<Integer>> grades = new ArrayList<>();

// Process -----------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n" + CYAN + BOLD + "Enter grades for student " + (i + 1) + ":" + RESET);
            ArrayList<Integer> studentGrades = new ArrayList<>();
            for (int j = 0; j < numSubjects; j++) {
                System.out.print(GREEN + "  Grade for subject " + (j + 1) + ": " + RESET);
                int grade = input.nextInt();
                studentGrades.add(grade);
            }
            grades.add(studentGrades);
        }

// Initialize variables sa highest, lowest, sum ----------------------------------------------------------------------------------
        int highest = grades.get(0).get(0);
        int lowest = grades.get(0).get(0);
        int sum = 0;
        int totalGrades = 0;

// Output ------------------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < grades.size(); i++) {
            System.out.print(YELLOW + "Student " + (i + 1) + " grades: " + RESET);
            ArrayList<Integer> student = grades.get(i);
            for (int g : student) {
                System.out.print(g + " ");
                if (g > highest) highest = g;
                if (g < lowest) lowest = g;
                sum += g;
                totalGrades++;
            }
            System.out.println(); 
        }

        double average = (double) sum / totalGrades;

// Output -------------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println(BLUE + BOLD + "------------------------ Overall Results ------------------------" + RESET);
        System.out.println(GREEN + "Highest Grade: " + YELLOW + highest + RESET);
        System.out.println(GREEN + "Lowest Grade: " + YELLOW + lowest + RESET);
        System.out.println(GREEN + "Average Grade: " + YELLOW + String.format("%.2f", average) + RESET);
        System.out.println(GREEN + "Total Number of Grades Entered: " + YELLOW + totalGrades + RESET);
        System.out.println(BLUE + BOLD + "---------------------------------------------------------------" + RESET);
    }
}
