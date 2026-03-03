import java.util.Scanner;
public class MenuProgram {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int choice = 0;
        do {

// MAIN MENU -----------------------------------------------------------------------------------------------------------------------------
            System.out.println("=====================================================");
            System.out.println("|                  MENU                              |");
            System.out.println("=====================================================");
            System.out.println("| 1. Convertion Decimal to Binary, Octal, Hexa       |");
            System.out.println("| 2. Arithmetic Operations                           |");
            System.out.println("| 0. Exit                                            |");
            System.out.println("=====================================================");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            if (choice == 1) {
                convertMenu();
            } else if (choice == 2) {
                arithmeticMenu();
            } else if (choice == 0) {
                System.out.println("Thank you for using the Marcus Menu's program!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    
// CONVERT MENU -------------------------------------------------------------------------------------------------------------------
    static void convertMenu() {
        System.out.print("Enter any decimal number: ");
        int num = input.nextInt();

        System.out.println("===========================================");
        System.out.println("|           CONVERSION RESULTS            |");
        System.out.println("===========================================");
        System.out.println("| Binary      : " + decimalToBinary(num));
        System.out.println("| Octal       : " + decimalToOctal(num));
        System.out.println("| Hexadecimal : " + decimalToHex(num));
        System.out.println("===========================================");
    }

    
// ARITHMETIC MENU (Addition and Subtraction) -----------------------------------------------------------------------------------------
    static void arithmeticMenu() {
        int option = 0;
        do {
            System.out.println("===========================================");
            System.out.println("|           ARITHMETIC MENU               |");
            System.out.println("===========================================");
            System.out.println("| 1. Addition                             |");
            System.out.println("| 2. Subtraction                          |");
            System.out.println("| 0. Back to Main Menu                    |");
            System.out.println("===========================================");
            System.out.print("Enter your choice: ");
            option = input.nextInt();

            if (option == 0) break;

            System.out.println("===========================================");
            System.out.println("|         Choose Number System            |");
            System.out.println("===========================================");
            System.out.println("| 1. Binary                               |");
            System.out.println("| 2. Octal                                |");
            System.out.println("| 3. Hexadecimal                          |");
            System.out.println("| 0. Back to Main Menu                    |");
            System.out.println("===========================================");
            System.out.print("Enter choice: ");
            int type = input.nextInt();

            int base = 0;
            if (type == 1) base = 2;
            else if (type == 2) base = 8;
            else if (type == 3) base = 16;
            else if (type == 4) return; 
            else {
                System.out.println("Invalid type!");
                continue;
            }

            System.out.print("Enter first number: ");
            String num1 = input.next();
            System.out.print("Enter second number: ");
            String num2 = input.next();

            int dec1 = convertToDecimal(num1, base);
            int dec2 = convertToDecimal(num2, base);

            if (dec1 == -1 || dec2 == -1) {
                System.out.println("Invalid input for that base!");
                continue;
            }

// Addition -------------------------------------------------------------------------------------------------------------------
            if (option == 1) { 
                int sum = dec1 + dec2;
                printResult(sum, base);
                }
// SUBTRACTION ---------------------------------------------------------------------------------------------------------------
                else if (option == 2) { 
                if (dec1 < dec2) {
                    System.out.println("Invalid: In Subtraction, First number must be greater.");
                    continue;
                }
                int diff = dec1 - dec2;
                if (base == 2 && (diff < 1 || diff > 15)) {
                    System.out.println("Binary result must be 1-15 only.");
                    continue;
                }
              
                printResult(diff, base);
            } else {
                System.out.println("Invalid operation!");
            }

        } while (option != 3);
    }

    
// METHOD: Decimal to Binary ----------------------------------------------------------------------------------------------- 
    static int decimalToBinary(int n) {
    int binary = 0;
    int place = 1;

    while (n > 0) {
        int r = n % 2;
        binary = binary + r * place;
        place *= 10;
        n /= 2;
    }
    return binary;
}

    
// METHOD: Decimal to Octal ----------------------------------------------------------------------------------------------- 
static int decimalToOctal(int n) {
    int oct = 0;
    int place = 1;

    while (n > 0) {
        int r = n % 8;
        oct = oct + (r * place);
        place *= 10;
        n = n / 8;
    }

    return oct;
}

// METHOD: Decimal to Hexadecimal ----------------------------------------------------------------------------------------- 
    static String decimalToHex(int n) {
        String hex = "";
        while (n > 0) {
            int r = n % 16;
            if (r < 10)
                hex = r + hex;
            else if (r == 10)
                hex = 'A' + hex;
            else if (r == 11)
                hex = 'B' + hex;
            else if (r == 12)
                hex = 'C' + hex;
            else if (r == 13)
                hex = 'D' + hex;
            else if (r == 14)
                hex = 'E' + hex;
            else if (r == 15)
                hex = 'F' + hex;
            n = n / 16;
        }
        return hex;
    }


// METHOD: Convert any base (2, 8, 16) to Decimal --------------------------------------------------------------------------- 
    static int convertToDecimal(String num, int base) {
        int decimal = 0;
        int pow = 1; 
        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            int value;

            
            if (ch >= '0' && ch <= '9') {
                value = ch - '0';
            } else if (ch == 'A' || ch == 'a') value = 10;
            else if (ch == 'B' || ch == 'b') value = 11;
            else if (ch == 'C' || ch == 'c') value = 12;
            else if (ch == 'D' || ch == 'd') value = 13;
            else if (ch == 'E' || ch == 'e') value = 14;
            else if (ch == 'F' || ch == 'f') value = 15;
            else return -1;

            if (value >= base) return -1;

            decimal = decimal + (value * pow);
            pow = pow * base;
        }
        return decimal;
    }


// METHOD: Display Result in chosen base ----------------------------------------------------------------------------------------- 
    static void printResult(int result, int base) {
        System.out.println("-------------------------------------------");
        System.out.println("| Result (Decimal): " + result);
        if (base == 2)
            System.out.println("| Result (Binary) : " + decimalToBinary(result));
        else if (base == 8)
            System.out.println("| Result (Octal)  : " + decimalToOctal(result));
        else if (base == 16)
            System.out.println("| Result (Hex)    : " + decimalToHex(result));
        System.out.println("-------------------------------------------");
    }
}
//Marcus G. Guido BSCS254