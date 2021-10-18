import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;

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

    public ArrayList<Integer> dictionarySearcher(String s) {
        s = s.trim();
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0;
        int r = words.size() - 1;

        while (l <= r) {
            int i = (l + r) / 2;

            if (words.get(i).getWord_target().substring(0,
                    Math.min(words.get(i).getWord_target().length(), s.length())).equalsIgnoreCase(s)) {
                int j = i;
                while (words.get(i).getWord_target().substring(0,
                        Math.min(words.get(i).getWord_target().length(), s.length())).equalsIgnoreCase(s)) {
                    i--;
                    if (i < 0) {
                        break;
                    }
                }
                while (words.get(j).getWord_target().substring(0,
                        Math.min(words.get(j).getWord_target().length(), s.length())).equalsIgnoreCase(s)) {
                    j++;
                    if (j > words.size() - 1) {
                        break;
                    }
                }
                list.add(++i);
                list.add(--j);
                return list;
            }
            else if (words.get(i).getWord_target().compareToIgnoreCase(s) < 0) {
                l = i + 1;
            }
            else {
                r = i - 1;
            }
        }
        return null;
        //return new ArrayList<>(-1);

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
