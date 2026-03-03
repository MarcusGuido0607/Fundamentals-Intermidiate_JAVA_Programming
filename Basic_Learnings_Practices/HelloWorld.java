import java.util.Scanner;
public class HelloWorld {

    // GLOBAL declaration of the input object
    //all methods can access this object
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //method call with no argument/s
        Hello();
        Hello();
        Hello();

        // method call with an argument
        HelloName("Mary");
        HelloName("John");

        //String declaration with an initial/starting value of empty
        //Local declaration- variables and value are only available inside the method, exclusive to the method where it is declared.. other methods cannot use it
        String firstName = "";
        int age = 0;

        System.out.println("Please enter a name:");
        firstName = input.nextLine();

        System.out.println("Enter the age:");
        age = input.nextInt();

        NameAge(firstName, age);

        //method call but value is entered by the user
        HelloName(firstName);

    }

    static void Hello() {

        System.out.println("Hello World!");

    }

    static void HelloName(String name) {
        System.out.println("Hi" + " " + name);
    }

    static void NameAge(String name, int age) {
        System.out.println("Hello" + " " + name);
        System.out.println("Your age is" + " " + age);
    }
}
