import java.util.*;

public class LexicographicOrder {
    class Tuple {
        int first, second; //data
        boolean equal (Tuple other) { //operation
              if (first == other.first && second == other.second)
                   return true;
              else
                   return false;
     }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> tupleList = new ArrayList<>();

        while (true) {
            System.out.print("Enter a tuple (a,b): ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == -1 && b == -1) {
                break;
            }

            int[] tuple = { a, b };

            for (int[] e : tupleList) {
                if (a < e[0]) {
                    for (int i = tupleList.size() - 1; i > tupleList.indexOf(e); i--) {
                        e[i + 1] = e[i];
                    }
                }
                if (b > e[1]) {
                    tupleList.indexOf(e);
                }
            }

            tupleList.add(tuple);

        }

        scanner.close();

    }
}
