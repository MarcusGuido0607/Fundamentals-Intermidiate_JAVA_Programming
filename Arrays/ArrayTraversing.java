import java.util.Scanner;
public class ArrayTraversing {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        int[] numbers = new int[n];
        int[] freq = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
        {numbers[i] = input.nextInt();}

        countFrequency(numbers, freq, n);
        displayResult(numbers, freq, n);
    }

    public static void countFrequency(int[] numbers, int[] freq, int n) {
        for (int i = 0; i < n; i++) {
            int count = 1;

            
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    freq[i] = 0;
                    count = 0;
                    break;
                }
            }

            
            if (count != 0) {
                for (int k = i + 1; k < n; k++) {
                    if (numbers[i] == numbers[k]) {
                        count++;
                    }
                }
                freq[i] = count;
            }
        }
    }

    public static void displayResult(int[] numbers, int[] freq, int n) {
        System.out.println("\nFrequencies:");
        for (int i = 0; i < n; i++) {
            if (freq[i] != 0) {
                System.out.println(numbers[i] + " - " + freq[i] + (freq[i] == 1 ? " time" : " times"));
            }
        }

        int max = 0;
        int min = n;
        for (int i = 0; i < n; i++) {
            if (freq[i] != 0) {
                if (freq[i] > max) max = freq[i];
                if (freq[i] < min) min = freq[i];
            }
        }

        
        System.out.print("\nMost frequent element(s): ");
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (freq[i] == max) {
                if (!first) System.out.print(", ");
                System.out.print(numbers[i]);
                first = false;
            }
        }

       
        System.out.print("\nLeast frequent element(s): ");
        first = true;
        for (int i = 0; i < n; i++) {
            if (freq[i] == min) {
                if (!first) System.out.print(", ");
                System.out.print(numbers[i]);
                first = false;
            }
        }

        System.out.println(); 
    }
}

// Marcus G. Guido BSCS254
