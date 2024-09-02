import java.util.*;

public class QueueTest {
    private static final int numOperations = 300_000;

    public static void main(String[] args) {
        List<Integer> qLinked = new LinkedList<>();
        List<Integer> qArray = new ArrayList<>();

        System.err.println("Number of operations: "+numOperations);
        System.out.println("Linked list performance: \n");
        benchmark(qLinked);
        System.out.println("Array list performance: \n");
        benchmark(qArray);
    }

    private static void benchmark(List<Integer> queue) {

        // Enqueue benchmark
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numOperations; i++) {
            queue.add(i);
        }
        long endTime = System.currentTimeMillis();
        long enqueueTime = endTime - startTime;

        // Dequeue benchmark
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numOperations; i++) {
            queue.remove(0);
        }
        endTime = System.currentTimeMillis();
        long dequeueTime = endTime - startTime;

        System.out.printf("\tEnqueue time: %d ms\n", enqueueTime);
        System.out.printf("\tDequeue time: %d ms\n", dequeueTime);
    }
}
