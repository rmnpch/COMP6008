import java.util.*;

public class ArrayIntersection {
    public static void findIntersection(int[] X, int[] Y) {
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> intersectionList = new ArrayList<>();
        Arrays.sort(X);
        Arrays.sort(Y);
        int Xpointer = 0;
        int Ypointer = 0;

        while (Xpointer < X.length && Ypointer < Y.length) {
            if (X[Xpointer] == Y[Ypointer] && !intersectionList.contains(X[Xpointer])) {
                intersectionList.add(X[Xpointer]);
                Xpointer++;
            } else if (X[Xpointer] < Y[Ypointer]) {
                Xpointer++;
            } else {
                Ypointer++;
            }
        }
        // System.out.print("Intersection of X and Y: ");
        // System.out.println(intersectionList);

        long endTime = System.currentTimeMillis();
        long deltaHS = endTime - startTime;
        System.out.println("Pointer approach execution time: " + deltaHS + " ms.");

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
