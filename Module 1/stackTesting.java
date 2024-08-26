import java.util.*;
import java.io.*;

public class stackTesting {

    String path = "";

    public stackTesting(String path) {
        this.path = path;
    }

    public void tagCheck() {
        Stack<String> symStack = new Stack<>();
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (String e : tokens) {
                    if (e.charAt(0) == '<' && e.charAt(1) != '/')
                        symStack.push(e);
                    else if (e.charAt(0) == '<' && e.charAt(1) == '/')
                        symStack.pop();
                }
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.err.println("File could not be found.\nPlease make sure the path to the .csv file is correct.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.err.println( symStack.isEmpty());

    }

    public static void main(String[] args) {

        String path = "//student.scu.ad/Home/TgcSCUHome/rdepai10/Documents/COMP6008/Module 1/html_file.txt";

        stackTesting std = new stackTesting(path);
        // std is an object from the stackTesting class, which can be used to run the
        // program
        std.tagCheck();
        // System.out.println(parenCheck("((()))")); // expected true
        // System.out.println(parenCheck("((()()))")); // expected true
        // System.out.println(parenCheck("(()")); // expected false
        // System.out.println(parenCheck(")(")); // expected false
    }
}