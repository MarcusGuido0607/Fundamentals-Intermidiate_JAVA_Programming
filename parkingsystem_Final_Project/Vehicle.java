// ============================================================================
// VEHICLE CLASS - Base class for all vehicle types
// Represents a vehicle with common properties
// ============================================================================

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Vehicle {
    // -------------------- ATTRIBUTES --------------------
    private String licensePlate;
    private String driverName;
    private String phoneNumber;
    private LocalDateTime parkingTime;
    private int spotNumber;
    
    // -------------------- CONSTRUCTOR --------------------
    public Vehicle(String licensePlate, String driverName, String phoneNumber) {
        this.licensePlate = licensePlate;
        this.driverName = driverName;
        this.phoneNumber = phoneNumber;
        this.parkingTime = LocalDateTime.now();
        this.spotNumber = -1;
    }
    
    // -------------------- ABSTRACT METHODS --------------------
    public abstract String getVehicleType();
    public abstract String getVehicleIcon();
    
    // -------------------- GETTERS --------------------
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public LocalDateTime getParkingTime() {
        return parkingTime;
    }
    
    public int getSpotNumber() {
        return spotNumber;
    }
    
    // -------------------- SETTERS --------------------
    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
    
    // -------------------- UTILITY METHODS --------------------
    public String getFormattedParkingTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a");
        return parkingTime.format(formatter);
    }
    
    public String getTimeParked() {
        LocalDateTime now = LocalDateTime.now();
        long minutes = java.time.Duration.between(parkingTime, now).toMinutes();
        
        if (minutes < 60) {
            return minutes + " minutes";
        } else if (minutes < 1440) { // Less than 24 hours
            long hours = minutes / 60;
            long remainingMinutes = minutes % 60;
            return hours + " hour(s) " + remainingMinutes + " min(s)";
        } else {
            long days = minutes / 1440;
            long remainingHours = (minutes % 1440) / 60;
            return days + " day(s) " + remainingHours + " hour(s)";
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s | %s | Driver: %s | Spot: %d", 
            getVehicleType(), licensePlate, driverName, spotNumber + 1);
    }
}
