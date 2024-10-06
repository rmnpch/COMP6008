import java.util.*;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();
        // String str = new String("abcdefa");
        String currentStr = new String("");
        String longestStr = new String("");
        char prev = str.charAt(0);
        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) > prev) {
                currentStr += str.charAt(i);
            } else {
                currentStr = str.substring(i, i + 1);
            }
            prev = str.charAt(i);
            longestStr = currentStr.length() > longestStr.length() ? currentStr : longestStr;
        }
        System.err.println(longestStr);
    }
}
