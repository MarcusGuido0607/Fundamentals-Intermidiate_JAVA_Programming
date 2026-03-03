import java.util.Scanner;
 
public class TravelCostvoid {
static Scanner input = new Scanner(System.in); 
    public static void main(String[] args) {
        GetValues(); // start program flow
    }
 
//PAG DECLARE SA VARIABLE FLOATING VALUES -----------------------------------------------------------------     
    static void GetValues() {
        float distance = 0;
        float consumption = 0; 
        float pricePerLiter = 0;

//INPUT area sa code -------------------------------------------------------------------------------- 
        System.out.print("Enter distance to travel (km): ");
        distance = input.nextFloat();
 
        System.out.print("Enter fuel consumption (liters/km): ");
        consumption = input.nextFloat();
 
        System.out.print("Enter price of fuel per liter: ");
        pricePerLiter = input.nextFloat();
 
        System.out.println(" ");


//METHOD NAME --------------------------------------------------------------------------------    
        TotalFuelNeeded(distance, consumption);
        TotalFuelCost(distance, consumption, pricePerLiter);
        FuelCostPerKm(distance, consumption, pricePerLiter);
    }


//CALCULATION AREA NI ---------------------------------------------------------------------------- 
    // Step 1: Calculate total fuel needed
    static void TotalFuelNeeded(float distance, float consumption) {
        float totalFuel = distance * consumption;
        DisplayTotalFuelNeeded(totalFuel);
    }
 
    // Step 2: Calculate total fuel cost
    static void TotalFuelCost(float distance, float consumption, float pricePerLiter) {
        float totalFuel = distance * consumption;
        float totalCost = totalFuel * pricePerLiter;
        DisplayTotalFuelCost(totalCost);
    }
 
    // Step 3: Calculate fuel cost per kilometer
    static void FuelCostPerKm(float distance, float consumption, float pricePerLiter) {
        float totalFuel = distance * consumption;
        float totalCost = totalFuel * pricePerLiter;
        float costPerKm = totalCost / distance;
        DisplayFuelCostPerKm(costPerKm);
    }


//DISPLAY AREA ---------------------------------------------------------------------------------------------
    // Step 4: Display total fuel needed
    static void DisplayTotalFuelNeeded(float totalFuel) {
        System.out.println("Total Fuel Needed: " + totalFuel + " liters");
    }
 
    // Step 5: Display total fuel cost
    static void DisplayTotalFuelCost(float totalCost) {
        System.out.println("Total Fuel Cost: " + totalCost);
    }
 
    // Step 6: Display cost per kilometer
    static void DisplayFuelCostPerKm(float costPerKm) {
        System.out.println("Fuel Cost per Kilometer: " + costPerKm);
    }
}

// PS. Marcus :>