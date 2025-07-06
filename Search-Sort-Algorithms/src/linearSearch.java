import java.util.ArrayList;
import java.util.Scanner;

public class linearSearch {
    public static void main(String[] args) {
        performLinearSearch();
    }

    public static void performLinearSearch() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Object> list = InputUtils.getUserInputList(scanner);
        Object target = InputUtils.getTargetValue(scanner);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                System.out.println("Element '" + list.get(i) + "' found at index " + i);
                return;
            }
        }
        System.out.println("Element not found in your list");
    }

    public static void performLinearSearch(Scanner scanner) {
        ArrayList<Object> list = InputUtils.getUserInputList(scanner);
        Object target = InputUtils.getTargetValue(scanner);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                System.out.println("Element '" + list.get(i) + "' found at index " + i);
                return;
            }
        }
        System.out.println("Element not found in your list");
    }
}
