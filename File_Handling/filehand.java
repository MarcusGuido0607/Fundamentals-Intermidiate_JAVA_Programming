import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class filehand {

    static Scanner input = new Scanner(System.in);

    // ANSI Colors
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String BOLD = "\u001B[1m";

    private static final int BOX_WIDTH = 60;

    public static void main(String[] args) {
        clearScreen();
        printHeader();

        while (true) {
            printMenu();
            System.out.print(CYAN + "Your choice: " + RESET);
            String choice = input.nextLine().trim().toUpperCase();

            System.out.println();

            switch (choice) {
                case "A" -> createFile();
                case "B" -> readFile();
                case "C" -> updateFile();
                case "D" -> writeFile();
                case "E" -> deleteFile();
                case "F" -> {
                    printGoodbye();
                    return;
                }
                default -> printError("Invalid choice. Please try again.");
            }

            pauseScreen();
        }
    }

    // UI Helpers -----------------------------------------------------------------------------------

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void printHeader() {
        printBox("FILE HANDLING MANAGEMENT SYSTEM", CYAN, YELLOW);
        System.out.println();
    }

    private static void printBox(String text, String borderColor, String textColor) {
        int padding = (BOX_WIDTH - text.length() - 2) / 2;

        System.out.println(borderColor + "╔" + "═".repeat(BOX_WIDTH - 2) + "╗" + RESET);
        System.out.println(borderColor + "║" + RESET
                + " ".repeat(padding)
                + textColor + BOLD + text + RESET
                + " ".repeat(BOX_WIDTH - padding - text.length() - 2)
                + borderColor + "║" + RESET);
        System.out.println(borderColor + "╚" + "═".repeat(BOX_WIDTH - 2) + "╝" + RESET);
    }

    private static void printSectionHeader(String title) {
        printBox(title, MAGENTA, CYAN);
    }

    private static void printMenu() {
        System.out.println(BLUE + "┌" + "─".repeat(BOX_WIDTH - 2) + "┐" + RESET);
        System.out.println(BLUE + "│" + RESET + BOLD + " MAIN MENU"
                + " ".repeat(BOX_WIDTH - 2 - 9) + BLUE + "" + RESET);
        System.out.println(BLUE + "├" + "─".repeat(BOX_WIDTH - 2) + "┤" + RESET);

        printMenuItem("A", "Create File");
        printMenuItem("B", "Read File");
        printMenuItem("C", "Update File");
        printMenuItem("D", "Write to File (Append/Overwrite)");
        printMenuItem("E", "Delete File");
        printMenuItem("F", "Exit");

        System.out.println(BLUE + "└" + "─".repeat(BOX_WIDTH - 2) + "┘" + RESET);
        System.out.println();
    }

    private static void printMenuItem(String key, String label) {
        String line = "  [" + key + "] " + label;
        System.out.println(BLUE + "│" + RESET + GREEN + line
                + " ".repeat(BOX_WIDTH - 2 - line.length()) + BLUE + "│" + RESET);
    }

    private static void printSuccess(String msg) { System.out.println(GREEN + "✓ " + msg + RESET); }
    private static void printError(String msg) { System.out.println(RED + "✗ " + msg + RESET); }
    private static void printInfo(String msg) { System.out.println(YELLOW + "ℹ " + msg + RESET); }

    private static void printGoodbye() {
        printBox("THANK YOU FOR USING MARCUS FILE HANDLING!", CYAN, GREEN);
    }

    private static void pauseScreen() {
        System.out.println();
        System.out.print(YELLOW + "Press ENTER to continue..." + RESET);
        input.nextLine();
        clearScreen();
        printHeader();
    }

    // File path input ----------------------------------------------------------

    private static Path askPath() {
        System.out.print(CYAN + "Enter file path: " + RESET);
        return Paths.get(input.nextLine());
    }

    // A. Create File ------------------------------------------------------------

    private static void createFile() {
        printSectionHeader("CREATE FILE");
        Path path = askPath();

        try {
            if (Files.exists(path)) {
                printInfo("File already exists.");
            } else {
                Files.createFile(path);
                printSuccess("File created successfully!");
            }
        } catch (IOException e) {
            printError("Error creating file: " + e.getMessage());
        }
    }

    // B. Read File --------------------------------------------------------------

    private static void readFile() {
        printSectionHeader("READ FILE");
        Path path = askPath();

        if (!Files.exists(path)) {
            printError("File does not exist.");
            return;
        }

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            System.out.println(GREEN + "┌" + "─".repeat(BOX_WIDTH - 2) + "┐" + RESET);

            if (lines.isEmpty()) {
                System.out.println(YELLOW + "│ (file is empty)"
                        + " ".repeat(BOX_WIDTH - 16) + "│" + RESET);
            } else {
                for (int i = 0; i < lines.size(); i++) {
                    String num = String.format("%3d", i + 1);
                    String text = lines.get(i);

                    System.out.println(CYAN + "│ " + num + " │ "
                            + RESET + text
                            + " ".repeat(Math.max(1, BOX_WIDTH - 8 - text.length()))
                            + CYAN + "│" + RESET);
                }
            }

            System.out.println(GREEN + "└" + "─".repeat(BOX_WIDTH - 2) + "┘" + RESET);

        } catch (IOException e) {
            printError("Error reading file: " + e.getMessage());
        }
    }

    // C. Update File ------------------------------------------------------------

    private static void updateFile() {
        printSectionHeader("UPDATE FILE");
        Path path = askPath();

        if (!Files.exists(path)) {
            printError("File does not exist.");
            return;
        }

        System.out.println(BLUE + "Update Options:" + RESET);
        System.out.println("  1. Search and replace text");
        System.out.println("  2. Overwrite entire file");
        System.out.print(CYAN + "Choose: " + RESET);

        String choice = input.nextLine();

        try {
            switch (choice) {
                case "1" -> {
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
                }

                case "2" -> {
                    printInfo("Enter new content. Type '/end' to finish.");
                    List<String> newLines = readMultiLineInput();
                    Files.write(path, newLines, StandardCharsets.UTF_8);
                    printSuccess("File overwritten!");
                }

                default -> printError("Invalid option.");
            }

        } catch (IOException e) {
            printError("Error: " + e.getMessage());
        }
    }

    // D. Write to File ----------------------------------------------------------

    private static void writeFile() {
        printSectionHeader("WRITE TO FILE");
        Path path = askPath();

        if (!Files.exists(path)) {
            printError("File does not exist. Create it first.");
            return;
        }

        System.out.println(BLUE + "Write Options:" + RESET);
        System.out.println("  1. Append to end");
        System.out.println("  2. Overwrite file");
        System.out.print(CYAN + "Choose: " + RESET);

        String choice = input.nextLine();

        try {
            printInfo("Type your content. Type '/end' to stop.");
            List<String> lines = readMultiLineInput();

            switch (choice) {
                case "1" -> {
                    Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                    printSuccess("Content appended!");
                }

                case "2" -> {
                    Files.write(path, lines, StandardCharsets.UTF_8);
                    printSuccess("File overwritten!");
                }

                default -> printError("Invalid option.");
            }

        } catch (IOException e) {
            printError("Error: " + e.getMessage());
        }
    }

    // E. Delete File ------------------------------------------------------------

    private static void deleteFile() {
        printSectionHeader("DELETE FILE");
        Path path = askPath();

        if (!Files.exists(path)) {
            printError("File does not exist.");
            return;
        }

        System.out.print(RED + "⚠ Are you sure (yes/no)?: " + RESET);
        String confirm = input.nextLine().toLowerCase();

        try {
            if (confirm.equals("yes") || confirm.equals("y")) {
                Files.delete(path);
                printSuccess("File deleted.");
            } else {
                printInfo("Cancelled.");
            }

        } catch (IOException e) {
            printError("Error: " + e.getMessage());
        }
    }

    // Read multi-line input ------------------------------------------------------

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
