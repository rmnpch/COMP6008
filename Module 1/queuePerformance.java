import java.util.*;

public class queuePerformance {
    private static List<Integer> elements; // Array list to store values split from the file
    
    public static void elementGenerator (){
        for (int i =0; i<100000; i++){
            System.err.println(i);
            elements.add(i);
        }
    }

    public static void main(String[] args) {
        elementGenerator();
        
    }
}