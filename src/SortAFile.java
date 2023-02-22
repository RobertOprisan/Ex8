import java.io.*;
import java.util.*;
public class SortAFile {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage SortAFile <filename>");
            System.exit(1);
        }
        sortFile(args[0]);
    }
    private static void sortFile(String filename)
            throws IOException {
        File fileInput = new File(filename);
        File fileOutput = new File("temp.txt");
        BufferedReader input = null;
        PrintWriter output = null;
        String line;
        List<String> list = new ArrayList<>();
        try {
            input = new BufferedReader(new FileReader(fileInput));
            output = new PrintWriter(new FileWriter(fileOutput));
            while ((line = input.readLine()) != null) {
                list.add(line);
            }
            Collections.sort(list);
            for (String s : list) {
                System.out.println(s);
                output.println(s);
            }
            fileInput.delete();
            fileOutput.renameTo(fileInput);
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
}