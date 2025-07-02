public class binarySearch {
    public static void main(String[] args) {
        int[] myArray = {2,5,7,9,10,13,14};
        int target = 7;

        int results = binarySearch(myArray, target);
        System.out.println(results);
    }


    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
