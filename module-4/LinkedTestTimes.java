/**
 * @author Eric Sengvanhpheng
 * Date: November 2026
 * Course: CSD 420
 * Assignment: Module 4
 * Description: Benchmarking LinkedList traversal using an Iterator vs. get(index)
 */

import java.util.LinkedList;

public class LinkedTestTimes {

    /**
     * Populates and tests LinkedList traversal performance for a given size.
     * 
     * @param size number of integers to store in the LinkedList.
     */

    public static void runTest(int size) {
        System.out.println("Test Size: " + size);
        LinkedList<Integer> testList = new LinkedList<>();
        // fill the list up to size
        for (int i = 0; i < size; i ++) {
            testList.add(i);
        }
        // check to see list is populated correctly
        if (size > 0 && testList.size() == size 
            && testList.getFirst() == 0
            && testList.getLast() == size - 1 ) {
            System.out.println("---- List check passed! -----");
        } else {
            System.out.println("---- List check Failed: " + testList.size() + " contents are inccorrect in the list. ----");
        }
        // iterator / foreach test
        long iteratorSum = 0;
        long startTime = System.nanoTime();

        for (Integer num : testList) {
            iteratorSum += num; // accumulates values during traversal
        }

        long endTime = System.nanoTime();
        double iteratorTimeMs = (endTime - startTime) / 1_000_000.0;
        System.out.printf("Iterator traversal time: %.3f ms%n", iteratorTimeMs);
        // Test for get(Index)
        long getSum = 0;
        int listSize = testList.size();

        long startGet = System.nanoTime();
        for (int i = 0; i < listSize; i++) {
            getSum += testList.get(i); // retrieves the element at the specified index
        }
        long endGet = System.nanoTime();
        double getTimeMs = (endGet - startGet) / 1_000_000.0;
        System.out.printf("Get index traversal time: %.3f ms%n", getTimeMs);

        // verify results
        if (iteratorSum == getSum) {
            System.out.println("Traversal results match. Sum: " + iteratorSum);
        } else {
            System.out.println("Warning: Traversal sums do not match." );
        }
        System.out.println();
    }
    public static void main(String[] args) {
        runTest(50_000);
        runTest(500_000);
    }

/**
 * ANALYSIS & DISCUSSION:
 *
 * 1. Iterator Traversal:
 *    - The Iterator was significantly faster than using get(index).
 *    - With 50,000 integers, traversal took 1.294 ms.
 *    - With 500,000 integers, traversal took 4.008 ms.
 *    - An Iterator keeps track of its current position and moves
 *      sequentially to the next element.
 *    - This makes Iterator traversal O(n), meaning the amount of
 *      work increases linearly as the list grows.
 *
 * 2. Get(index) Traversal:
 *    - With 50,000 integers, traversal took 530.043 ms.
 *    - With 500,000 integers, traversal took 58,401.974 ms
 *      (approximately 58.4 seconds).
 *    - A LinkedList does not provide direct access to elements
 *      by index. Each get(i) call must traverse the linked nodes
 *      to locate the requested element.
 *    - Repeatedly using get(index) results in O(n^2) time complexity.
 *    - Increasing the list size by 10 times increased the measured
 *      traversal time by approximately 110 times.
 *
 * 3. Runtime Variation:
 *    - Execution times can vary between runs due to CPU activity,
 *      JVM optimizations, and background processes.
 *    - System.nanoTime() provides more precise timing when measuring
 *      short operations.
 *    - The measured times demonstrate the general performance
 *      differences between the two traversal methods.
 *
 * 4. Correctness Testing:
 *    - Both list sizes passed the initial population checks.
 *    - The sums calculated using Iterator and get(index) matched
 *      for both tests.
 *    - This confirms that both traversal methods processed the
 *      expected elements correctly.
 *
 * 5. Conclusion:
 *    - Iterator traversal is much more efficient when working
 *      with a LinkedList.
 *    - Repeatedly accessing elements using get(index) becomes
 *      significantly slower as the list grows.
 *    - This demonstrates why choosing the appropriate traversal
 *      method is important when working with Java collections.
 */

}