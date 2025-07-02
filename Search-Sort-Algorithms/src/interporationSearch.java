import java.util.Arrays;

import static java.lang.Math.floor;


// .......NOT FULLY IMPLEMENTED!!.....
public class interporationSearch {
    public static void main(String[] args) {
        int[] myArray = {2,5,7,9,10,13,14};
        int target = 13;

        int results = interporationSearch(myArray, target);
        System.out.println(results);
    }
    public static int interporationSearch(int[] array, int target) {
        while (array.length > 0) {
            int left = 0;
            int right = array.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;

                if (array[mid] == target) {
                    return mid;
                }
                else if (array[mid] < target) {
                    left = mid + 1;

                }
            }
        }
        return -1;
    }
}
