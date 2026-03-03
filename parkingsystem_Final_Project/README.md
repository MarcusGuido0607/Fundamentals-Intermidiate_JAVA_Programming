# NU CEBU Smart Parking Management System
**Developed by Marcus G. Guido**  
**Enhanced Version 2.0**

---

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [System Architecture](#system-architecture)
- [File Structure](#file-structure)
- [Installation & Setup](#installation--setup)
- [How to Run](#how-to-run)
- [User Guide](#user-guide)
- [Technical Details](#technical-details)

---

## 🎯 Overview

A comprehensive parking management system built with Java Swing that provides a modern, user-friendly interface for managing parking spaces for motorcycles, cars, and trucks. The system features real-time parking visualization, time tracking, and data persistence through object-oriented design.

---

## ✨ Features

### Core Functionality
- ✅ **Real-time Parking Management** - Park and remove vehicles with live updates
- ✅ **Time Tracking** - Automatic tracking of parking duration
- ✅ **Interactive Spot Selection** - Click-to-select parking spots with visual feedback
- ✅ **Vehicle Search** - Quick vehicle lookup by license plate
- ✅ **Status Dashboard** - Complete overview of all parking lots

### Vehicle Types
- 🏍️ **Motorcycles** - Parking A (10 spots)
- 🚗 **Cars** - Parking B (8 spots)
- 🚛 **Trucks** - Parking C (5 spots)

### User Interface
- Modern NU-themed design with official colors
- Fully resizable and responsive layout
- Color-coded parking spots (Available/Occupied/Selected)
- Smooth navigation with CardLayout
- Professional dialogs and notifications

### Data Management
- Object-oriented architecture with proper encapsulation
- Type-safe vehicle management through inheritance
- Efficient spot allocation algorithm
- Duplicate prevention system

---

## 🏗️ System Architecture

### Class Hierarchy

```
Vehicle (Abstract Base Class)
├── Motorcycle
├── Car
└── Truck

ParkingLot (Manages individual parking areas)
└── ParkingSystem (Coordinates all parking lots)

ParkingSystemGUI (Main application interface)
```

### Design Patterns Used
- **Inheritance** - Vehicle class hierarchy
- **Encapsulation** - Private fields with public getters/setters
- **Polymorphism** - Abstract methods for vehicle types
- **Composition** - ParkingSystem contains ParkingLot objects

---

## 📁 File Structure

```
ParkingSystemProject/
│
├── Vehicle.java              # Abstract base class for all vehicles
├── Motorcycle.java           # Motorcycle vehicle implementation
├── Car.java                  # Car vehicle implementation
├── Truck.java                # Truck vehicle implementation
├── ParkingLot.java           # Individual parking lot management
├── ParkingSystem.java        # Central parking system coordinator
├── ParkingSystemGUI.java     # Main GUI application
├── nu.jpg                    # NU logo image (required)
└── README.md                 # This file
```

---

## 🚀 Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Text editor or IDE (Eclipse, IntelliJ IDEA, NetBeans, or VS Code)

### Step 1: Download Files
1. Download all `.java` files
2. Create a project folder (e.g., `ParkingSystem`)
3. Place all files in the same directory

### Step 2: Add NU Logo
1. Save the NU logo as `nu.jpg` in the project folder
2. Recommended size: 200x200 pixels
3. If logo not available, system will display text placeholder

### Step 3: Verify File Structure
Ensure all files are in the same folder:
```
ParkingSystem/
├── Vehicle.java
├── Motorcycle.java
├── Car.java
├── Truck.java
├── ParkingLot.java
├── ParkingSystem.java
├── ParkingSystemGUI.java
└── nu.jpg
```

---

## ▶️ How to Run

### Method 1: Command Line

#### Compile:
```bash
javac *.java
```

#### Run:
```bash
java ParkingSystemGUI
```

### Method 2: Using IDE

#### Eclipse / IntelliJ IDEA / NetBeans:
1. Create new Java project
2. Import all `.java` files
3. Add `nu.jpg` to project root
4. Run `ParkingSystemGUI.java`

### Method 3: Using VS Code
1. Install Java Extension Pack
2. Open project folder
3. Press F5 or click "Run" on `ParkingSystemGUI.java`

---

## 📖 User Guide

### 1️⃣ Parking a Vehicle

**Step-by-step:**
1. Click **"PARK VEHICLE"** on the main menu
2. Fill in vehicle information:
   - Select vehicle type (Motorcycle/Car/Truck)
   - Enter license plate
   - Enter driver name
   - Enter phone number
3. Click **"NEXT: SELECT SPOT →"**
4. Click on a **green** (available) parking spot
5. Click **"✓ CONFIRM PARKING"**
6. System confirms parking with details

**Notes:**
- Only designated vehicle types can park in their respective lots
- Duplicate license plates are prevented
- Selected spot is highlighted in blue
- Occupied spots are shown in red

### 2️⃣ Removing a Vehicle

**Step-by-step:**
1. Click **"REMOVE VEHICLE"** on the main menu
2. Enter the license plate number
3. Click **"🔍 SEARCH VEHICLE"**
4. Review vehicle information displayed:
   - Vehicle type and icon
   - Driver details
   - Parking duration
   - Spot number
5. Click **"✓ REMOVE VEHICLE"**
6. System confirms removal with time parked

**Notes:**
- Case-insensitive license plate search
- Displays total time parked
- Spot becomes immediately available after removal

### 3️⃣ Viewing Status

**Step-by-step:**
1. Click **"VIEW STATUS"** on the main menu
2. View overall statistics:
   - Total capacity across all lots
   - Total occupied spots
   - Total available spots
3. View individual parking lot details:
   - Each lot shows occupancy ratio
   - List of all parked vehicles
   - Spot numbers and parking duration
4. Click **"🔄 REFRESH"** to update data
5. Click **"← BACK"** to return to main menu

**Notes:**
- Real-time updates with refresh button
- Color-coded occupancy indicators
- Scrollable vehicle lists

---

## 🔧 Technical Details

### Vehicle Class (Abstract)
**Attributes:**
- `licensePlate` - String
- `driverName` - String
- `phoneNumber` - String
- `parkingTime` - LocalDateTime
- `spotNumber` - int

**Methods:**
- `getVehicleType()` - Abstract, returns vehicle type
- `getVehicleIcon()` - Abstract, returns emoji icon
- `getFormattedParkingTime()` - Returns formatted date/time
- `getTimeParked()` - Calculates duration parked

### ParkingLot Class
**Attributes:**
- `lotId` - String (A, B, or C)
- `lotName` - String (Parking A, B, or C)
- `vehicleType` - String (Motorcycle, Car, or Truck)
- `capacity` - int (10, 8, or 5)
- `spots` - Vehicle[] array

**Key Methods:**
- `parkVehicle(Vehicle, int)` - Parks vehicle at specific spot
- `removeVehicle(String)` - Removes vehicle by license plate
- `getAvailableSpots()` - Returns list of available spot numbers
- `findVehicle(String)` - Searches for vehicle by license plate
- `isSpotOccupied(int)` - Checks if spot is occupied

### ParkingSystem Class
**Attributes:**
- `parkingA` - ParkingLot for motorcycles (10 spots)
- `parkingB` - ParkingLot for cars (8 spots)
- `parkingC` - ParkingLot for trucks (5 spots)

**Key Methods:**
- `parkVehicle(Vehicle, int)` - Routes to appropriate lot
- `removeVehicle(String)` - Searches all lots
- `findVehicle(String)` - Searches across all lots
- `getTotalOccupiedSpots()` - Total system occupancy
- `getTotalAvailableSpots()` - Total system availability

### GUI Components
**Color Scheme (NU Theme):**
- NU Blue: RGB(0, 31, 91)
- NU Gold: RGB(255, 184, 28)
- Available: RGB(76, 175, 80) - Green
- Occupied: RGB(244, 67, 54) - Red
- Selected: RGB(33, 150, 243) - Blue

**Panels:**
- Welcome Panel - Main menu with gradient background
- Park Vehicle Panel - Input form for vehicle details
- Select Spot Panel - Interactive parking grid
- Remove Vehicle Panel - Search and remove interface
- Status Panel - Statistics and vehicle listing

---

## 🎨 Customization

### Changing Parking Capacities
Edit `ParkingSystem.java` constructor:
```java
parkingA = new ParkingLot("A", "Parking A", "Motorcycle", 10); // Change 10
parkingB = new ParkingLot("B", "Parking B", "Car", 8);         // Change 8
parkingC = new ParkingLot("C", "Parking C", "Truck", 5);       // Change 5
```

### Changing Colors
Edit color constants in `ParkingSystemGUI.java`:
```java
private static final Color NU_BLUE = new Color(0, 31, 91);
private static final Color NU_GOLD = new Color(255, 184, 28);
// etc.
```

### Adding New Vehicle Types
1. Create new class extending `Vehicle`
2. Override `getVehicleType()` and `getVehicleIcon()`
3. Add new ParkingLot in `ParkingSystem`
4. Update GUI dropdown and switch statements

---

## 📊 System Specifications

**Total Capacity:** 23 parking spots
- Motorcycles: 10 spots
- Cars: 8 spots
- Trucks: 5 spots

**Data Persistence:** In-memory (session-based)
**Concurrent Access:** Single-user application
**Platform:** Cross-platform (Java Swing)

---

## 🐛 Troubleshooting

### Issue: Logo doesn't appear
**Solution:** Ensure `nu.jpg` is in the same directory as the `.class` files

### Issue: Compilation errors
**Solution:** 
1. Check Java version: `java -version`
2. Ensure all files are in same directory
3. Compile in correct order or use `javac *.java`

### Issue: GUI doesn't display properly
**Solution:**
1. Check screen resolution (minimum 1200x800)
2. Update Java to latest version
3. Try different look and feel

---

## 📝 Code Comments Guide

All code includes detailed comments:
- `// ---------- SECTION ----------` - Major section dividers
- `/** JavaDoc comments */` - Method documentation
- `// Inline comments` - Code explanation

---

## 👨‍💻 Developer Information

**Developer:** Marcus G. Guido  
**Version:** 2.0 Enhanced  
**Date:** 2024  
**Institution:** National University Cebu  
**Course:** Computer Science / Programming

---

## 📄 License

This project is created for educational purposes.
Free to use and modify for academic projects.

---

## 🙏 Acknowledgments

- National University Cebu for the branding
- Java Swing documentation and community
- Object-Oriented Programming principles

---

## 📞 Support

For issues or questions:
1. Review this README thoroughly
2. Check code comments in each file
3. Verify all prerequisites are met
4. Ensure files are properly organized

---

**END OF DOCUMENTATION**

*Built with ☕ Java and 💙 for clean code*
