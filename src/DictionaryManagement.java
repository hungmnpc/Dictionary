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
            if ((char) i == '@') {
                Word newWord = new Word();

                int index = s.indexOf("\n");
                String s1 = s.substring(0, index);
                s1 = s1.trim();
                s = s.substring(index + 1);
                s = s.trim();
                if (s1.contains(" /")) {
                    int index1 = s1.indexOf(" /");
                    newWord.setWord_target(s1.substring(0,index1));
                    newWord.setWord_pronounce(s1.substring(index1 + 1));
                } else {
                    newWord.setWord_target(s1);
                }

                newWord.setWord_explain(s);
                words.add(newWord);
                s = "";
            } else {
                s += (char) i;
            }
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
