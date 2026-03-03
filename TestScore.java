import java.util.Scanner;
public class TestScore {
    public static void main(String[] args) {Score(); }
    static void Score() {
        Scanner input = new Scanner(System.in); 
        int score1, score2, score3, score4, score5;
        System.out.println("Enter Test score 1:");
        score1 = input.nextInt();
        System.out.println("Enter Test score 2:");
        score2 = input.nextInt();
        System.out.println("Enter Test score 3:");
        score3 = input.nextInt();
        System.out.println("Enter Test score 4:");
        score4 = input.nextInt();
        System.out.println("Enter Test score 5:");
        score5 = input.nextInt();
        Average(score1, score2, score3, score4, score5);
    }
    static void Average(int score1, int score2, int score3, int score4, int score5) {
        float average = (score1 + score2 + score3 + score4 + score5) / 5.0f;
        displayAverage(average);
        gradeMessage(average);
    }
    static void displayAverage(float average) {
        System.out.println("Average Score: " + average);
    }
    static void gradeMessage(float average) {
        if (average < 0 || average > 100) {
            System.out.println("Invalid input. Scores must be between 0 and 100.");
        } else if (average >= 90) {
            System.out.println("Grade: Excellent");
        } else if (average >= 75) {
            System.out.println("Grade: Good");
        } else if (average >= 50) {
            System.out.println("Grade: Pass");
        } else {
            System.out.println("Grade: Fail");
        }
    }
}
//Marcus G. Guido BSCS254