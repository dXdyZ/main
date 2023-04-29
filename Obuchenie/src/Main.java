import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        readFile();
    }

    public static void  readFile() throws FileNotFoundException {
        File file = new File("test.txt");
        Scanner scanner = new Scanner(file);
    }
}