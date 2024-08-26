import java.util.*;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> qLinked = new LinkedList<>();
        // Queue<Integer> qArray = new ArrayList<>();
        // System.out.println("isEmpty returns " + q.isEmpty());

        // q.add(4);
        // q.add(27);
        // System.out.println("Queue is now: " + q + "size is " + q.size());
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            qLinked.add(i);
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Queueing time:  " + executionTime + "ms");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            qLinked.remove();
        }
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Dequeueing time:    " + executionTime + "ms");
        // System.out.println("Dequeue - head was: " + head);
        // head = qLinked.remove();
        // System.out.println("Dequeue again - head was: " + head);

        // System.out.println("Queue is now: " + qLinked);
        // System.out.println("Size is now: " + qLinked.size());
    }
}
