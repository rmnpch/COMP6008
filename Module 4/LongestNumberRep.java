import java.util.*;

public class LongestNumberRep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter a list of integers (end the list with 0):");

        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                scanner.close();
                break;
            }
            list.add(num);
        }

        int index = 0;
        int maxIndex = 0;
        int rep = 1;
        int maxRep = 1;
        int value = list.get(0);
        int maxValue = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == value) {
                rep++; 
            } else {
                // if number repetition had ended, check and possibly update max variables
                if (rep > maxRep) {
                    maxRep = rep;
                    maxIndex = index;
                    maxValue = value;
                }
                // reset
                value = list.get(i);
                index = i;
                rep = 1;
            }
        }
        if (rep > maxRep) {
            maxRep = rep;
            maxIndex = index;
            maxValue = value;
        }

        System.out.println("The longest same number list starts at index " + maxIndex + " with " + maxRep + " values of " + maxValue + ".");

    }
}