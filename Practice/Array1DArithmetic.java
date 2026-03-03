import java.util.Scanner;
public class Array1DArithmetic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        
        System.out.println("Enter 10 integers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = input.nextInt(); 
        }
        
        displayStats(numbers);
        input.close();
    }
      public static void displayStats(int[] arr) {
        int sum = 0;
        int largest = arr[0];
        int smallest = arr[0];
        
        for (int num : arr) {
            sum += num;
            if (num > largest) largest = num;
            if (num < smallest) smallest = num;
        }
        
        double average = (double) sum / arr.length;
        System.out.print("Numbers entered: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        System.out.println("Largest = " + largest);
        System.out.println("Smallest = " + smallest);
    }
}
