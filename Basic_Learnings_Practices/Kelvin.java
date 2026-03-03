import java.util.Scanner;
public class Kelvin{
    public static void main(String[] args) {
        Scanner celsiusInput = new Scanner(System.in);
        System.out.println("Please enter your current temperature in Celsius");

        float celsius = celsiusInput.nextFloat();
        float kelvin = celsius + 273.15f;

        System.out.println("Your temperature in Kelvin is " + kelvin);
    }
}
// import java.util.Scanner;
// public class Kelvin {
//     public static void main(String[] args) {
//     Scanner input = new Scanner (System.in);
        
//         System.out.println("Please Inter the Temperature in Celsius: ");
//         Double celsius = input.nextDouble();

//         System.out.println("This is the temperature in Kelvin: " +(celsius + 273.15));


//     }
// }
