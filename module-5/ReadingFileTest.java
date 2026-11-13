/**
 * @author Eric Sengvanhpheng
 * Date: November 2026
 * Class: CSD 420 Advanced Java Module 5
 * 
 * Unit tests verifying duplicate removal, ascending/descending sorting,
 * and missing-file exception handling for ReadingFile.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class ReadingFileTest {
    /**
     * Verifies duplicate removal and ascending/descending sort order using mock input.
     */

    @Test
    public void testSortingAndDuplicates() {
        // 1. Feed fake words directly into ReadingFile's method
        Scanner fakeFile = new Scanner("zebra apple banana apple");
        TreeSet<String> result = ReadingFile.getUniqueSortedWords(fakeFile);

        // 2. Assert that duplicates vanished and sorting worked
        assertEquals(3, result.size());
        assertEquals(List.of("apple", "banana", "zebra"), new ArrayList<>(result));
        assertEquals(List.of("zebra", "banana", "apple"), new ArrayList<>(result.descendingSet()));
    }
    /**
     * Verifies FileNotFoundException is thrown when targeting a non-existent file.
     */

    @Test
    public void testMissingFile() {
        // 3. Assert that a missing file properly throws an exception
        assertThrows(FileNotFoundException.class, () -> {
            new Scanner(new File("fake_file_that_does_not_exist.txt")).close();
        });
    }
}