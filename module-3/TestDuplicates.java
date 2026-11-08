/**
 * CSD420 Advanced Java Module 3 Assignment.
 * This program generates a list of random integers, prints them, and uses a
 * generic static method to filter out all duplicate values while maintaining order.
 * 
 * @author Eric Sengvanhpheng
 * @version 1.0 (November 2026)
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

public class TestDuplicates {
    /**
     * Removes duplicate elements from the provided ArrayList while maintaining 
     * the original insertion order.
     * 
     * @param <E>  the type of elements stored inside the ArrayList
     * @param list the input ArrayList containing potential duplicate elements
     * @return     a new ArrayList containing only the unique elements
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // new empty list for clean up
        ArrayList<E> cleanList = new ArrayList<>();

        // Iterator cursor to walk through incoming list
        Iterator<E> cursor = list.iterator();

        // loop till end of items
        while (cursor.hasNext()) {
            E current = cursor.next(); // step forward and grab items

            // adds any needed items to list if not already inserted
            if (!cleanList.contains(current)) {
                cleanList.add(current);
            }
        }
        // hand the clean list back to who called it
        return cleanList;
    }
    /**
     * The main execution method that builds the test list of 50 random 
     * integers and prints the comparison formatting.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();
        // loop runs 50 times, 0-49
        for (int i = 0; i <50; i++){
            // new int variable takes range up to 20
            int randomInt = rand.nextInt(20) + 1;

            // add random numbers to originalList
            originalList.add(randomInt);
        }
        // print originalList in chunks of 10
        System.out.println("View originalList with duplicates (50 elements):");
        for (int i = 0; i < originalList.size(); i += 10) {
            // grabs a slice of the list from starting index
            // Math.min compares two numbers and returns whichever is smaller
            // grabs groups of 10 but if not 10 grabs the edge
            System.out.println(originalList.subList(i, Math.min(i + 10, originalList.size())));
        }

        System.out.println();
        // new list that passes originalList into removeDuplicates
        ArrayList<Integer> changedList = removeDuplicates(originalList);
        System.out.println("Clean list with no duplicates : " + changedList);
    }
}
