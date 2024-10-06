import java.io.*;

public class HybridSort {

    static void HybridSort(int[] list, int startIndex, int endIndex, int threshold) {
        if (endIndex - startIndex < threshold) {
            InsertionSort(list, startIndex, endIndex);

        } else if (startIndex < endIndex) {
            int pivotIndex = partition(list, startIndex, endIndex);
            HybridSort(list, startIndex, pivotIndex - 1, threshold);
            HybridSort(list, pivotIndex + 1, endIndex, threshold);
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

    static void InsertionSort(int[] list, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
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

    public static void main(String[] args) {
        int[] sizes = { 60000, 120000, 180000, 240000, 300000, 360000, 720000, 1000000 };

        for (int e : sizes) {
            File file = new File(
                    "D:///OneDrive - Southern Cross University///SCU///Term 4///COMP6008 Data Structure and Algorithms///Module 6///test"
                            + e + ".csv");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("sep=,");
                writer.newLine();
                writer.write("threshold,avg_time");
                writer.newLine();

                int iterations = 10;

                for (int j = 0; j <= 500; j += 10) {
                    long startTime = System.currentTimeMillis();
                    for (int i = 0; i < iterations; i++) {
                        int[] testList = ArrayUtils.generateRandomArray(e, 6);
                        HybridSort(testList, 0, testList.length - 1, j);
                    }

                    long endTime = System.currentTimeMillis();

                    long delta = (endTime - startTime) / iterations;

                    writer.write(j + ", " + delta);
                    System.err.println("Average Quick Sort execution time: " + delta + " ms for " + j + " threshold.");
                    writer.newLine();
                }
                System.out.println("CSV file written successfully to " + file);
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }

}
