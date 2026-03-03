import java.util.Scanner;
public class Rectangle {
    public static void main(String[] args) {
    Scanner input = new Scanner (System.in);
        
        System.out.println("Enter the length of your Rectangle: ");
        int length = input.nextInt();
        System.out.println("Enter the width of your Rectangle: ");
        int width = input.nextInt();
        
        int Area = length * width;
        int Perimeter = length + width + length + width;

        System.out.println("Therefore, The AREA of the Rectangle is " +Area);
        System.out.println("Therefore, The PERIMETER of the Rectangle is " +Perimeter);   
    }
}


