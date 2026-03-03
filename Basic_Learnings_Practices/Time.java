import java.util.Scanner;
public class Time {
    public static void main(String[] args) {
    Scanner input = new Scanner (System.in);
        
        System.out.println("Enter the time in hours, minues, seconds: ");
        int hours = input.nextInt();
        int mins = input.nextInt();
        int sec = input.nextInt();

        int minutes = mins/60;
        int seconds = sec/3200;

        System.out.println("Therefore, All time inputs converted to hours is " +(hours + minutes + seconds)); 
    }
}

