// ============================================================================
// CAR CLASS - Represents a car vehicle
// Extends Vehicle base class
// ============================================================================

public class Car extends Vehicle {
    
    // -------------------- CONSTRUCTOR --------------------
    public Car(String licensePlate, String driverName, String phoneNumber) {
        super(licensePlate, driverName, phoneNumber);
    }
    
    // -------------------- OVERRIDDEN METHODS --------------------
    @Override
    public String getVehicleType() {
        return "Car";
    }
    
    @Override
    public String getVehicleIcon() {
        return "🚗";
    }
}
