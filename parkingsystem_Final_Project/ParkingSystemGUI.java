// ============================================================================
// PARKING SYSTEM GUI - Main Application Window
// NU CEBU Smart Parking Management System
// Developed by: Marcus G. Guido
// ============================================================================

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ParkingSystemGUI extends JFrame {
    
    // -------------------- SYSTEM COMPONENTS --------------------
    private ParkingSystem parkingSystem;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    // -------------------- UI COLORS (NU THEME) --------------------
    private static final Color NU_BLUE = new Color(0, 31, 91);
    private static final Color NU_GOLD = new Color(255, 184, 28);
    private static final Color AVAILABLE_COLOR = new Color(76, 175, 80);
    private static final Color OCCUPIED_COLOR = new Color(244, 67, 54);
    private static final Color SELECTED_COLOR = new Color(33, 150, 243);
    private static final Color BG_COLOR = new Color(245, 245, 250);
    
    // -------------------- TEMP DATA FOR PARKING PROCESS --------------------
    private Vehicle tempVehicle = null;
    private int selectedSpot = -1;
    
    // -------------------- CONSTRUCTOR --------------------
    public ParkingSystemGUI() {
        // Initialize parking system
        parkingSystem = new ParkingSystem();
        
        // Setup main frame
        setTitle("NU CEBU - Smart Parking Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 900);
        setMinimumSize(new Dimension(1200, 800));
        setLocationRelativeTo(null);
        
        // Initialize card layout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(BG_COLOR);
        
        // Create all panels
        mainPanel.add(createWelcomePanel(), "WELCOME");
        mainPanel.add(createParkVehiclePanel(), "PARK");
        mainPanel.add(createSelectSpotPanel(), "SELECT_SPOT");
        mainPanel.add(createRemoveVehiclePanel(), "REMOVE");
        mainPanel.add(createViewStatusPanel(), "STATUS");
        
        add(mainPanel);
        
        // Show welcome screen
        cardLayout.show(mainPanel, "WELCOME");
        
        setVisible(true);
    }
    
    // ============================================================================
    // WELCOME PANEL - Main menu
    // ============================================================================
    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Gradient background
                GradientPaint gp = new GradientPaint(
                    0, 0, NU_BLUE,
                    0, getHeight(), new Color(0, 51, 131)
                );
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // -------------------- NU LOGO --------------------
        JLabel logoLabel = new JLabel();
        try {
            ImageIcon icon = new ImageIcon("nu.jpg");
            Image scaled = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            logoLabel.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            logoLabel.setText("NU LOGO");
            logoLabel.setFont(new Font("Arial", Font.BOLD, 30));
            logoLabel.setForeground(NU_GOLD);
        }
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0);
        panel.add(logoLabel, gbc);
        
        // -------------------- TITLE --------------------
        JLabel titleLabel = new JLabel("NU CEBU");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 70));
        titleLabel.setForeground(NU_GOLD);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        panel.add(titleLabel, gbc);
        
        // -------------------- SUBTITLE --------------------
        JLabel subtitleLabel = new JLabel("Smart Parking Management System");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        subtitleLabel.setForeground(Color.WHITE);
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 50, 0);
        panel.add(subtitleLabel, gbc);
        
        // -------------------- MENU BUTTONS --------------------
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 30, 30));
        buttonPanel.setOpaque(false);
        buttonPanel.setPreferredSize(new Dimension(800, 300));
        
        JButton parkBtn = createMenuButton("🚗 PARK VEHICLE", "Park a new vehicle", new Color(76, 175, 80));
        JButton removeBtn = createMenuButton("🔓 REMOVE VEHICLE", "Remove parked vehicle", new Color(255, 152, 0));
        JButton statusBtn = createMenuButton("📊 VIEW STATUS", "Check parking status", new Color(33, 150, 243));
        JButton exitBtn = createMenuButton("❌ EXIT", "Exit application", new Color(244, 67, 54));
        
        parkBtn.addActionListener(e -> {
            tempVehicle = null;
            selectedSpot = -1;
            cardLayout.show(mainPanel, "PARK");
        });
        
        removeBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "REMOVE");
        });
        
        statusBtn.addActionListener(e -> {
            refreshStatusPanel();
            cardLayout.show(mainPanel, "STATUS");
        });
        
        exitBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        
        buttonPanel.add(parkBtn);
        buttonPanel.add(removeBtn);
        buttonPanel.add(statusBtn);
        buttonPanel.add(exitBtn);
        
        gbc.gridy = 3;
        panel.add(buttonPanel, gbc);
        
        // -------------------- FOOTER --------------------
        JLabel footerLabel = new JLabel("Developed by Marcus G. Guido | Enhanced Version 2.0");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        footerLabel.setForeground(new Color(200, 200, 200));
        gbc.gridy = 4;
        gbc.insets = new Insets(40, 0, 20, 0);
        panel.add(footerLabel, gbc);
        
        return panel;
    }
    
    // ============================================================================
    // PARK VEHICLE PANEL - Input vehicle information
    // ============================================================================
    private JPanel createParkVehiclePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(BG_COLOR);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // -------------------- HEADER --------------------
        panel.add(createHeader("PARK NEW VEHICLE"), BorderLayout.NORTH);
        
        // -------------------- FORM PANEL --------------------
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(NU_BLUE, 3),
            new EmptyBorder(40, 60, 40, 60)
        ));
        
        // Vehicle Type Selection
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        typePanel.setBackground(Color.WHITE);
        JLabel typeLabel = new JLabel("Vehicle Type:");
        typeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        typeLabel.setPreferredSize(new Dimension(200, 30));
        
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Motorcycle", "Car", "Truck"});
        typeCombo.setFont(new Font("Arial", Font.PLAIN, 16));
        typeCombo.setPreferredSize(new Dimension(300, 40));
        
        typePanel.add(typeLabel);
        typePanel.add(typeCombo);
        formPanel.add(typePanel);
        formPanel.add(Box.createVerticalStrut(20));
        
        // License Plate
        JPanel platePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        platePanel.setBackground(Color.WHITE);
        JLabel plateLabel = new JLabel("License Plate:");
        plateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        plateLabel.setPreferredSize(new Dimension(200, 30));
        
        JTextField plateField = new JTextField();
        plateField.setFont(new Font("Arial", Font.PLAIN, 16));
        plateField.setPreferredSize(new Dimension(300, 40));
        
        platePanel.add(plateLabel);
        platePanel.add(plateField);
        formPanel.add(platePanel);
        formPanel.add(Box.createVerticalStrut(20));
        
        // Driver Name
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        namePanel.setBackground(Color.WHITE);
        JLabel nameLabel = new JLabel("Driver Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setPreferredSize(new Dimension(200, 30));
        
        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setPreferredSize(new Dimension(300, 40));
        
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        formPanel.add(namePanel);
        formPanel.add(Box.createVerticalStrut(20));
        
        // Phone Number
        JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        phonePanel.setBackground(Color.WHITE);
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 18));
        phoneLabel.setPreferredSize(new Dimension(200, 30));
        
        JTextField phoneField = new JTextField();
        phoneField.setFont(new Font("Arial", Font.PLAIN, 16));
        phoneField.setPreferredSize(new Dimension(300, 40));
        
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneField);
        formPanel.add(phonePanel);
        
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // -------------------- BUTTONS --------------------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(BG_COLOR);
        
        JButton nextBtn = createStyledButton("NEXT: SELECT SPOT →", AVAILABLE_COLOR, 16);
        JButton backBtn = createStyledButton("← BACK", OCCUPIED_COLOR, 16);
        
        nextBtn.addActionListener(e -> {
            String plate = plateField.getText().trim();
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String type = (String) typeCombo.getSelectedItem();
            
            // Validation
            if (plate.isEmpty() || name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(
                    panel,
                    "Please fill in all fields!",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
            // Check if vehicle already parked
            if (parkingSystem.findVehicle(plate) != null) {
                JOptionPane.showMessageDialog(
                    panel,
                    "A vehicle with this license plate is already parked!",
                    "Duplicate Vehicle",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
            // Create vehicle object
            switch (type) {
                case "Motorcycle":
                    tempVehicle = new Motorcycle(plate, name, phone);
                    break;
                case "Car":
                    tempVehicle = new Car(plate, name, phone);
                    break;
                case "Truck":
                    tempVehicle = new Truck(plate, name, phone);
                    break;
            }
            
            selectedSpot = -1;
            refreshSelectSpotPanel();
            cardLayout.show(mainPanel, "SELECT_SPOT");
        });
        
        backBtn.addActionListener(e -> {
            plateField.setText("");
            nameField.setText("");
            phoneField.setText("");
            cardLayout.show(mainPanel, "WELCOME");
        });
        
        buttonPanel.add(nextBtn);
        buttonPanel.add(backBtn);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    // ============================================================================
    // SELECT SPOT PANEL - Interactive parking spot selection
    // ============================================================================
    private JPanel spotPanel = null;
    private JLabel spotInfoLabel = null;
    
    private JPanel createSelectSpotPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(BG_COLOR);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // -------------------- HEADER --------------------
        panel.add(createHeader("SELECT PARKING SPOT"), BorderLayout.NORTH);
        
        // -------------------- CONTENT PANEL --------------------
        JPanel contentPanel = new JPanel(new BorderLayout(15, 15));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(NU_BLUE, 3),
            new EmptyBorder(20, 20, 20, 20)
        ));
        
        // Info panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(250, 250, 250));
        infoPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        spotInfoLabel = new JLabel("Select a parking spot");
        spotInfoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        spotInfoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(spotInfoLabel);
        infoPanel.add(Box.createVerticalStrut(20));
        
        // Legend
        JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
        legendPanel.setBackground(new Color(250, 250, 250));
        legendPanel.add(createLegendItem("Available", AVAILABLE_COLOR));
        legendPanel.add(createLegendItem("Occupied", OCCUPIED_COLOR));
        legendPanel.add(createLegendItem("Selected", SELECTED_COLOR));
        legendPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(legendPanel);
        
        contentPanel.add(infoPanel, BorderLayout.NORTH);
        
        // Spot grid panel
        spotPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (tempVehicle != null) {
                    drawParkingSpots(g);
                }
            }
        };
        spotPanel.setBackground(Color.WHITE);
        spotPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleSpotClick(e);
            }
        });
        
        contentPanel.add(spotPanel, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // -------------------- BUTTONS --------------------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(BG_COLOR);
        
        JButton confirmBtn = createStyledButton("✓ CONFIRM PARKING", AVAILABLE_COLOR, 16);
        JButton backBtn = createStyledButton("← BACK", OCCUPIED_COLOR, 16);
        
        confirmBtn.addActionListener(e -> {
            if (selectedSpot == -1) {
                JOptionPane.showMessageDialog(
                    panel,
                    "Please select a parking spot!",
                    "No Spot Selected",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
            if (parkingSystem.parkVehicle(tempVehicle, selectedSpot)) {
                JOptionPane.showMessageDialog(
                    panel,
                    String.format(
                        "Vehicle Parked Successfully!\n\n" +
                        "Type: %s\n" +
                        "Plate: %s\n" +
                        "Driver: %s\n" +
                        "Spot: %d\n" +
                        "Time: %s",
                        tempVehicle.getVehicleType(),
                        tempVehicle.getLicensePlate(),
                        tempVehicle.getDriverName(),
                        selectedSpot + 1,
                        tempVehicle.getFormattedParkingTime()
                    ),
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
                );
                tempVehicle = null;
                selectedSpot = -1;
                cardLayout.show(mainPanel, "WELCOME");
            } else {
                JOptionPane.showMessageDialog(
                    panel,
                    "Failed to park vehicle. Spot may be occupied.",
                    "Parking Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
        
        backBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "PARK");
        });
        
        buttonPanel.add(confirmBtn);
        buttonPanel.add(backBtn);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    // -------------------- DRAW PARKING SPOTS --------------------
    private void drawParkingSpots(Graphics g) {
        if (tempVehicle == null) return;
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        ParkingLot lot = parkingSystem.getParkingLotForVehicle(tempVehicle);
        if (lot == null) return;
        
        int capacity = lot.getCapacity();
        int cols = (capacity <= 5) ? capacity : 5;
        int spotSize = 80;
        int spacing = 100;
        int startX = 50;
        int startY = 50;
        
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        
        for (int i = 0; i < capacity; i++) {
            int row = i / cols;
            int col = i % cols;
            int x = startX + col * spacing;
            int y = startY + row * spacing;
            
            // Determine color
            Color color;
            if (i == selectedSpot) {
                color = SELECTED_COLOR;
            } else if (lot.isSpotOccupied(i)) {
                color = OCCUPIED_COLOR;
            } else {
                color = AVAILABLE_COLOR;
            }
            
            // Draw spot
            g2d.setColor(color);
            g2d.fillRoundRect(x, y, spotSize, spotSize, 15, 15);
            
            // Draw border
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawRoundRect(x, y, spotSize, spotSize, 15, 15);
            
            // Draw number
            g2d.setColor(Color.WHITE);
            String num = String.valueOf(i + 1);
            FontMetrics fm = g2d.getFontMetrics();
            int textX = x + (spotSize - fm.stringWidth(num)) / 2;
            int textY = y + ((spotSize - fm.getHeight()) / 2) + fm.getAscent();
            g2d.drawString(num, textX, textY);
        }
    }
    
    // -------------------- HANDLE SPOT CLICK --------------------
    private void handleSpotClick(MouseEvent e) {
        if (tempVehicle == null) return;
        
        ParkingLot lot = parkingSystem.getParkingLotForVehicle(tempVehicle);
        if (lot == null) return;
        
        int capacity = lot.getCapacity();
        int cols = (capacity <= 5) ? capacity : 5;
        int spotSize = 80;
        int spacing = 100;
        int startX = 50;
        int startY = 50;
        
        for (int i = 0; i < capacity; i++) {
            int row = i / cols;
            int col = i % cols;
            int x = startX + col * spacing;
            int y = startY + row * spacing;
            
            Rectangle spotRect = new Rectangle(x, y, spotSize, spotSize);
            if (spotRect.contains(e.getPoint())) {
                if (!lot.isSpotOccupied(i)) {
                    selectedSpot = i;
                    spotInfoLabel.setText(String.format(
                        "Selected: Spot %d | Vehicle: %s | Available spots: %d/%d",
                        i + 1,
                        tempVehicle.getVehicleType(),
                        lot.getAvailableCount(),
                        lot.getCapacity()
                    ));
                    spotPanel.repaint();
                } else {
                    JOptionPane.showMessageDialog(
                        this,
                        "This spot is already occupied!",
                        "Occupied Spot",
                        JOptionPane.WARNING_MESSAGE
                    );
                }
                break;
            }
        }
    }
    
    // -------------------- REFRESH SELECT SPOT PANEL --------------------
    private void refreshSelectSpotPanel() {
        if (tempVehicle != null && spotInfoLabel != null) {
            ParkingLot lot = parkingSystem.getParkingLotForVehicle(tempVehicle);
            if (lot != null) {
                spotInfoLabel.setText(String.format(
                    "Vehicle: %s | Available spots: %d/%d | Click a green spot to select",
                    tempVehicle.getVehicleType(),
                    lot.getAvailableCount(),
                    lot.getCapacity()
                ));
            }
        }
        if (spotPanel != null) {
            spotPanel.repaint();
        }
    }
    
    // ============================================================================
    // REMOVE VEHICLE PANEL - Remove parked vehicle
    // ============================================================================
    private JPanel createRemoveVehiclePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(BG_COLOR);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // -------------------- HEADER --------------------
        panel.add(createHeader("REMOVE PARKED VEHICLE"), BorderLayout.NORTH);
        
        // -------------------- FORM PANEL --------------------
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(NU_BLUE, 3),
            new EmptyBorder(40, 60, 40, 60)
        ));
        
        // License Plate Input
        JPanel platePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        platePanel.setBackground(Color.WHITE);
        JLabel plateLabel = new JLabel("License Plate:");
        plateLabel.setFont(new Font("Arial", Font.BOLD, 18));
        plateLabel.setPreferredSize(new Dimension(200, 30));
        
        JTextField plateField = new JTextField();
        plateField.setFont(new Font("Arial", Font.PLAIN, 16));
        plateField.setPreferredSize(new Dimension(300, 40));
        
        platePanel.add(plateLabel);
        platePanel.add(plateField);
        formPanel.add(platePanel);
        formPanel.add(Box.createVerticalStrut(20));
        
        // Search Button
        JButton searchBtn = createStyledButton("🔍 SEARCH VEHICLE", SELECTED_COLOR, 16);
        searchBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(searchBtn);
        formPanel.add(Box.createVerticalStrut(30));
        
        // Result Panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBackground(new Color(250, 250, 250));
        resultPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        resultPanel.setVisible(false);
        
        JLabel resultTitle = new JLabel("Vehicle Information");
        resultTitle.setFont(new Font("Arial", Font.BOLD, 16));
        resultTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        resultPanel.add(resultTitle);
        resultPanel.add(Box.createVerticalStrut(15));
        
        JTextArea resultArea = new JTextArea(8, 40);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(250, 250, 250));
        resultPanel.add(resultArea);
        
        formPanel.add(resultPanel);
        
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // -------------------- BUTTONS --------------------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(BG_COLOR);
        
        JButton removeBtn = createStyledButton("✓ REMOVE VEHICLE", OCCUPIED_COLOR, 16);
        JButton backBtn = createStyledButton("← BACK", new Color(100, 100, 100), 16);
        
        removeBtn.setEnabled(false);
        
        // Search functionality
        searchBtn.addActionListener(e -> {
            String plate = plateField.getText().trim();
            if (plate.isEmpty()) {
                JOptionPane.showMessageDialog(
                    panel,
                    "Please enter a license plate!",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }
            
            Vehicle vehicle = parkingSystem.findVehicle(plate);
            if (vehicle == null) {
                JOptionPane.showMessageDialog(
                    panel,
                    "Vehicle not found!",
                    "Not Found",
                    JOptionPane.INFORMATION_MESSAGE
                );
                resultPanel.setVisible(false);
                removeBtn.setEnabled(false);
            } else {
                ParkingLot lot = parkingSystem.getParkingLotForVehicle(vehicle);
                String info = String.format(
                    "Vehicle Type: %s %s\n" +
                    "License Plate: %s\n" +
                    "Driver Name: %s\n" +
                    "Phone Number: %s\n" +
                    "Parking Lot: %s\n" +
                    "Spot Number: %d\n" +
                    "Parked Since: %s\n" +
                    "Time Parked: %s",
                    vehicle.getVehicleIcon(),
                    vehicle.getVehicleType(),
                    vehicle.getLicensePlate(),
                    vehicle.getDriverName(),
                    vehicle.getPhoneNumber(),
                    lot.getLotName(),
                    vehicle.getSpotNumber() + 1,
                    vehicle.getFormattedParkingTime(),
                    vehicle.getTimeParked()
                );
                resultArea.setText(info);
                resultPanel.setVisible(true);
                removeBtn.setEnabled(true);
            }
        });
        
        // Remove functionality
        removeBtn.addActionListener(e -> {
            String plate = plateField.getText().trim();
            Vehicle removed = parkingSystem.removeVehicle(plate);
            
            if (removed != null) {
                JOptionPane.showMessageDialog(
                    panel,
                    String.format(
                        "Vehicle Removed Successfully!\n\n" +
                        "Type: %s\n" +
                        "Plate: %s\n" +
                        "Driver: %s\n" +
                        "Time Parked: %s",
                        removed.getVehicleType(),
                        removed.getLicensePlate(),
                        removed.getDriverName(),
                        removed.getTimeParked()
                    ),
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
                );
                plateField.setText("");
                resultPanel.setVisible(false);
                removeBtn.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(
                    panel,
                    "Failed to remove vehicle!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
        
        backBtn.addActionListener(e -> {
            plateField.setText("");
            resultPanel.setVisible(false);
            removeBtn.setEnabled(false);
            cardLayout.show(mainPanel, "WELCOME");
        });
        
        buttonPanel.add(removeBtn);
        buttonPanel.add(backBtn);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    // ============================================================================
    // VIEW STATUS PANEL - Display all parking lots status
    // ============================================================================
    private JPanel statusContentPanel = null;
    
    private JPanel createViewStatusPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(BG_COLOR);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // -------------------- HEADER --------------------
        panel.add(createHeader("PARKING SYSTEM STATUS"), BorderLayout.NORTH);
        
        // -------------------- CONTENT PANEL --------------------
        statusContentPanel = new JPanel();
        statusContentPanel.setLayout(new BoxLayout(statusContentPanel, BoxLayout.Y_AXIS));
        statusContentPanel.setBackground(BG_COLOR);
        statusContentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JScrollPane scrollPane = new JScrollPane(statusContentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // -------------------- BUTTONS --------------------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(BG_COLOR);
        
        JButton refreshBtn = createStyledButton("🔄 REFRESH", SELECTED_COLOR, 16);
        JButton backBtn = createStyledButton("← BACK", new Color(100, 100, 100), 16);
        
        refreshBtn.addActionListener(e -> refreshStatusPanel());
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "WELCOME"));
        
        buttonPanel.add(refreshBtn);
        buttonPanel.add(backBtn);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    // -------------------- REFRESH STATUS PANEL --------------------
    private void refreshStatusPanel() {
        if (statusContentPanel == null) return;
        
        statusContentPanel.removeAll();
        
        // Overall Statistics
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(1, 3, 20, 0));
        statsPanel.setBackground(Color.WHITE);
        statsPanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(NU_BLUE, 3),
            new EmptyBorder(20, 20, 20, 20)
        ));
        statsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
        
        statsPanel.add(createStatCard("Total Capacity", 
            String.valueOf(parkingSystem.getTotalCapacity()), NU_BLUE));
        statsPanel.add(createStatCard("Occupied Spots", 
            String.valueOf(parkingSystem.getTotalOccupiedSpots()), OCCUPIED_COLOR));
        statsPanel.add(createStatCard("Available Spots", 
            String.valueOf(parkingSystem.getTotalAvailableSpots()), AVAILABLE_COLOR));
        
        statusContentPanel.add(statsPanel);
        statusContentPanel.add(Box.createVerticalStrut(20));
        
        // Individual Parking Lots
        statusContentPanel.add(createParkingLotCard(parkingSystem.getParkingA(), "🏍️"));
        statusContentPanel.add(Box.createVerticalStrut(15));
        statusContentPanel.add(createParkingLotCard(parkingSystem.getParkingB(), "🚗"));
        statusContentPanel.add(Box.createVerticalStrut(15));
        statusContentPanel.add(createParkingLotCard(parkingSystem.getParkingC(), "🚛"));
        
        statusContentPanel.revalidate();
        statusContentPanel.repaint();
    }
    
    // -------------------- CREATE STAT CARD --------------------
    private JPanel createStatCard(String title, String value, Color color) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        titleLabel.setForeground(new Color(100, 100, 100));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 36));
        valueLabel.setForeground(color);
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        card.add(Box.createVerticalGlue());
        card.add(titleLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(valueLabel);
        card.add(Box.createVerticalGlue());
        
        return card;
    }
    
    // -------------------- CREATE PARKING LOT CARD --------------------
    private JPanel createParkingLotCard(ParkingLot lot, String icon) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(NU_BLUE, 2),
            new EmptyBorder(15, 15, 15, 15)
        ));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));
        
        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        headerPanel.setBackground(NU_BLUE);
        headerPanel.setBorder(new EmptyBorder(10, 15, 10, 15));
        
        JLabel headerLabel = new JLabel(String.format("%s %s - %s (%d/%d occupied)",
            icon, lot.getLotName(), lot.getVehicleType(),
            lot.getOccupiedCount(), lot.getCapacity()));
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        
        card.add(headerPanel, BorderLayout.NORTH);
        
        // Vehicle list
        JPanel vehiclePanel = new JPanel();
        vehiclePanel.setLayout(new BoxLayout(vehiclePanel, BoxLayout.Y_AXIS));
        vehiclePanel.setBackground(new Color(250, 250, 250));
        vehiclePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        List<Vehicle> vehicles = lot.getAllVehicles();
        if (vehicles.isEmpty()) {
            JLabel emptyLabel = new JLabel("No vehicles parked");
            emptyLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            emptyLabel.setForeground(new Color(150, 150, 150));
            vehiclePanel.add(emptyLabel);
        } else {
            for (Vehicle v : vehicles) {
                JLabel vLabel = new JLabel(String.format(
                    "  Spot %d: %s | %s | Parked: %s",
                    v.getSpotNumber() + 1,
                    v.getLicensePlate(),
                    v.getDriverName(),
                    v.getTimeParked()
                ));
                vLabel.setFont(new Font("Arial", Font.PLAIN, 13));
                vLabel.setBorder(new EmptyBorder(3, 5, 3, 5));
                vehiclePanel.add(vLabel);
            }
        }
        
        JScrollPane vehicleScroll = new JScrollPane(vehiclePanel);
        vehicleScroll.setPreferredSize(new Dimension(0, 150));
        vehicleScroll.setBorder(null);
        card.add(vehicleScroll, BorderLayout.CENTER);
        
        return card;
    }
    
    // ============================================================================
    // HELPER METHODS
    // ============================================================================
    
    // -------------------- CREATE MENU BUTTON --------------------
    private JButton createMenuButton(String text, String description, Color color) {
        JButton btn = new JButton();
        btn.setLayout(new BorderLayout(10, 10));
        btn.setBackground(color);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel titleLabel = new JLabel(text, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        
        JLabel descLabel = new JLabel(description, SwingConstants.CENTER);
        descLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        descLabel.setForeground(new Color(255, 255, 255, 200));
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.add(titleLabel);
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(descLabel);
        
        btn.add(textPanel, BorderLayout.CENTER);
        
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(color.brighter());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(color);
            }
        });
        
        return btn;
    }
    
    // -------------------- CREATE STYLED BUTTON --------------------
    private JButton createStyledButton(String text, Color color, int fontSize) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, fontSize));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(220, 50));
        
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(color.brighter());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(color);
            }
        });
        
        return btn;
    }
    
    // -------------------- CREATE HEADER --------------------
    private JPanel createHeader(String title) {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
        header.setBackground(NU_BLUE);
        header.setBorder(new LineBorder(NU_GOLD, 3));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(NU_GOLD);
        header.add(titleLabel);
        
        return header;
    }
    
    // -------------------- CREATE LEGEND ITEM --------------------
    private JPanel createLegendItem(String text, Color color) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panel.setOpaque(false);
        
        JPanel colorBox = new JPanel();
        colorBox.setPreferredSize(new Dimension(20, 20));
        colorBox.setBackground(color);
        colorBox.setBorder(new LineBorder(Color.BLACK, 1));
        
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 13));
        
        panel.add(colorBox);
        panel.add(label);
        
        return panel;
    }
    
    // ============================================================================
    // MAIN METHOD
    // ============================================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ParkingSystemGUI());
    }
}
