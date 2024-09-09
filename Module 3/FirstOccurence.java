public class FirstOccurence {
    public static void main(String[] args) {
        int[] testList = { 1, 2, 2, 2, 2, 2, 32, 47 };
        searchResult(testList, 13);
        searchResult(testList, 2);
    }

    static void searchResult(int[] list, int target) {
        int result = binarySearch(list, target, 0, list.length);

        if (result < 0)
            System.out.println("Index for " + target + " was not found");
        else {
            while (list[result] == list[result - 1] && result >= 0) {
                result--;
            }
            System.out.println("Search for first occurrence of " + target + " found at index of " + result);
        }
    }

    static int binarySearch(int[] list, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return -1;
        else {
            int midIndex = (startIndex + endIndex) / 2;
            if (list[midIndex] == target)
                return midIndex;
            else if (list[midIndex] > target)
                return binarySearch(list, target, startIndex, midIndex - 1);
            else
                return binarySearch(list, target, midIndex + 1, endIndex);
        }
    }
}
