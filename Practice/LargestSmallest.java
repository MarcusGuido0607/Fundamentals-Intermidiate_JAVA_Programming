import java.util.Scanner;
public class LargestSmallest {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {input();}

    static void input() {
        System.out.println("Enter 5 whole numbers:");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();
        int n4 = input.nextInt();
        int n5 = input.nextInt();

        int largest = findLargest(n1, n2, n3, n4, n5);
        int smallest = findSmallest(n1, n2, n3, n4, n5);

        displayResults(largest, smallest);
    }

    static int findLargest(int n1, int n2, int n3, int n4, int n5) {
        int largest = n1;

        if (n1 >= largest) {largest = n1;} 
        if (n2 >= largest) {largest = n2;} 
        if (n3 >= largest) {largest = n3;}
        if (n4 >= largest) {largest = n4;}
        if (n5 >= largest) {largest = n5;}

        return largest;
    }

    static int findSmallest(int n1, int n2, int n3, int n4, int n5) {
        int smallest = n1;

        if (n1 <= smallest) {smallest = n1;}
        if (n2 <= smallest) {smallest = n2;}
        if (n3 <= smallest) {smallest = n3;}
        if (n4 <= smallest) {smallest = n4;}
        if (n5 <= smallest) {smallest = n5;}

        return smallest;
    }

    static void displayResults(int largest, int smallest) {
        System.out.println("The largest number is: " + largest);
        System.out.println("The smallest number is: " + smallest);
    }
}
