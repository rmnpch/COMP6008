import java.util.*;
import java.io.*;

public class StackTesting {
    String path = "";

    public StackTesting(String path) {
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
                        
                    else if (e.charAt(0) == '<' && e.charAt(1) == '/') {
                        if (symStack.empty())
                            System.err.println("Tags being closed before they are being opened.");
                        else
                            symStack.pop();
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found.\nPlease make sure the path to the file is correct.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.err.println(symStack.isEmpty());
    }

    public static void main(String[] args) {
        String path = "D:\\OneDrive - Southern Cross University\\SCU\\Term 4\\COMP6008 Data Structure and Algorithms\\A1\\Module 1\\html_file.txt";
        StackTesting std = new StackTesting(path);
        std.tagCheck();
    }
}