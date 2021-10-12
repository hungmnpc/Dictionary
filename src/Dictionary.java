
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    ArrayList<Word> words;

    DictionaryManagement dictionaryManagement;

    /**
     * contructor.
     */
    public Dictionary() throws IOException {
        words = new ArrayList<>();
        dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.insertFromFile();

        //dictionaryManagement.dictionaryExportToFile();
        this.add(dictionaryManagement.words);
        this.sort();
    }

    public void add(Word newWord) {
        words.add(newWord);
    }

    public void add(ArrayList<Word> word){
        words.addAll(word);
    }

    public void sort() {
        words.sort(Word::compareTo);
    }

    private ArrayList<Integer> dictionarySearcher(String s) {
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

    public void insertNewWord(String s1, String s2, String s3) throws IOException {
        Word word = new Word(s1, s2, s3);
        words.add(word);
        this.sort();

        File file = new File(dictionaryManagement.getData_url());
        FileWriter fw = new FileWriter(file,true);
        fw.write("\n" + s1 + "|" + s2 + "|" + s3);
        fw.close();
    }

    public void delete(String s) throws IOException {
        ArrayList<Integer> list = dictionarySearcher(s);
        if (list != null) {
            if (words.get(list.get(0)).getWord_target().equals(s)) {
                System.out.println("Deleted");

                words.remove((int) list.get(0));
                FileWriter file = new FileWriter(dictionaryManagement.getData_url());
                file.write(words.get(0).getWord_target() + "|" + words.get(0).getWord_pronounce() +
                        "|" + words.get(0).getWord_explain());
                for (int i = 1; i < words.size(); i++) {
                    file.write("\n" + words.get(i).getWord_target() + "|" + words.get(i).getWord_pronounce() +
                            "|" + words.get(i).getWord_explain());
                }
                file.close();
                return;
            }
        }

        System.out.println("Not have word " + s);
    }

    public void show() {
        for (Word v : words) {
            System.out.println(v.getWord());
        }
    }

    public ArrayList<Word> getListWordSearch(String s) {
        ArrayList<Integer> index =  dictionarySearcher(s);
        if (index != null) {
            int a = index.get(0);
            int b = index.get(1);
            ArrayList<Word> list = new ArrayList<>();
            for (int i = a; i <= b; i++) {
                list.add(words.get(i));
                System.out.println(words.get(i).getWord());
            }
            return list;
        } else {
            return null;
        }
    }

}
