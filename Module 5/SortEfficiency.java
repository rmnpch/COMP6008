import java.util.Random;

public class SortEfficiency {

    public static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt(3) - 1;

        return arr;
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(10);
        int zeroIndex=0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
                array[i]++;

        }
    }
}
