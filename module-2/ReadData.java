/*  Eric Sengvanhpheng
    CSD420 Advanced Java Module 2 
    October 2026

    Program that creates empty arrays of ints and doubles,
    fills them with numbers from ericdatafile and then displays
    each batch.
    
*/

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadData {
    
    public static void main(String[] args) throws IOException{
        int batchNumber = 1;

        try (
            FileInputStream fis = new FileInputStream("ericdatafile.dat");
            DataInputStream input = new DataInputStream(fis);
        ) {
            // loop continuously to read all appended sets
            while (true) {
                // empty arrays to be filled
                int[] readInts = new int[5];
                double[] readDoubles = new double[5];

                // loop to read int and doubles
                for (int i = 0; i < readInts.length; i ++) {
                    readInts[i] = input.readInt();
                }
                for (int i = 0; i < readDoubles.length; i ++) {
                    readDoubles[i] = input.readDouble();
                }
                System.out.println("Batch read sucess");

                // display what was read in file for specific batch
                System.out.println("=== Batch " + batchNumber++ + " ===");
                System.out.println("Read ints: " + Arrays.toString(readInts));
                System.out.println("Read doubles: " + Arrays.toString(readDoubles));
                }
            } catch (EOFException e) {
                System.out.println("\nReached the end of the file successfully");
        }
    }
}