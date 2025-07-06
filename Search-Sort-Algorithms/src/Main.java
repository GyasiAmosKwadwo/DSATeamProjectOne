import java.util.Scanner;

/**
 * Console version of DSA Team Project One - Search and Sort Algorithms
 * Simple menu-driven interface for testing algorithms
 */
public class Main {
    private static Scanner menuScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("DSA Algorithms - Console Version");
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
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (running) {
                System.out.println();
            }
        }
    }

    private static void displayMenu() {
        System.out.println("MENU:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.println("3. Interpolation Search");
        System.out.println("4. Bubble Sort");
        System.out.println("5. Algorithm Info");
        System.out.println("6. Exit");
        System.out.print("Choose (1-6): ");
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
        linearSearch.performLinearSearch(menuScanner);
    }

    /**
     * Runs the Binary Search algorithm
     */
    private static void runBinarySearch() {
        System.out.println("\n=== BINARY SEARCH ===");
        binarySearch.performBinarySearch(menuScanner);
    }

    /**
     * Runs the Interpolation Search algorithm
     */
    private static void runInterpolationSearch() {
        System.out.println("\n=== INTERPOLATION SEARCH ===");
        interporationSearch.performInterpolationSearch(menuScanner);
    }

    /**
     * Runs the Bubble Sort algorithm
     */
    private static void runBubbleSort() {
        System.out.println("\n=== BUBBLE SORT ===");
        bubbleSort.performBubbleSort(menuScanner);
    }

    /**
     * Displays basic algorithm information
     */
    private static void showAlgorithmInfo() {
        System.out.println("\n=== ALGORITHM INFO ===");
        System.out.println("Linear Search: O(n) - Checks each element sequentially");
        System.out.println("Binary Search: O(log n) - Divides sorted array in half");
        System.out.println("Interpolation Search: O(log log n) - Estimates position by value");
        System.out.println("Bubble Sort: O(n²) - Swaps adjacent elements");
        System.out.println();
        System.out.println("For detailed GUI interface, run: java DSAGui");
    }
}
