import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListVersion_SingleArray {
    static Scanner input = new Scanner(System.in);

// Colors for text -----------------------------------------------------------------------------------------------------------------------------------
    public static final String RESET = "\033[0m"; 
    public static final String RED = "\033[0;31m"; 
    public static final String GREEN = "\033[0;32m"; 
    public static final String YELLOW = "\033[0;33m"; 
    public static final String BLUE = "\033[0;34m"; 
    public static final String CYAN = "\033[0;36m"; 
    public static final String BOLD = "\033[1m"; 

    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        
// Input --------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println(CYAN + BOLD + "Enter grades (type a Negative Number to stop): " + RESET);

        while (true) {
            int grade = input.nextInt();
            
            if (grade < 0) break;  
            if (grade > 100) {System.out.println(RED + "Error: Grade must be between 0 and 100." + RESET);
                continue;
            }
            
            grades.add(grade);  
            }

// If walay grades gi enter --------------------------------------------------------------------------------------------------------------------------
        if (grades.isEmpty()) {System.out.println(RED + "No grades entered." + RESET);
            return;
        }

// Process: Calculate highest, lowest, sum, and average ----------------------------------------------------------------------------------------------
        int highest = grades.get(0);
        int lowest = grades.get(0);
        int sum = 0;

        for (int grade : grades) {
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
            sum += grade;
        }

        double average = (double) sum / grades.size();

// Output the results ---------------------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println(BLUE + BOLD + "------------------------ RESULTS ------------------------" + RESET);
        System.out.println(GREEN + "Highest Grade: " + YELLOW + highest + RESET);
        System.out.println(GREEN + "Lowest Grade: " + RED + lowest + RESET);
        System.out.println(GREEN + "Average Grade: " + YELLOW + String.format("%.2f", average) + RESET);
        System.out.println(GREEN + "Number of Grades Entered: " + YELLOW + grades.size() + RESET);
        System.out.println(BLUE + BOLD + "--------------------------------------------------------" + RESET);
    }
}
