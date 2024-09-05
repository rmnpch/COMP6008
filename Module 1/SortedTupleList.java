import java.util.*;

class SortedTupleList {
    public static class Tuple {
        int x, y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equal(Tuple other) {
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
            insert(list, newTuple);
        }
        System.out.println("Sorted tuples:");
        for (Tuple t : list) {
            System.out.println("\t(" + t.x + ", " + t.y + ")");
        }
        scanner.close();
    }

    public static void insert(List<Tuple> list, Tuple newTuple) {
        int position = list.size(); // Start from the end of the list

        while (position > 0 && !newTuple.greaterThan(list.get(position - 1))) {
            position--;
        }
        list.add(position, newTuple);
    }
}