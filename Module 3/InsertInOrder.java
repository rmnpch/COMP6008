import java.util.*;

public class InsertInOrder {
    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        int[] list = { 54, 26, 93, 17, 77, 31, 44, 55, 20 };
        // int[] list = { 54, 17, 93, 17, 17, 17, 17, 17, 20 };
        Arrays.sort(list);

        for (int e : list) {
            testList.add(e);
        }

        insert(testList, -100); // negative value
        insert(testList, 17);// repetitive value
        insert(testList, 30);// new value
        insert(testList, 93);// repetitive value at the end
        insert(testList, 129234780);// much bigger value
        System.out.println("New array: "+testList);
    }

    static void insert(ArrayList<Integer> testList, int target) {
        if (target < testList.get(0)) {
            testList.add(0, target);
            return;
        } else if (target > testList.get(testList.size() - 1)) {
            testList.add(testList.size(), target);
            return;
        }

        int result = binarySearch(testList, target, 0, testList.size() - 1);

        if (result > 0) {
            while (result > testList.size() && testList.get(result) == testList.get(result + 1)) {
                result++;
            }
            testList.add(result, target);
        }
    }

    static int binarySearch(ArrayList<Integer> testList, int target, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            testList.add(startIndex, target);
            return -1;
        } else {
            int midIndex = (startIndex + endIndex) / 2;
            if (testList.get(midIndex) == target)
                return midIndex;
            else if (testList.get(midIndex) > target)
                return binarySearch(testList, target, startIndex, midIndex - 1);
            else
                return binarySearch(testList, target, midIndex + 1, endIndex);
        }
    }
}
