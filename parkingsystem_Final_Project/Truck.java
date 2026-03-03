// ============================================================================
// TRUCK CLASS - Represents a truck vehicle
// Extends Vehicle base class
// ============================================================================

public class Truck extends Vehicle {
    
    // -------------------- CONSTRUCTOR --------------------
    public Truck(String licensePlate, String driverName, String phoneNumber) {
        super(licensePlate, driverName, phoneNumber);
    }
    
    // -------------------- OVERRIDDEN METHODS --------------------
    @Override
    public String getVehicleType() {
        return "Truck";
    }
    
    @Override
    public String getVehicleIcon() {
        return "🚛";
    }
}
