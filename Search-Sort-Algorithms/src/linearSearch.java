import java.util.ArrayList;
import java.util.Scanner;

/**
 * Linear Search implementation
 * Sequentially checks each element until the target is found
 * Time Complexity: O(n) | Space Complexity: O(1)
 */
public class linearSearch {
    public static void main(String[] args) {
        performLinearSearch();
    }

    public static void performLinearSearch() {
        Scanner scanner = new Scanner(System.in);
        performLinearSearchAlgorithm(scanner);
    }

    public static void performLinearSearch(Scanner scanner) {
        performLinearSearchAlgorithm(scanner);
    }

    /**
     * Core linear search algorithm with robust comparison
     */
    private static void performLinearSearchAlgorithm(Scanner scanner) {
        ArrayList<Object> list = InputUtils.getUserInputList(scanner);
        Object target = InputUtils.getTargetValue(scanner);

        for (int i = 0; i < list.size(); i++) {
            Object listElement = list.get(i);
            
            // Use robust comparison to handle type differences
            if (compareElements(listElement, target)) {
                System.out.println("Element '" + listElement + "' found at index " + i);
                return;
            }
        }
        System.out.println("Element not found in your list");
    }

    /**
     * Robust element comparison that handles type differences
     */
    private static boolean compareElements(Object element, Object target) {
        // Direct equality check
        if (element.equals(target)) {
            return true;
        }
        
        // String representation check
        if (element.toString().equals(target.toString())) {
            return true;
        }
        
        // Numeric comparison for numbers
        if (InputUtils.isNumeric(element) && InputUtils.isNumeric(target)) {
            double val1 = InputUtils.getNumericValue(element);
            double val2 = InputUtils.getNumericValue(target);
            return val1 == val2;
        }
        
        return false;
    }
}
