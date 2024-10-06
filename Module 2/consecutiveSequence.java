import java.util.Arrays;

public class ConsecutiveSequence {
    static int longestSeq = 0;

    public static void main(String[] args) {
        int[] X = ArrayUtils.generateRandomArray(9, 8);
        System.out.println("Initial input: " + Arrays.toString(X));
        QuickSort(X, 0, X.length - 1);
        countSeq(X);
        System.out.println("Final result: " + Arrays.toString(X));
        System.out.println("Longest sequence: " + longestSeq);
    }

    static void QuickSort(int[] list, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(list, startIndex, endIndex);
            QuickSort(list, startIndex, pivotIndex - 1);
            QuickSort(list, pivotIndex + 1, endIndex);
        }
    }

    static int partition(int[] list, int startIndex, int endIndex) {
        int pivotVal = list[startIndex];
        int leftMark = startIndex + 1;
        int rightMark = endIndex;

        while (leftMark <= rightMark) {
            while (leftMark <= rightMark && list[leftMark] <= pivotVal)
                leftMark++;
            while (leftMark <= rightMark && list[rightMark] >= pivotVal)
                rightMark--;

            if (leftMark <= rightMark)
                swap(list, leftMark, rightMark);
        }
        swap(list, startIndex, rightMark);
        return rightMark;
    }

    static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    static void countSeq(int[] list) {
        int currentSeq = 1;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] + 1 == list[i + 1]) {
                currentSeq++;
            } else {
                currentSeq = 1;
            }
            longestSeq = currentSeq > longestSeq ? currentSeq : longestSeq;
        }
    }
}
