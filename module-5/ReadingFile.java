/**
 * @author Eric Sengvanhpheng
 * Date: November 2026
 * Class: CSD 420 Advanced Java Module 5
 * 
 * Reads a text file for words, gets rid of duplicates using a TreeSet,
 * and displays the words in ascending and descending order.
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.TreeSet;

public class ReadingFile {

    /**
     * Reads the file and prints words in sorted order.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // TreeSet automatically eliminates duplicates and sorts alphabetically.
        TreeSet<String> wordSet = new TreeSet<>();
        File file = new File("collection_of_words.txt");

        // Repeating the code inside until it reaches the very bottom of the text file.
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordSet.add(word);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
        }
        // Displays words in ascending order (A to Z)
        System.out.println("ASCENDING ORDER: ");
        for (String word : wordSet) {
            System.out.println(word);
        }
        System.out.println();
        // Displays words in descending order (Z to A)
        System.out.println("DESCENDING ORDER: ");
        for (String word : wordSet.descendingSet()) {
            System.out.println(word);
        }
    }
    public static TreeSet<String> getUniqueSortedWords(Scanner scanner) {
        TreeSet<String> wordSet = new TreeSet<>();
        while (scanner.hasNext()) {
            String cleanWord = scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!cleanWord.isEmpty()) {
                wordSet.add(cleanWord);
            }
        }
        return wordSet;
    }
}
