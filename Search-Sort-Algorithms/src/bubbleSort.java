import java.util.ArrayList;
import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        performBubbleSort();
    }

    public static void performBubbleSort() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        performBubbleSort(scanner);
    }

    public static void performBubbleSort(java.util.Scanner scanner) {
        ArrayList<Object> list = InputUtils.getUserInputList(scanner);
        Object[] array = list.toArray();

        Object[] sortedArray = bubbleSortArray(array);
        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(sortedArray));
    }

    public static Object[] bubbleSortArray(Object[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Empty Array");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (InputUtils.compareObjects(array[j], array[j + 1]) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}