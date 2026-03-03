import java.util.Scanner;
public class PhysicsCalculations {
    static Scanner input = new Scanner(System.in);
    static double mass, velocity;

    public static void main(String[] args) {
        getInput(); 
        double momentum = computeMomentum(); 
        double kineticE = computeKineticE(); 
        double ratio = computeRatio(kineticE, momentum);  
        double energyPerMass = computeEnergyPerMass(kineticE);
        
        showResults(momentum, kineticE, ratio, energyPerMass);
    }


// Input AreA ---------------------------------------------------------------------------------------------------------------------------------------------------- 
    static void getInput() {
        System.out.println("Enter mass of object (kg): ");
        mass = input.nextDouble();
        System.out.println("Enter velocity of object (m/s): ");
        velocity = input.nextDouble();
    }


// Method Process part -------------------------------------------------------------------------------------------------------------------------------------------
    // Method 1 momentum 
    static double computeMomentum() {return mass * velocity;}

    // Method 2 kinetic energy
    static double computeKineticE() {return 0.5 * mass * velocity * velocity;}

    // Method 3 ratio of kinetic energy to momentum
    static double computeRatio(double kineticE, double momentum) {return kineticE / momentum;}

    // Method 4 energy per unit mass
    static double computeEnergyPerMass(double kineticE) {return kineticE / mass;}
    

// Output Area --------------------------------------------------------------------------------------------------------------------------------------------------
    static void showResults(double momentum, double kineticE, double ratio, double energyPerMass) {
        System.out.println("\n--- Results ---");
        System.out.printf("Momentum (p): %.1f kg·m/s%n", momentum);
        System.out.printf("Kinetic Energy (KE): %.0f J%n", kineticE);
        System.out.printf("Ratio (KE/p): %.1f%n", ratio);
        System.out.printf("Energy per Unit Mass (KE/m): %.1f J/kg%n", energyPerMass);
    }
}

// Marcus Done Po -----------------------------------------------------------------------------------------------------------------------------------------------