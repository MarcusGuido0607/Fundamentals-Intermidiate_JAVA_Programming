import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.*;


// Hi sir Leo this is my program please run this code through "Run Without Debugging" or new "terminal" 
// then type "javac filehandling.java" to run the program.
// then type "java filehandling" to execute the program. Thank you!

// Thank you sir best regards: Marcus G. Guido BSCS 252

public class filehandling {
    static Scanner input = new Scanner(System.in);
    static Set<String> trackedFiles = new HashSet<>();
    static final String TRACKING_FILE = "file_registry.txt";
    
// ANSI Color Codes Para sa text --------------------------------------------------------------------------------------------------------------------------------------------
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String BOLD = "\u001B[1m";
    private static final String WHITE_BG = "\u001B[47m";
    private static final String BLACK = "\u001B[30m";

    public static void main(String[] args) {
        loadTrackedFiles();
        clearScreen();
        printHeader();

        while (true) {
            printMenu();
            System.out.print(CYAN + "Your choice: " + RESET);

            String choice = input.nextLine().trim().toUpperCase();

            System.out.println();
            
            if (choice.equals("A")) createFile();
            else if (choice.equals("B")) readFile();
            else if (choice.equals("C")) updateFile();
            else if (choice.equals("D")) writeFile();
            else if (choice.equals("E")) deleteFile();
            else if (choice.equals("F")) viewDirectory();
            else if (choice.equals("G")) {
                printGoodbye();
                break;
            } else {
                printError("Invalid choice. Please try again.");
            }

            pauseScreen();
        }
    }

// Design Elements -----------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void printHeader() {
        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + BOLD + YELLOW + "              FILE HANDLING Marcus SYSTEM                   " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
    }

    private static void printMenu() {
        System.out.println(BLUE + "┌────────────────────────────────────────────────────────────┐" + RESET);
        System.out.println(BLUE + "│" + BOLD + "  MAIN MENU                                                 " + RESET + BLUE + "│" + RESET);
        System.out.println(BLUE + "├────────────────────────────────────────────────────────────┤" + RESET);
        System.out.println(BLUE + "│" + RESET + GREEN + "  [A]" + RESET + " Create File                                           " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + RESET + GREEN + "  [B]" + RESET + " Read File                                             " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + RESET + GREEN + "  [C]" + RESET + " Update File                                           " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + RESET + GREEN + "  [D]" + RESET + " Write to File (Append/Overwrite)                      " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + RESET + GREEN + "  [E]" + RESET + " Delete File                                           " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + RESET + CYAN + "  [F]" + RESET + " View File Directory                                   " + BLUE + "│" + RESET);
        System.out.println(BLUE + "│" + RESET + RED + "  [G]" + RESET + " Exit                                                  " + BLUE + "│" + RESET);
        System.out.println(BLUE + "└────────────────────────────────────────────────────────────┘" + RESET);
        System.out.println();
    }

    private static void printSectionHeader(String title) {
        System.out.println(MAGENTA + "╔════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(MAGENTA + "║  " + BOLD + title + RESET + String.format("%" + (56 - title.length()) + "s", "") + MAGENTA +  RESET);
        System.out.println(MAGENTA + "╚════════════════════════════════════════════════════════════╝" + RESET);
    }

    private static void printSuccess(String message) {
        System.out.println(GREEN + "✓ " + message + RESET);
    }

    private static void printError(String message) {
        System.out.println(RED + "✗ " + message + RESET);
    }

    private static void printInfo(String message) {
        System.out.println(YELLOW + "ℹ " + message + RESET);
    }

    private static void printGoodbye() {
        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + BOLD + GREEN + "        Thank you for using Marcus File Handling!           " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + "                         Goodbye!                           " + "║" + RESET);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════╝" + RESET);
    }

    private static void pauseScreen() {
        System.out.println();
        System.out.print(YELLOW + "Press ENTER to continue..." + RESET);
        input.nextLine();
        clearScreen();
        printHeader();
    }

// File Tracking Methods -----------------------------------------------------------------------------------------------------------------------------------------------------
    private static void loadTrackedFiles() {
        try {
            Path trackingPath = Paths.get(TRACKING_FILE);
            if (Files.exists(trackingPath)) {
                List<String> lines = Files.readAllLines(trackingPath, StandardCharsets.UTF_8);
                trackedFiles.addAll(lines);
                // Remove files that no longer exist
                trackedFiles.removeIf(path -> !Files.exists(Paths.get(path)));
                saveTrackedFiles();
            }
        } catch (IOException e) {
            // If tracking file doesn't exist or can't be read, start fresh
        }
    }

    private static void saveTrackedFiles() {
        try {
            Files.write(Paths.get(TRACKING_FILE), trackedFiles, StandardCharsets.UTF_8);
        } catch (IOException e) {
            
        }
    }

    private static void addTrackedFile(String filePath) {
        trackedFiles.add(filePath);
        saveTrackedFiles();
    }

    private static void removeTrackedFile(String filePath) {
        trackedFiles.remove(filePath);
        saveTrackedFiles();
    }

