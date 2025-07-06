import java.util.Scanner;

/**
 * Main class for the DSA Team Project One - Search and Sort Algorithms
 * Provides a menu system to choose from various search and sort algorithms
 */
public class Main {
    private static Scanner menuScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== DSA Team Project One - Search and Sort Algorithms ===");
        System.out.println("Welcome to the Search and Sort Algorithms Demo!");
        System.out.println();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    runLinearSearch();
                    break;
                case 2:
                    runBinarySearch();
                    break;
                case 3:
                    runInterpolationSearch();
                    break;
                case 4:
                    runBubbleSort();
                    break;
                case 5:
                    showAlgorithmInfo();
                    break;
                case 6:
                    System.out.println("Thank you for using the DSA Algorithms Demo!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (running) {
                System.out.println("\n" + "=".repeat(50));
            }
        }

        // Note: We don't close the scanner to avoid System.in issues
        // The JVM will handle cleanup when the program terminates
    }

    /**
     * Displays the main menu options
     */
    private static void displayMenu() {
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.println("│                  MAIN MENU                     │");
        System.out.println("├─────────────────────────────────────────────────┤");
        System.out.println("│  1. Linear Search                              │");
        System.out.println("│  2. Binary Search                              │");
        System.out.println("│  3. Interpolation Search                       │");
        System.out.println("│  4. Bubble Sort                                │");
        System.out.println("│  5. Algorithm Information                      │");
        System.out.println("│  6. Exit                                       │");
        System.out.println("└─────────────────────────────────────────────────┘");
        System.out.print("Please select an option (1-6): ");
    }

    /**
     * Gets the user's menu choice with input validation
     */
    private static int getChoice() {
        try {
            String input = menuScanner.nextLine().trim();
            if (input.isEmpty()) {
                return -1; // Empty input
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        } catch (Exception e) {
            return -1; // Any other input issue
        }
    }

    /**
     * Runs the Linear Search algorithm
     */
    private static void runLinearSearch() {
        System.out.println("\n=== LINEAR SEARCH ===");
        System.out.println("Linear Search checks each element sequentially until the target is found.");
        System.out.println("Time Complexity: O(n) | Space Complexity: O(1)");
        System.out.println();

        linearSearch.performLinearSearch(menuScanner);
    }

    /**
     * Runs the Binary Search algorithm
     */
    private static void runBinarySearch() {
        System.out.println("\n=== BINARY SEARCH ===");
        System.out.println(
                "Binary Search efficiently finds elements in sorted arrays by repeatedly dividing the search space.");
        System.out.println("Time Complexity: O(log n) | Space Complexity: O(1)");
        System.out.println("Note: Only numeric values will be processed and the array will be sorted automatically.");
        System.out.println();

        binarySearch.performBinarySearch(menuScanner);
    }

    /**
     * Runs the Interpolation Search algorithm
     */
    private static void runInterpolationSearch() {
        System.out.println("\n=== INTERPOLATION SEARCH ===");
        System.out.println(
                "Interpolation Search is an improved variant of binary search for uniformly distributed data.");
        System.out.println("Time Complexity: O(log log n) average, O(n) worst case | Space Complexity: O(1)");
        System.out.println("Note: Only integer values are accepted and the array will be sorted automatically.");
        System.out.println();

        interporationSearch.performInterpolationSearch(menuScanner);
    }

    /**
     * Runs the Bubble Sort algorithm
     */
    private static void runBubbleSort() {
        System.out.println("\n=== BUBBLE SORT ===");
        System.out.println(
                "Bubble Sort repeatedly steps through the list, compares adjacent elements and swaps them if needed.");
        System.out.println("Time Complexity: O(n²) | Space Complexity: O(1)");
        System.out.println("Note: Handles mixed data types (numbers are sorted numerically, strings alphabetically).");
        System.out.println();

        bubbleSort.performBubbleSort(menuScanner);
    }

    /**
     * Displays detailed information about each algorithm
     */
    private static void showAlgorithmInfo() {
        System.out.println("\n=== ALGORITHM INFORMATION ===");
        System.out.println();

        System.out.println("┌─────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                SEARCH ALGORITHMS                            │");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ LINEAR SEARCH                                                               │");
        System.out.println("│ • Description: Sequentially checks each element until target is found      │");
        System.out.println("│ • Time Complexity: O(n)                                                    │");
        System.out.println("│ • Space Complexity: O(1)                                                   │");
        System.out.println("│ • Best for: Small datasets, unsorted data                                  │");
        System.out.println("│ • Data Types: Mixed (integers, floats, strings)                            │");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ BINARY SEARCH                                                              │");
        System.out.println("│ • Description: Divides sorted array in half repeatedly                     │");
        System.out.println("│ • Time Complexity: O(log n)                                                │");
        System.out.println("│ • Space Complexity: O(1)                                                   │");
        System.out.println("│ • Best for: Large sorted datasets                                          │");
        System.out.println("│ • Data Types: Numeric (integers, floats)                                   │");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ INTERPOLATION SEARCH                                                       │");
        System.out.println("│ • Description: Estimates position based on value distribution              │");
        System.out.println("│ • Time Complexity: O(log log n) average, O(n) worst case                  │");
        System.out.println("│ • Space Complexity: O(1)                                                   │");
        System.out.println("│ • Best for: Large uniformly distributed sorted datasets                    │");
        System.out.println("│ • Data Types: Integers only                                                │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────┘");
        System.out.println();

        System.out.println("┌─────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│                                SORTING ALGORITHMS                           │");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ BUBBLE SORT                                                                │");
        System.out.println("│ • Description: Repeatedly swaps adjacent elements if they are in wrong order│");
        System.out.println("│ • Time Complexity: O(n²)                                                   │");
        System.out.println("│ • Space Complexity: O(1)                                                   │");
        System.out.println("│ • Best for: Educational purposes, small datasets                           │");
        System.out.println("│ • Data Types: Mixed (numbers sorted numerically, strings alphabetically)   │");
        System.out.println("│ • Sorting Order: Numbers first, then strings                               │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────┘");
        System.out.println();

        System.out.println("=== USAGE TIPS ===");
        System.out.println("• Input Format: Enter values separated by spaces or commas");
        System.out.println("• Mixed Types: You can mix integers, floats, and strings");
        System.out.println("• Examples: '1 2 3 4 5' or '1.5, 2.7, hello, 42' or '10,20,30,world'");
        System.out.println("• Note: Some algorithms filter data types for optimal performance");
    }
}
