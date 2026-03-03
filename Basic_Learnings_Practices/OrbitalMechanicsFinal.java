import java.util.Scanner;
public class OrbitalMechanicsFinal {
    static Scanner input = new Scanner(System.in);
    static final double G = 6.67430e-11;
    static double Mkg, Radius, Msatellite, altitude, distance;

    
//PAG DECLARE VARIABLE VALUES ---------------------------------------------------------------------------------
    public static void main(String[] args) {
        getInput();  
        distance = computeDistance(); 
        double force = computeGravitationalForce(); 
        double escVel = computeEscapeVelocity();   
        double orbVel = computeOrbitalVelocity();   
        double orbPeriod = computeOrbitalPeriod(); 

        showResults(force, escVel, orbVel, orbPeriod); 
    }

// INPUT METHODs --------------------------------------------------------------------------------------------
    static void getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter mass of planet (kg): ");
        Mkg = sc.nextDouble();
        System.out.print("Enter radius of planet (m): ");
        Radius = sc.nextDouble();
        System.out.print("Enter mass of satellite (kg): ");
        Msatellite = sc.nextDouble();
        System.out.print("Enter orbital altitude (m): ");
        altitude = sc.nextDouble();
    }

// PROCESS METHODS ------------------------------------------------------------------------------------------
    //Method 1
    static double computeDistance() { return Radius + altitude; }
    
    //Method 2
    static double computeGravitationalForce() { return (G * Mkg * Msatellite) / (distance * distance); }
    
    //Method 3
    static double computeEscapeVelocity() { return Math.sqrt((2 * G * Mkg) / Radius); }
    
    //Method 4
    static double computeOrbitalVelocity() { return Math.sqrt((G * Mkg) / distance); }

    //Method 5 
    static double computeOrbitalPeriod() { return (2 * Math.PI * distance) / computeOrbitalVelocity(); }


// OUTPUT METHOD ------------------------------------------------------------------------------------------
    static void showResults(double force, double escVel, double orbVel, double orbPeriod) {
        System.out.println("\n========== RESULTS ==========\n");
        System.out.printf("Gravitational Force: %.3e N%n", force);
        System.out.printf("Escape Velocity: %.6f m/s%n", escVel);
        System.out.printf("Orbital Velocity: %.6f m/s%n", orbVel);
        System.out.printf("Orbital Period: %.3f seconds%n", orbPeriod);
    }
}
