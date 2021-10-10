import java.io.*;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    ArrayList<Word> words;

    public DictionaryManagement() {
        words = new ArrayList<>();
    }

    private final static String data_url = "dictionaries.txt";

    public String getData_url() {
        return data_url;
    }

    public void insertFromFile() throws IOException {

        FileReader file = new FileReader(data_url);
        int i;
        String s = "";
        while ((i = file.read()) != -1) {
            s += (char) i;
        }

        String[] strings = s.split("\n");
        for (String string : strings) {

            String[] elements = string.split("[|]");

            Word newWord = new Word();
            newWord.setWord_target(elements[0]);
            newWord.setWord_pronounce(elements[1]);
            newWord.setWord_explain(elements[2]);

            words.add(newWord);
        }

        file.close();
    }

//    public void insetFromCommandline(){
//        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.nextLine();
//        String s2 = scanner.nextLine();
//        Word word = new Word(s1,"",s2);
//        words.add(word);
//
//    }
}
