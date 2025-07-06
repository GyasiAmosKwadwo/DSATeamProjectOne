import java.util.ArrayList;
import java.util.Scanner;

public class binarySearch {
    public static void main(String[] args) {
        performBinarySearch();
    }

    public static void performBinarySearch() {
        Scanner scanner = new Scanner(System.in);
        performBinarySearch(scanner);
    }

    public static void performBinarySearch(Scanner scanner) {
        ArrayList<Object> list = InputUtils.getUserInputList(scanner);

        // Filter and keep numeric values in their original types
        ArrayList<Object> numericList = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Integer || obj instanceof Float) {
                numericList.add(obj);
            } else {
                // Try to parse string as number
                try {
                    // Try integer first to preserve type
                    numericList.add(Integer.parseInt(obj.toString()));
                } catch (NumberFormatException e1) {
                    try {
                        numericList.add(Float.parseFloat(obj.toString()));
                    } catch (NumberFormatException e2) {
                        System.out.println(
                                "Warning: '" + obj + "' is not a number and will be ignored for binary search.");
                    }
                }
            }
        }

        if (numericList.isEmpty()) {
            System.out.println("No numeric values found. Binary search requires numeric data.");
            return;
        }

        // Sort the numeric list using custom comparator
        numericList.sort((a, b) -> {
            double aVal = InputUtils.getNumericValue(a);
            double bVal = InputUtils.getNumericValue(b);
            return Double.compare(aVal, bVal);
        });

        System.out.print("Sorted array: ");
        InputUtils.displayNumericArray(numericList);

        Object target = InputUtils.getTargetValue(scanner);

        double targetValue;
        if (target instanceof Integer) {
            targetValue = ((Integer) target).doubleValue();
        } else if (target instanceof Float) {
            targetValue = ((Float) target).doubleValue();
        } else {
            try {
                targetValue = Double.parseDouble(target.toString());
            } catch (NumberFormatException e) {
                System.out.println("Target value must be numeric for binary search.");
                return;
            }
        }

        int result = binarySearchList(numericList, targetValue);
        if (result != -1) {
            System.out.println("Element '" + InputUtils.formatNumber(targetValue) + "' found at index " + result);
        } else {
            System.out.println("Element not found in your list");
        }
    }

    // Binary search on ArrayList of Objects
    public static int binarySearchList(ArrayList<Object> list, double target) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            double midValue = InputUtils.getNumericValue(list.get(mid));
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
