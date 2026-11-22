import java.util.Comparator;
import java.util.Arrays;

/**
 * Sorts generic arrays using bubble sort with both
 * Comparable (natural order) and Comparator (custom order).
 * 
 * @author Eric Sengvanhpheng
 * Course: CSD 420 Advanced Java Module 6
 * Date: November 2026
 */
public class BubbleSort {
    public static void main(String[] args) {
        // create test arrays and call bubbleSort
        Integer[] nums = {-1, 3, 7, 0, 7, 9};
        String[] states = {"California", "Colorado", "New York", "Florida", "Arizona", "Idaho"};

        // Test Integer array: natural order, then reverse order
        bubbleSort(nums);
        System.out.println("Integers (Ascending): " + Arrays.toString(nums));
        bubbleSort(nums, Comparator.reverseOrder());
        System.out.println("Integers (Descending): " + Arrays.toString(nums));

        System.out.println();

        // Test String array: alphabetical order, then reverse order
        bubbleSort(states);
        System.out.println("States (A-Z): " + Arrays.toString(states));
        bubbleSort(states, Comparator.reverseOrder());
        System.out.println("States (Z-A): " + Arrays.toString(states));
    }
    /**
    * Sorts an array in ascending natural order using bubble sort.
    *
    * @param <E>  the type of elements (must implement Comparable)
    * @param list the array to be sorted in place
    */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int k =1; k < list.length; k++) {
            // Each pass locks the largest remaining item at the end, so stop at length - k
            for (int i = 0; i < list.length - k; i++) {
                // Swap when the left element is greater than the right element
                if (list[i].compareTo(list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }
    /**
    * Sorts an array using bubble sort based on a custom Comparator.
    *
    * @param <E>        the type of elements in the array
    * @param list       the array to be sorted in place
    * @param comparator the comparator defining the sort order
    */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int k =1; k < list.length; k++) {
            // Skip elements already sorted at the end of the array
            for (int i = 0; i < list.length - k; i++) {
                // Swap when the comparator places the left element after the right
                if (comparator.compare(list[i], list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }
}
