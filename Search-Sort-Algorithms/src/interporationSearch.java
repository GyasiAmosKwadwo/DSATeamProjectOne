import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

// .......NOT FULLY IMPLEMENTED!!.....
public class interporationSearch {
    public static void main(String[] args) {
        performInterpolationSearch();
    }

    public static void performInterpolationSearch() {
        Scanner scanner = new Scanner(System.in);
        performInterpolationSearch(scanner);
    }

    public static void performInterpolationSearch(Scanner scanner) {
        ArrayList<Integer> list = InputUtils.getIntegerInputList(scanner);

        // Convert ArrayList to array and sort it (interpolation search requires sorted
        // array)
        int[] array = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(array);

        Integer targetValue = InputUtils.getIntegerTargetValue(scanner);
        if (targetValue == null) {
            return; // Invalid input, exit
        }
        int target = targetValue;

        int result = interpolationSearch(array, target);
        if (result != -1) {
            System.out.println("Element '" + target + "' found at index " + result);
        } else {
            System.out.println("Element not found in your list");
        }
    }

    public static int interpolationSearch(int[] array, int target) {
        if (array.length == 0)
            return -1;

        int left = 0;
        int right = array.length - 1;

        while (left <= right && target >= array[left] && target <= array[right]) {
            // If array has only one element
            if (left == right) {
                return array[left] == target ? left : -1;
            }

            // Calculate the interpolation position
            int pos = left + ((target - array[left]) * (right - left)) / (array[right] - array[left]);

            if (array[pos] == target) {
                return pos;
            } else if (array[pos] < target) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        return -1;
    }
}
