// ============================================================================
// PARKING SYSTEM CLASS - Main system managing all parking lots
// Coordinates parking operations across all lots
// ============================================================================

import java.util.ArrayList;
import java.util.List;

public class ParkingSystem {
    // -------------------- ATTRIBUTES --------------------
    private ParkingLot parkingA;  // Motorcycle parking (10 spots)
    private ParkingLot parkingB;  // Car parking (8 spots)
    private ParkingLot parkingC;  // Truck parking (5 spots)
    
    // -------------------- CONSTRUCTOR --------------------
    public ParkingSystem() {
        // Initialize parking lots with specified capacities
        parkingA = new ParkingLot("A", "Parking A", "Motorcycle", 10);
        parkingB = new ParkingLot("B", "Parking B", "Car", 8);
        parkingC = new ParkingLot("C", "Parking C", "Truck", 5);
    }
    
    // -------------------- PARKING OPERATIONS --------------------
    /**
     * Parks a vehicle in the appropriate parking lot
     * @param vehicle Vehicle to park
     * @param spotNumber Desired spot number
     * @return true if successful, false otherwise
     */
    public boolean parkVehicle(Vehicle vehicle, int spotNumber) {
        ParkingLot lot = getParkingLotForVehicle(vehicle);
        if (lot == null) {
            return false;
        }
        return lot.parkVehicle(vehicle, spotNumber);
    }
    
    /**
     * Removes a vehicle from any parking lot
     * @param licensePlate License plate of vehicle to remove
     * @return The removed vehicle with parking info, or null if not found
     */
    public Vehicle removeVehicle(String licensePlate) {
        // Try each parking lot
        Vehicle removed = parkingA.removeVehicle(licensePlate);
        if (removed != null) return removed;
        
        removed = parkingB.removeVehicle(licensePlate);
        if (removed != null) return removed;
        
        removed = parkingC.removeVehicle(licensePlate);
        if (removed != null) return removed;
        
        return null;
    }
    
    // -------------------- QUERY METHODS --------------------
    /**
     * Gets the appropriate parking lot for a vehicle type
     * @param vehicle Vehicle to get parking lot for
     * @return ParkingLot or null if invalid vehicle type
     */
    public ParkingLot getParkingLotForVehicle(Vehicle vehicle) {
        String type = vehicle.getVehicleType();
        switch (type) {
            case "Motorcycle":
                return parkingA;
            case "Car":
                return parkingB;
            case "Truck":
                return parkingC;
            default:
                return null;
        }
    }
    
    /**
     * Gets parking lot by vehicle type string
     * @param vehicleType Type of vehicle (Motorcycle, Car, Truck)
     * @return ParkingLot or null if invalid type
     */
    public ParkingLot getParkingLotByType(String vehicleType) {
        switch (vehicleType) {
            case "Motorcycle":
                return parkingA;
            case "Car":
                return parkingB;
            case "Truck":
                return parkingC;
            default:
                return null;
        }
    }
    
    /**
     * Finds a vehicle by license plate across all lots
     * @param licensePlate License plate to search for
     * @return Vehicle if found, null otherwise
     */
    public Vehicle findVehicle(String licensePlate) {
        Vehicle found = parkingA.findVehicle(licensePlate);
        if (found != null) return found;
        
        found = parkingB.findVehicle(licensePlate);
        if (found != null) return found;
        
        found = parkingC.findVehicle(licensePlate);
        if (found != null) return found;
        
        return null;
    }
    
    /**
     * Gets all vehicles across all parking lots
     * @return List of all parked vehicles
     */
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.addAll(parkingA.getAllVehicles());
        allVehicles.addAll(parkingB.getAllVehicles());
        allVehicles.addAll(parkingC.getAllVehicles());
        return allVehicles;
    }
    
    // -------------------- GETTERS --------------------
    public ParkingLot getParkingA() {
        return parkingA;
    }
    
    public ParkingLot getParkingB() {
        return parkingB;
    }
    
    public ParkingLot getParkingC() {
        return parkingC;
    }
    
    // -------------------- STATISTICS --------------------
    /**
     * Gets total number of vehicles parked
     * @return Total count
     */
    public int getTotalOccupiedSpots() {
        return parkingA.getOccupiedCount() + 
               parkingB.getOccupiedCount() + 
               parkingC.getOccupiedCount();
    }
    
    /**
     * Gets total available spots
     * @return Total available
     */
    public int getTotalAvailableSpots() {
        return parkingA.getAvailableCount() + 
               parkingB.getAvailableCount() + 
               parkingC.getAvailableCount();
    }
    
    /**
     * Gets total capacity
     * @return Total capacity across all lots
     */
    public int getTotalCapacity() {
        return parkingA.getCapacity() + 
               parkingB.getCapacity() + 
               parkingC.getCapacity();
    }
}
