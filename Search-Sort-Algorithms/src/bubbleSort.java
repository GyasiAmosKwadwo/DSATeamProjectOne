import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] myArray = {2, 5, 1, 7, 3, 6, 77, 32, 24};
        int[] results = bubbleSort(myArray);
        System.out.println(Arrays.toString(results));

    }


    public static int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Empty Array");
        }
        else {
//            for (int i = 0; i < array.length - 1; i++) {
//                if (array[i] > array[i + 1]) {
//                    int temp = array[i];
//                    array[i] = array[i + 1];
//                    array[i + 1] = temp;
//                }
//            }
            for (int i = 0; i < array.length ; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[j] > array[j+1]) {
                        int temp = array[j];
                        array[j] = array[j+ 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
        return array;
    }

}