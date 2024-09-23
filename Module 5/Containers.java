import java.util.*;

public class Containers {
    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<>();

        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter number of weights: ");
        // int n = scanner.nextInt();

        // for (int i = 0; i < n; i++) {
        // int weight = 0;
        // while (weight <= 0 || weight > 10) {
        // System.out.print("Enter next weight: ");
        // weight = scanner.nextInt();
        // }
        // weights.add(weight);
        // }
        // scanner.close();

        int[] temp = { 1, 8, 7, 4, 2, 10, 3, 5, 5 };

        for (int e : temp)
            weights.add(e);

        Collections.sort(weights);
        System.err.println(weights);
        List<Integer> containerItems = new ArrayList<>();
        int containerNumber = 1;
        int containerWeight = 0;

        for (int e : weights) {
            if (containerWeight + e <= 10) {
                containerItems.add(e);
                containerWeight += e;
            } else {
                System.err
                        .println("Container " + containerNumber++ + " contains objects with weight " + containerItems);
                containerItems.clear();
                containerItems.add(e);
                containerWeight = e;
            }
        }
        System.err.println("Container " + containerNumber + " contains objects with weight " + containerItems);

    }

}
