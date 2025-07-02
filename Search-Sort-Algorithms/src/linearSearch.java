public class linearSearch {
    public static void main(String[] args) {
        int[] myArray = {2,5,7,9,10,13,14};
        int target = 13;

        int results = linearSearch(myArray, target);
        System.out.println(results);
    }



    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
