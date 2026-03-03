import java.util.Scanner;
public class ArrayOddEvenPrime {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("How many numbers do you want to enter? ");
        int n = input.nextInt();

        int[] numbers = new int[n];
        enterNumbers(numbers);

        int evenCount = countEven(numbers);
        int oddCount = countOdd(numbers);
        int primeCount = countPrime(numbers);

        System.out.println("\nEven numbers: " + evenCount);
        System.out.println("Odd numbers: -" + oddCount);
        System.out.println("Prime numbers: " + primeCount);
    }

    
    static void enterNumbers(int[] arr) {
        System.out.println("Enter " + arr.length + " integers:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
    }

    static int countEven(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) count++;
        }
        return count;
    }

    static int countOdd(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) count++;
        }
        return count;
    }

    
    static int countPrime(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (isPrime(num)) count++;
        }
        return count;
    }

    static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
//Marcus G. Guido BSCS254