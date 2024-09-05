import java.util.*;

public class ArrayIntersection {
    public static void findIntersection(int[] X, int[] Y) {
        long startTime = System.currentTimeMillis();
        HashSet<Integer> X_set = new HashSet<>();
        for (int num : X) {
            if (!X_set.contains(num)) // Remove repetitive items
                X_set.add(num);
        }
        // Find intersection elements
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num : Y) {
            if (X_set.contains(num) && !intersectionSet.contains(num))
                intersectionSet.add(num);

        }

        System.out.print("Intersection of X and Y: ");
        System.out.println(intersectionSet);
        long endTime = System.currentTimeMillis();
        long deltaHS = endTime - startTime;
        System.out.println("Hash set execution time: " + deltaHS + " ms.");

    }

    public static void bruteForce(int[] X, int[] Y) {
        long startTime = System.currentTimeMillis();

        ArrayList<Integer> intersectionList = new ArrayList<Integer>();
        for (int i : X) {
            for (int j : Y) {
                if (i == j && !intersectionList.contains(i)) {
                    intersectionList.add(i);
                }
            }
        }
        System.out.println(intersectionList.size());
        long endTime = System.currentTimeMillis();
        long deltaBF = endTime - startTime;
        System.out.println("Brute force execution time: " + deltaBF + " ms.");
    }

    public static void main(String[] args) {

        int[] X = new int[50000];
        int[] Y = new int[X.length];

        X = ArrayUtils.generateRandomArray(X.length, 7);
        Y = ArrayUtils.generateRandomArray(Y.length, 7);

        findIntersection(X, Y);
        bruteForce(X, Y);

    }
}
