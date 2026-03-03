import java.util.Scanner;
public class OrbitalMechanics {
    public static void main(String[] args) {
// Gravitational constant ------------------------------------------------------------------------------------------------------------------------------------
        final double G = 6.67430e-11;

// ANSI color codes ------------------------------------------------------------------------------------------------------------------------------------
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";
        final String MAGENTA = "\u001B[35m";

        Scanner input = new Scanner(System.in);

// Input section ------------------------------------------------------------------------------------------------------------------------------------
        System.out.print(GREEN + "Enter mass of planet (kg): " + RESET);
        double M = input.nextDouble();

        System.out.print(GREEN + "Enter radius of planet (m): " + RESET);
        double R = input.nextDouble();

        System.out.print(GREEN + "Enter mass of satellite (kg): " + RESET);
        double m = input.nextDouble();

        System.out.print(GREEN + "Enter orbital altitude (m): " + RESET);
        double h = input.nextDouble();

// Calculations ------------------------------------------------------------------------------------------------------------------------------------
        double r = R + h; 
        double F = (G * M * m) / (r * r); 
        double vEsc = ((G * M * m) / R);
        double vOrb = ((G * M) / r);
        double T = (2 * Math.PI * r) / vOrb;

// Output Area ------------------------------------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.printf(MAGENTA + "Gravitational Force: %.4e N%n", F);
        System.out.printf("Escape Velocity: %.6f m/s%n", vEsc);
        System.out.printf("Orbital Velocity: %.6f m/s%n", vOrb);
        System.out.printf("Orbital Period: %.3f seconds%n" + RESET, T);
    }
}


