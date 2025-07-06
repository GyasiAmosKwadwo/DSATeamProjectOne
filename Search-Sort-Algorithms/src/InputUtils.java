import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utility class for handling user input operations across all search and sort
 * algorithms.
 * This class provides common methods for getting user input and parsing values.
 */
public class InputUtils {

    /**
     * Gets a list of mixed-type objects from user input.
     * Attempts to parse each token as Integer, then Float, then String.
     * 
     * @param scanner The Scanner instance to use for input
     * @return ArrayList of Objects containing the parsed input
     */
    public static ArrayList<Object> getUserInputList(Scanner scanner) {
        ArrayList<Object> list = new ArrayList<>();
        System.out.println("Enter values separated by commas or spaces:");
        String input = scanner.nextLine();
        String[] tokens = input.split("[,\\s]+");
        for (String token : tokens) {
            if (token.isEmpty())
                continue;
            try {
                list.add(Integer.parseInt(token));
            } catch (NumberFormatException e1) {
                try {
                    list.add(Float.parseFloat(token));
                } catch (NumberFormatException e2) {
                    list.add(token);
                }
            }
        }
        return list;
    }

    /**
     * Gets a list of integers from user input.
     * Only accepts integer values and prompts again if invalid input is provided.
     * 
     * @param scanner The Scanner instance to use for input
     * @return ArrayList of Integers containing the parsed input
     */
    public static ArrayList<Integer> getIntegerInputList(Scanner scanner) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter integer values separated by commas or spaces:");
        String input = scanner.nextLine();
        String[] tokens = input.split("[,\\s]+");
        for (String token : tokens) {
            if (token.isEmpty())
                continue;
            try {
                list.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + token + ". Please enter only integers.");
                return getIntegerInputList(scanner); // Ask for input again
            }
        }
        return list;
    }

    /**
     * Parses an object value, attempting to convert it to Integer, Float, or
     * String.
     * 
     * @param value The object to parse
     * @return The parsed object (Integer, Float, or String)
     */
    public static Object parseObjectValue(Object value) {
        if (value == null)
            return null;
        if (value instanceof Integer || value instanceof Float || value instanceof String) {
            return value;
        }
        String str = value.toString();
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e1) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e2) {
                return str;
            }
        }
    }

    /**
     * Gets a target value from user input and parses it appropriately.
     * 
     * @param scanner The Scanner instance to use for input
     * @return The parsed target value
     */
    public static Object getTargetValue(Scanner scanner) {
        System.out.print("Enter the target value: ");
        String targetInput = scanner.nextLine();
        return parseObjectValue(targetInput);
    }

    /**
     * Gets an integer target value from user input.
     * 
     * @param scanner The Scanner instance to use for input
     * @return The integer target value, or null if invalid input
     */
    public static Integer getIntegerTargetValue(Scanner scanner) {
        System.out.print("Enter the target value: ");
        String targetInput = scanner.nextLine();
        try {
            return Integer.parseInt(targetInput.trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return null;
        }
    }

    /**
     * Checks if an object represents a numeric value.
     * 
     * @param obj The object to check
     * @return true if the object is Integer, Float, or Double
     */
    public static boolean isNumeric(Object obj) {
        return obj instanceof Integer || obj instanceof Float || obj instanceof Double;
    }

    /**
     * Extracts the numeric value from an Integer, Float, or Double object.
     * 
     * @param obj The object to extract the value from
     * @return The numeric value as a double
     */
    public static double getNumericValue(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).doubleValue();
        } else if (obj instanceof Float) {
            return ((Float) obj).doubleValue();
        } else if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        return 0.0;
    }

    /**
     * Formats a number for display, showing integers without decimals.
     * 
     * @param value The numeric value to format
     * @return Formatted string representation
     */
    public static String formatNumber(double value) {
        if (value == (int) value) {
            return String.valueOf((int) value);
        } else {
            return String.valueOf((float) value);
        }
    }

    /**
     * Displays an array of numeric objects with proper formatting.
     * 
     * @param list The list of objects to display
     */
    public static void displayNumericArray(ArrayList<Object> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0)
                System.out.print(", ");
            Object obj = list.get(i);
            if (obj instanceof Integer) {
                System.out.print(obj);
            } else if (obj instanceof Float) {
                System.out.print(obj);
            }
        }
        System.out.println("]");
    }

    /**
     * Compares two objects for sorting purposes.
     * Numbers are compared numerically, strings lexicographically.
     * Mixed types: numbers come before strings.
     * 
     * @param obj1 First object to compare
     * @param obj2 Second object to compare
     * @return negative, zero, or positive integer for less than, equal to, or
     *         greater than
     */
    public static int compareObjects(Object obj1, Object obj2) {
        // Handle null values
        if (obj1 == null && obj2 == null)
            return 0;
        if (obj1 == null)
            return -1;
        if (obj2 == null)
            return 1;

        // If both are numbers, compare numerically
        if (isNumeric(obj1) && isNumeric(obj2)) {
            double num1 = getNumericValue(obj1);
            double num2 = getNumericValue(obj2);
            return Double.compare(num1, num2);
        }

        // If both are strings, compare lexicographically
        if (obj1 instanceof String && obj2 instanceof String) {
            return ((String) obj1).compareTo((String) obj2);
        }

        // Mixed types: numbers before strings
        if (isNumeric(obj1) && obj2 instanceof String) {
            return -1;
        }
        if (obj1 instanceof String && isNumeric(obj2)) {
            return 1;
        }

        // Default: convert to string and compare
        return obj1.toString().compareTo(obj2.toString());
    }
}
