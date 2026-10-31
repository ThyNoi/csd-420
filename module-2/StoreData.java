/*  Eric Sengvanhpheng
    CSD420 Advanced Java Module 2 
    October 2026

    Program that creates empty arrays of ints and doubles,
    fills them with 5 random numbers and writes to 
    a file to be displayed.
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.io.DataOutputStream;

public class StoreData {

    Random rand = new Random();
    int[] intArray = new int[5];   // create empty array 5 integer slots
    double[] doubleArray = new double[5];   // 5 decimal

    // method for arrays, loops to fill arrays with random number values
    public void fillArrays() {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rand.nextInt(100);
        }
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = rand.nextDouble(); // 5 random decimals between 0.0 to 1.0
        }
    }

    // method for opening file, compiler makes you handle failure with exception
    public void writeData() throws IOException {
        // safely close outputs
        try (
            FileOutputStream fos = new FileOutputStream("ericdatafile.dat", true); // knows raw bytes, appends to file
            DataOutputStream output = new DataOutputStream(fos); // translator, give primitives
        ) {
            for (int i = 0; i < intArray.length; i ++ ) {
                output.writeInt(intArray[i]); // write the int that already in slot i
            }
            for (int i = 0; i < doubleArray.length; i ++ ) {
                output.writeDouble(doubleArray[i]); // write the double that already in slot i
            }
        } // auto closes with try block
    }
    public void printArrays() {
        System.out.println("ints:    " + Arrays.toString(intArray));
        System.out.println("doubles: " + Arrays.toString(doubleArray));
    }
    public static void main(String[] args) throws IOException {
        StoreData store = new StoreData();  // create the object
        store.fillArrays();                 // fill the arrays
        store.printArrays();                // print so you can see the values
        store.writeData();                   
    }
}