// INPUT Ask for the file path --------------------------------------------------------------------------------------------------------------------------------------------------
    private static Path askPath() {
        System.out.print(CYAN + "Enter file path: " + RESET);
        return Paths.get(input.nextLine());
    }

// A. Create a File -----------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void createFile() {
        printSectionHeader("CREATE FILE");
        Path path = askPath();

        try {
            if (Files.exists(path)) {
                printInfo("File already exists.");
                addTrackedFile(path.toString());
            } else {
                // Create parent directories if they don't exist
                if (path.getParent() != null) {
                    Files.createDirectories(path.getParent());
                }
                Files.createFile(path);
                addTrackedFile(path.toString());
                printSuccess("File created successfully at: " + path.toAbsolutePath());
            }
        } catch (IOException e) {
            printError("Error creating file: " + e.getMessage());
        }
    }

// B. Read File ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void readFile() {
        printSectionHeader("READ FILE");
        Path path = askPath();

        try {
            if (!Files.exists(path)) {
                printError("File does not exist.");
                return;
            }

            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            System.out.println();
            System.out.println(GREEN + "┌──────────────────── FILE CONTENT ─────────────────────┐" + RESET);
            System.out.println(CYAN + "│ File: " + RESET + path.toAbsolutePath());
            System.out.println(GREEN + "├───────────────────────────────────────────────────────┤" + RESET);
            
            if (lines.isEmpty()) {
                System.out.println(YELLOW + "│  (file is empty)                                      │" + RESET);
            } else {
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i);
                    String lineNum = String.format("%3d", i + 1);
                    System.out.println(CYAN + "│ " + lineNum + " │ " + RESET + line);
                }
            }
            
            System.out.println(GREEN + "└───────────────────────────────────────────────────────┘" + RESET);

        } catch (IOException e) {
            printError("Error reading file: " + e.getMessage());
        }
    }

// C. Update File ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void updateFile() {
        printSectionHeader("UPDATE FILE");
        Path path = askPath();

        if (!Files.exists(path)) {
            printError("File does not exist.");
            return;
        }

        System.out.println();
        System.out.println(BLUE + "Update Options:" + RESET);
        System.out.println("  1. Search and replace text");
        System.out.println("  2. Overwrite entire file");
        System.out.print(CYAN + "Choose: " + RESET);
        String choice = input.nextLine();

        try {
            if (choice.equals("1")) {
                List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

                System.out.print(CYAN + "Text to find: " + RESET);
                String find = input.nextLine();

                System.out.print(CYAN + "Replace with: " + RESET);
                String replace = input.nextLine();

                List<String> newLines = new ArrayList<>();
                for (String line : lines) {
                    newLines.add(line.replace(find, replace));
                }

                Files.write(path, newLines, StandardCharsets.UTF_8);
                printSuccess("Updated successfully!");

            } else if (choice.equals("2")) {
                printInfo("Enter new content. Type '/end' to finish.");
                List<String> newLines = readMultiLineInput();

                Files.write(path, newLines, StandardCharsets.UTF_8);
                printSuccess("File overwritten!");

            } else {
                printError("Invalid option.");
            }

        } catch (IOException e) {
            printError("Error updating file: " + e.getMessage());
        }
    }

// D. Write to File ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void writeFile() {
        printSectionHeader("WRITE TO FILE");
        Path path = askPath();

        if (!Files.exists(path)) {
            printError("File does not exist. Create it first.");
            return;
        }

        System.out.println();
        System.out.println(BLUE + "Write Options:" + RESET);
        System.out.println("  1. Append (add to end)");
        System.out.println("  2. Overwrite (replace all)");
        System.out.print(CYAN + "Choose: " + RESET);
        String choice = input.nextLine();

        try {
            printInfo("Type your content. Type '/end' to stop.");
            List<String> lines = readMultiLineInput();

            if (choice.equals("1")) {
                Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                printSuccess("Content appended!");

            } else if (choice.equals("2")) {
                Files.write(path, lines, StandardCharsets.UTF_8);
                printSuccess("File overwritten!");

            } else {
                printError("Invalid option.");
            }

        } catch (IOException e) {
            printError("Error writing to file: " + e.getMessage());
        }
    }

