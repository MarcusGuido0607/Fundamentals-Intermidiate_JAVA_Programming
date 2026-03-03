// ============================================================================
// PARKING LOT CLASS - Manages a specific parking area
// Handles parking, removal, and spot management
// ============================================================================

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    // -------------------- ATTRIBUTES --------------------
    private String lotId;           // A, B, or C
    private String lotName;         // Parking A, B, or C
    private String vehicleType;     // Motorcycle, Car, or Truck
    private int capacity;           // Total spots available
    private Vehicle[] spots;        // Array to store vehicles in spots
    
    // -------------------- CONSTRUCTOR --------------------
    public ParkingLot(String lotId, String lotName, String vehicleType, int capacity) {
        this.lotId = lotId;
        this.lotName = lotName;
        this.vehicleType = vehicleType;
        this.capacity = capacity;
        this.spots = new Vehicle[capacity];
    }
    
    // -------------------- PARKING OPERATIONS --------------------
    /**
     * Parks a vehicle in a specific spot
     * @param vehicle Vehicle to park
     * @param spotNumber Spot number (0-indexed)
     * @return true if successful, false otherwise
     */
    public boolean parkVehicle(Vehicle vehicle, int spotNumber) {
        // Validate vehicle type
        if (!vehicle.getVehicleType().equals(this.vehicleType)) {
            return false;
        }
        
        // Validate spot number
        if (spotNumber < 0 || spotNumber >= capacity) {
            return false;
        }
        
        // Check if spot is available
        if (spots[spotNumber] != null) {
            return false;
        }
        
        // Park the vehicle
        spots[spotNumber] = vehicle;
        vehicle.setSpotNumber(spotNumber);
        return true;
    }
    
    /**
     * Removes a vehicle by license plate
     * @param licensePlate License plate of vehicle to remove
     * @return The removed vehicle, or null if not found
     */
    public Vehicle removeVehicle(String licensePlate) {
        for (int i = 0; i < capacity; i++) {
            if (spots[i] != null && spots[i].getLicensePlate().equalsIgnoreCase(licensePlate)) {
                Vehicle removedVehicle = spots[i];
                spots[i] = null;
                return removedVehicle;
            }
        }
        return null;
    }
    
    // -------------------- QUERY METHODS --------------------
    /**
     * Gets all available spot numbers
     * @return List of available spot numbers
     */
    public List<Integer> getAvailableSpots() {
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (spots[i] == null) {
                available.add(i);
            }
        }
        return available;
    }
    
    /**
     * Gets all occupied spot numbers
     * @return List of occupied spot numbers
     */
    public List<Integer> getOccupiedSpots() {
        List<Integer> occupied = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (spots[i] != null) {
                occupied.add(i);
            }
        }
        return occupied;
    }
    
    /**
     * Gets all parked vehicles
     * @return List of all vehicles currently parked
     */
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (spots[i] != null) {
                vehicles.add(spots[i]);
            }
        }
        return vehicles;
    }
    
    /**
     * Finds a vehicle by license plate
     * @param licensePlate License plate to search for
     * @return Vehicle if found, null otherwise
     */
    public Vehicle findVehicle(String licensePlate) {
        for (int i = 0; i < capacity; i++) {
            if (spots[i] != null && spots[i].getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return spots[i];
            }
        }
        return null;
    }
    
    /**
     * Checks if a specific spot is occupied
     * @param spotNumber Spot number to check
     * @return true if occupied, false if available
     */
    public boolean isSpotOccupied(int spotNumber) {
        if (spotNumber < 0 || spotNumber >= capacity) {
            return false;
        }
        return spots[spotNumber] != null;
    }
    
    // -------------------- GETTERS --------------------
    public String getLotId() {
        return lotId;
    }
    
    public String getLotName() {
        return lotName;
    }
    
    public String getVehicleType() {
        return vehicleType;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public int getOccupiedCount() {
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            if (spots[i] != null) {
                count++;
            }
        }
        return count;
    }
    
    public int getAvailableCount() {
        return capacity - getOccupiedCount();
    }
    
    public Vehicle getVehicleAtSpot(int spotNumber) {
        if (spotNumber < 0 || spotNumber >= capacity) {
            return null;
        }
        return spots[spotNumber];
    }
    
    // -------------------- UTILITY METHODS --------------------
    @Override
    public String toString() {
        return String.format("%s (%s) - %d/%d occupied", 
            lotName, vehicleType, getOccupiedCount(), capacity);
    }
}
