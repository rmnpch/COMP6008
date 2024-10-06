import java.util.Arrays;
import java.util.Random;

public class SortingBenchmark {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Hybrid Sort (combination of Merge Sort and Quick Sort with partition limit)
    public static void hybridSort(int[] arr, int low, int high, int partitionLimit) {
        if (high - low < partitionLimit) {
            insertionSort(Arrays.copyOfRange(arr, low, high + 1));
        } else {
            if (low < high) {
                int pi = partition(arr, low, high);
                hybridSort(arr, low, pi - 1, partitionLimit);
                hybridSort(arr, pi + 1, high, partitionLimit);
            }
        }
    }

    // Generate random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    // Run sorting algorithms and measure execution time
    public static void main(String[] args) {
        // int[] sizes = { 60000, 120000, 180000, 240000, 300000, 360000, 720000, 1000000 };
        int[] sizes = { 60000, 120000 };
        int runs = 1;
        int partitionLimit = 50; // Optimal partition limit for hybrid sort

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n", "Input Size", "Bubble Sort", "Selection Sort",
                "Insertion Sort", "Merge Sort", "Quick Sort", "Hybrid Sort");

        for (int size : sizes) {
            long bubbleTotal = 0, selectionTotal = 0, insertionTotal = 0;
            long mergeTotal = 0, quickTotal = 0, hybridTotal = 0;

            for (int i = 0; i < runs; i++) {
                int[] array = generateRandomArray(size);

                // Measure Bubble Sort
                int[] bubbleArray = array.clone();
                long start = System.nanoTime();
                bubbleSort(bubbleArray);
                bubbleTotal += System.nanoTime() - start;

                // Measure Selection Sort
                int[] selectionArray = array.clone();
                start = System.nanoTime();
                selectionSort(selectionArray);
                selectionTotal += System.nanoTime() - start;

                // Measure Insertion Sort
                int[] insertionArray = array.clone();
                start = System.nanoTime();
                insertionSort(insertionArray);
                insertionTotal += System.nanoTime() - start;

                // Measure Merge Sort
                int[] mergeArray = array.clone();
                start = System.nanoTime();
                mergeSort(mergeArray);
                mergeTotal += System.nanoTime() - start;

                // Measure Quick Sort
                int[] quickArray = array.clone();
                start = System.nanoTime();
                quickSort(quickArray, 0, quickArray.length - 1);
                quickTotal += System.nanoTime() - start;

                // Measure Hybrid Sort
                int[] hybridArray = array.clone();
                start = System.nanoTime();
                hybridSort(hybridArray, 0, hybridArray.length - 1, partitionLimit);
                hybridTotal += System.nanoTime() - start;
            }

            // Print results for this input size
            System.out.printf("%-15d%-15.3f%-15.3f%-15.3f%-15.3f%-15.3f%-15.3f%n",
                    size,
                    bubbleTotal / (runs * 1e6),
                    selectionTotal / (runs * 1e6),
                    insertionTotal / (runs * 1e6),
                    mergeTotal / (runs * 1e6),
                    quickTotal / (runs * 1e6),
                    hybridTotal / (runs * 1e6));
        }
    }
}
