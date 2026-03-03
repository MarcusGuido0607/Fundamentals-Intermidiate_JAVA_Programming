// ============================================================================
// MOTORCYCLE CLASS - Represents a motorcycle vehicle
// Extends Vehicle base class
// ============================================================================

public class Motorcycle extends Vehicle {
    
    // -------------------- CONSTRUCTOR --------------------
    public Motorcycle(String licensePlate, String driverName, String phoneNumber) {
        super(licensePlate, driverName, phoneNumber);
    }
    
    // -------------------- OVERRIDDEN METHODS --------------------
    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
    
    @Override
    public String getVehicleIcon() {
        return "🏍️";
    }
}
