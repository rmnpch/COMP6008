import java.util.Arrays;
import java.util.Random;

public class Benchmark {

    static void BubbleSort(int[] list, int len) {
        int topIndex = len - 1;
        while (topIndex > 1) {
            bubbleUp(list, topIndex);
            topIndex--;
        }
    }

    static void bubbleUp(int[] list, int top) {
        for (int j = 0; j < top; j++)
            if (list[j] > list[j + 1])
                swap(list, j, j + 1);
    }

    static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    static void SelectionSort(int[] list, int len) {
        for (int startIndex = 0; startIndex < len - 1; startIndex++) {
            int minIndex = findMin(list, startIndex, len);
            swap(list, minIndex, startIndex);
        }
    }

    static int findMin(int[] list, int startIndex, int len) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < len; i++)
            if (list[i] < list[minIndex])
                minIndex = i;
        return minIndex;
    }

    static void InsertionSort(int[] list, int len) {
        for (int i = 1; i < len; i++) {
            int insertIndex = i;
            insert(list, insertIndex);
        }
    }

    static void insert(int[] list, int insertIndex) {
        int insertKey = list[insertIndex];
        while (insertIndex > 0 && list[insertIndex - 1] > insertKey) {
            list[insertIndex] = list[insertIndex - 1];
            insertIndex -= 1;
        }
        list[insertIndex] = insertKey;
    }

    static void MergeSort(int[] list, int[] auxList, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2 + 1;
            MergeSort(list, auxList, startIndex, midIndex - 1);
            MergeSort(list, auxList, midIndex, endIndex);
            merge(list, auxList, startIndex, midIndex, endIndex);
        }
    }

    static void merge(int[] list, int[] auxList, int startIndex, int midIndex, int endIndex) {
        int leftIndex = startIndex;
        int leftEnd = midIndex - 1;
        int rightIndex = midIndex;
        int rightEnd = endIndex;
        int auxIndex = startIndex;

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (list[leftIndex] <= list[rightIndex]) {
                auxList[auxIndex] = list[leftIndex];
                leftIndex += 1;
            } else {
                auxList[auxIndex] = list[rightIndex];
                rightIndex += 1;
            }
            auxIndex += 1;
        }

        while (leftIndex <= leftEnd) {
            auxList[auxIndex] = list[leftIndex];
            leftIndex += 1;
            auxIndex += 1;
        }
        while (rightIndex <= rightEnd) {
            auxList[auxIndex] = list[rightIndex];
            rightIndex += 1;
            auxIndex += 1;
        }

        for (int i = startIndex; i <= endIndex; i++)
            list[i] = auxList[i];
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

    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] sizes = { 60000, 120000, 180000, 240000, 300000, 360000, 720000,
        1000000 };
        int runs = 1;

        long bubbleTime = 0, selectionTime = 0, insertionTime = 0, mergeTime = 0, quickTime = 0, hybridTime = 0;

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n", "Input Size", "Bubble Sort", "Selection Sort",
                "Insertion Sort", "Merge Sort", "Quick Sort", "Hybrid Sort");

        for (int size : sizes) {

            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt();
            }
            // int[] array = ArrayUtils.generateRandomArray(size, 7);
            for (int i = 0; i < runs; i++) {
                int[] testList = Arrays.copyOfRange(array, 0, array.length);

                long startTime = System.currentTimeMillis();
                BubbleSort(testList, testList.length);
                long endTime = System.currentTimeMillis();
                bubbleTime += endTime - startTime;

                testList = Arrays.copyOfRange(array, 0, array.length);
                startTime = System.currentTimeMillis();
                SelectionSort(testList, testList.length);
                endTime = System.currentTimeMillis();
                selectionTime += endTime - startTime;

                testList = Arrays.copyOfRange(array, 0, array.length);
                startTime = System.currentTimeMillis();
                InsertionSort(testList, testList.length);
                endTime = System.currentTimeMillis();
                insertionTime += endTime - startTime;

                testList = Arrays.copyOfRange(array, 0, array.length);
                startTime = System.currentTimeMillis();
                int[] auxList = Arrays.copyOfRange(array, 0, array.length);
                MergeSort(testList, auxList, 0, testList.length - 1);
                endTime = System.currentTimeMillis();
                mergeTime += endTime - startTime;

                testList = Arrays.copyOfRange(array, 0, array.length);
                startTime = System.currentTimeMillis();
                QuickSort(testList, 0, testList.length - 1);
                endTime = System.currentTimeMillis();
                quickTime += endTime - startTime;

                testList = Arrays.copyOfRange(array, 0, array.length);
                startTime = System.currentTimeMillis();
                HybridSort.HybridSort(testList, 0, testList.length - 1, 250);
                endTime = System.currentTimeMillis();
                hybridTime += endTime - startTime;
            }

            System.out.printf("%-15d%-15d%-15d%-15d%-15d%-15d%-15d%n",
                    size,
                    bubbleTime,
                    selectionTime,
                    insertionTime,
                    mergeTime,
                    quickTime,
                    hybridTime);
            bubbleTime = 0;
            selectionTime = 0;
            insertionTime = 0;
            mergeTime = 0;
            quickTime = 0;
            hybridTime = 0;

        }

    }
}
