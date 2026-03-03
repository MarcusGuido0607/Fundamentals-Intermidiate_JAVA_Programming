# 🚀 QUICK START GUIDE
## NU CEBU Smart Parking Management System

---

## ⚡ Super Quick Setup (3 Steps)

### 1️⃣ Download & Organize
```
Create a folder called "ParkingSystem"
Put all 7 .java files in that folder
Add nu.jpg logo to the same folder (optional)
```

### 2️⃣ Compile
Open terminal/command prompt in the folder and run:
```bash
javac *.java
```

### 3️⃣ Run
```bash
java ParkingSystemGUI
```

**That's it! The application should launch.**

---

## 📋 Files Checklist

Make sure you have these files:
- ✅ Vehicle.java
- ✅ Motorcycle.java
- ✅ Car.java
- ✅ Truck.java
- ✅ ParkingLot.java
- ✅ ParkingSystem.java
- ✅ ParkingSystemGUI.java
- ⭕ nu.jpg (optional - will show text if missing)

---

## 🎮 Using the Application

### Park a Vehicle:
1. Click "PARK VEHICLE"
2. Fill in: Type, Plate, Name, Phone
3. Click "NEXT"
4. Click a GREEN parking spot
5. Click "CONFIRM"

### Remove a Vehicle:
1. Click "REMOVE VEHICLE"
2. Enter license plate
3. Click "SEARCH"
4. Review info
5. Click "REMOVE"

### Check Status:
1. Click "VIEW STATUS"
2. See all parking info
3. Click "REFRESH" to update

---

## 🎨 Parking Lot Configuration

| Lot | Type | Capacity | Icon |
|-----|------|----------|------|
| A | Motorcycle | 10 spots | 🏍️ |
| B | Car | 8 spots | 🚗 |
| C | Truck | 5 spots | 🚛 |

**Total: 23 parking spots**

---

## 🔴 Common Errors & Fixes

### Error: "javac not found"
**Fix:** Install Java JDK
- Windows: Download from oracle.com/java
- Mac: `brew install openjdk`
- Linux: `sudo apt install default-jdk`

### Error: "Could not find or load main class"
**Fix:** Make sure you're in the right folder when running:
```bash
cd path/to/ParkingSystem
java ParkingSystemGUI
```

### Logo doesn't show
**Fix:** Either:
1. Add nu.jpg to the folder, OR
2. Ignore it - text will display instead

---

## 💡 Tips

- Minimum screen size: 1200x800
- Works on Windows, Mac, Linux
- No internet required
- No database setup needed
- Data resets when you close the app

---

## 🎯 Features at a Glance

✅ User-friendly GUI with NU colors  
✅ Click-to-select parking spots  
✅ Real-time availability tracking  
✅ Time-parked calculation  
✅ Duplicate prevention  
✅ Vehicle search by plate  
✅ Complete status dashboard  
✅ Professional notifications  

---

**Need more help?** Read the full README.md

**Ready to code?** All files are documented with comments

**Want to customize?** Check the Technical Details in README.md

---

*Developed by Marcus G. Guido*  
*Enhanced Version 2.0*
