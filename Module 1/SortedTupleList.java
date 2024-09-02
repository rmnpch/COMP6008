import java.util.*;

class SortedTupleList {

    public static class Tuple {
        int x, y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equal (Tuple other) { //operation
            if (this.x == other.x && this.y == other.y)
                return true;
            else
                 return false;
   } 
        public boolean greaterThan(Tuple other) {
            if (this.x > other.x)
                return true;
            if (this.x == other.x && this.y > other.y)
                return true;
            return false;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Tuple> list = new ArrayList<>();

        while (true) {
            System.out.print("Enter a tuple (a, b): ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (a == -1 && b == -1)
                break;

            Tuple newTuple = new Tuple(a, b);
            insertInOrder(list, newTuple);
        }

        System.out.println("Sorted tuples:");
        for (Tuple t : list) {
            System.out.println("\t(" + t.x + ", " + t.y + ")");
        }

        scanner.close();
    }

    public static void insertInOrder(List<Tuple> list, Tuple newTuple) {
        // int position = 0;

        for (int position = list.size(); position>0; position--){
            if (newTuple.greaterThan(list.get(position-1))){
                list.add(position, newTuple);
                break;
            }
        }

        // while (position < list.size() && !newTuple.greaterThan(list.get(position))) {
            //     position++;
            // }
            // list.add(position, newTuple);
    }
}