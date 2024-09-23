import java.util.*;

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
        List<Integer> array2 = new ArrayList<>();
        int zeroIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array2.add(0, array[i]);
                zeroIndex++;
            } else if (array[i]==0){
                array2.add(zeroIndex,array[i]);
            }
            else array2.add(array[i]);
        }
        System.err.println(array2);
    }
}
