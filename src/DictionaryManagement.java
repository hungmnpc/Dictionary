import java.io.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Scanner;

public class DictionaryManagement {
    private final static String data_url = "Data.txt";

    public void insertFromCommandline() {
        Word newWord = new Word();
        File file = new File(data_url);
        Scanner scanner = new Scanner(System.in);
        System.out.println(file.getPath());
    }

}
