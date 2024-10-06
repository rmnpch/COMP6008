import java.util.Arrays;

public class pivotPosition {

    public static void main(String[] args) {
        int[] testList = { 54, 26, 93, 17, 77, 31, 44, 55, 20 };
        System.out.println("Start point: " + Arrays.toString(testList));

        long startTime = System.currentTimeMillis();
        QuickSort(testList, 0, testList.length - 1);
        long endTime = System.currentTimeMillis();

        long delta = endTime - startTime;

        System.out.println("Quick sort execution time: " + delta);
        System.out.println("Final result: " + Arrays.toString(testList));
    }

    static void QuickSort(int[] list, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            swapPivot(list, startIndex, endIndex);
            int pivotIndex = partition(list, startIndex, endIndex);
            QuickSort(list, startIndex, pivotIndex - 1);
            QuickSort(list, pivotIndex + 1, endIndex);
        }
    }

    static void swapPivot(int[] list, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2 + 1;
        if (list[startIndex] <= list[midIndex] && list[midIndex] <= list[endIndex]) {
            swap(list, startIndex, midIndex);
        } else if (list[startIndex] <= list[endIndex] && list[midIndex] <= list[endIndex]) {
            swap(list, startIndex, endIndex);
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

}

