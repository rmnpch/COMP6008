import java.util.*;
import java.lang.Math;

public class ArrayUtils {
    // Method to generate an array of random integers
    public static int[] generateRandomArray(int size, double order) {
        //order will reduce the order/magnitude of the integers generated. eg order 0 will generate integers to the 10^8 power, so to reduce integers to the range 1 - 20, the order should be set to 8 
        int[] randomNumbers = new int[size]; // Initialize an array with the specified size
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomNumbers[i] = (int) (random.nextInt()/Math.pow(10,order)); // Generate a random integer and assign it to the array
        }

        return randomNumbers; // Return the generated array
    }

}
