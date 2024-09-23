import java.util.Scanner;

public class MatchIndex {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter the first string: ");
        // String str = scanner.nextLine();
        // System.out.print("Enter the string to be matched: ");
        // String sub = scanner.nextLine();
        // scanner.close();
        String str = "Welcome to Java";
        String sub = "come";
        int pointerSub = 0;

        if (sub.length() > str.length()) {
            System.err.println("The second string does not match the first due to its larger size");
            return;
        }

        for (int pointerStr = 0; pointerStr < str.length(); pointerStr++) {
            if (str.charAt(pointerStr) == sub.charAt(pointerSub)) {
                if (pointerSub == sub.length() - 1) {
                    // if subpointer gets to the end of the substring, the match has been
                    // verified
                    System.out.println("Matched at index " + (pointerStr - pointerSub));
                    return;
                }
                // if letter at pointer position are the same, increase pointer to check next
                // character
                pointerSub++;
            } else if (str.charAt(pointerStr) != sub.charAt(pointerSub)) {
                // if letters are at pointer position are different, substring pointer resets
                pointerSub = 0;
            }
        }
        System.out.println("Strings do not match.");
    }
}