// E. Delete File ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void deleteFile() {
        printSectionHeader("DELETE FILE");
        Path path = askPath();

        try {
            if (!Files.exists(path)) {
                printError("File does not exist.");
                return;
            }

            System.out.print(RED + "Are you sure? (yes/no): " + RESET);
            String confirm = input.nextLine().toLowerCase();

            if (confirm.equals("yes") || confirm.equals("y")) {
                Files.delete(path);
                removeTrackedFile(path.toString());
                printSuccess("File deleted.");
            } else {
                printInfo("Cancelled.");
            }

        } catch (IOException e) {
            printError("Error deleting file: " + e.getMessage());
        }
    }

// F. View Directory ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static void viewDirectory() {
        printSectionHeader("FILE DIRECTORY");
        
        if (trackedFiles.isEmpty()) {
            System.out.println();
            System.out.println(YELLOW + "  📭 No files tracked yet. Create some files!" + RESET);
            System.out.println();
            return;
        }

        System.out.println();
        System.out.println(GREEN + "╔═══════════════════════════════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(GREEN + "║" + BOLD + "  Tracked Files (" + trackedFiles.size() + ")                                                                        " + RESET + GREEN + "║" + RESET);
        System.out.println(GREEN + "╠═══════════════════════════════════════════════════════════════════════════════════════════╣" + RESET);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int fileNumber = 1;
        
        for (String filePath : trackedFiles) {
            Path path = Paths.get(filePath);
            
            try {
                if (Files.exists(path)) {
                    BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    long size = attrs.size();
                    String modified = dateFormat.format(new Date(attrs.lastModifiedTime().toMillis()));
                    String status = GREEN + "✓ EXISTS" + RESET;
                    
                    System.out.println(GREEN + "║ " + RESET + CYAN + String.format("%2d", fileNumber) + ". " + RESET + BOLD + "File: " + RESET + filePath);
                    System.out.println(GREEN + "║    " + RESET + "Path: " + path.toAbsolutePath());
                    System.out.println(GREEN + "║    " + RESET + "Size: " + formatFileSize(size) + "  │  Modified: " + modified + "  │  Status: " + status);
                    
                    if (fileNumber < trackedFiles.size()) {
                        System.out.println(GREEN + "╟───────────────────────────────────────────────────────────────────────────────────────────╢" + RESET);
                    }
                } else {
                    System.out.println(GREEN + "║ " + RESET + CYAN + String.format("%2d", fileNumber) + ". " + RESET + BOLD + "File: " + RESET + filePath);
                    System.out.println(GREEN + "║    " + RESET + "Status: " + RED + "✗ DELETED/MISSING" + RESET);
                    
                    if (fileNumber < trackedFiles.size()) {
                        System.out.println(GREEN + "╟───────────────────────────────────────────────────────────────────────────────────────────╢" + RESET);
                    }
                }
                
                fileNumber++;
                
            } catch (IOException e) {
                System.out.println(GREEN + "║ " + RESET + CYAN + String.format("%2d", fileNumber) + ". " + RESET + filePath);
                System.out.println(GREEN + "║    " + RESET + RED + "Error reading file information" + RESET);
                fileNumber++;
            }
        }
        
        System.out.println(GREEN + "╚═══════════════════════════════════════════════════════════════════════════════════════════╝" + RESET);
        
        
        long totalSize = 0;
        int existingFiles = 0;
        
        for (String filePath : trackedFiles) {
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                try {
                    totalSize += Files.size(path);
                    existingFiles++;
                } catch (IOException e) {
                    
                }
            }
        }
        
        System.out.println();
        System.out.println(CYAN + "  Summary:" + RESET);
        System.out.println("    Total Tracked: " + trackedFiles.size() + " files");
        System.out.println("    Existing: " + existingFiles + " files");
        System.out.println("    Total Size: " + formatFileSize(totalSize));
        System.out.println();
        
        
        System.out.println(YELLOW + "  Options:" + RESET);
        System.out.println("    1. Refresh directory");
        System.out.println("    2. Clear missing files from registry");
        System.out.println("    3. Back to main menu");
        System.out.print(CYAN + "  Choose: " + RESET);
        
        String choice = input.nextLine();
        
        if (choice.equals("1")) {
            viewDirectory();
        } else if (choice.equals("2")) {
            trackedFiles.removeIf(path -> !Files.exists(Paths.get(path)));
            saveTrackedFiles();
            printSuccess("Registry cleaned!");
        }
    }

    private static String formatFileSize(long size) {
        if (size < 1024) return size + " B";
        else if (size < 1024 * 1024) return String.format("%.2f KB", size / 1024.0);
        else return String.format("%.2f MB", size / (1024.0 * 1024.0));
    }
// Read multiple lines until /end ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private static List<String> readMultiLineInput() {
        List<String> lines = new ArrayList<>();

        while (true) {
            System.out.print(CYAN + "→ " + RESET);
            String line = input.nextLine();
            if (line.equals("/end")) break;
            lines.add(line);
        }

        return lines;
    }
}