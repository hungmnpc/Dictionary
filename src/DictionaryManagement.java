import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;

public class DictionaryManagement {
    private Dictionary dictionary;

    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.sort();
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
                dictionary.getWords().add(newWord);
                s = "";
            } else {
                s += (char) i;
            }
        }
        file.close();
    }

    public boolean checkAlready(Word word) {
        for (Word v : dictionary.getWords()) {
            if (v.getWord().equals(word.getWord())) {
                return false;
            }
        }
        return  true;
    }

    public void insertNewWord(Word word) throws IOException {
        dictionary.getWords().add(word);
        this.sort();

        File file = new File(getData_url());
        FileWriter fw = new FileWriter(file,true);
        fw.write(word.getWord_target() + " " + word.getWord_pronounce() + "\n" + word.getWord_explain() + "\n\n@");
        fw.close();
    }

    private void sort() {
        dictionary.getWords().sort(Word::compareTo);
    }

    public void add(Word newWord) {
        dictionary.getWords().add(newWord);
    }

    public void editWord(Word currentWord, Word newWord) throws IOException {
        dictionary.getWords().remove(currentWord);
        dictionary.getWords().add(newWord);
        this.sort();
        FileWriter file = new FileWriter(getData_url());

        for (Word word : dictionary.getWords()) {
            file.write( word.getWord_target() + " " + word.getWord_pronounce() + "\n" + word.getWord_explain() + "\n\n@");
        }
        file.close();
    }

    public void delete(Word word) throws IOException {
        dictionary.getWords().remove(word);
        FileWriter file = new FileWriter(getData_url());
        for (Word w : dictionary.getWords()) {
            file.write(w.getWord_target() + " " + w.getWord_pronounce() + "\n" + w.getWord_explain() + "\n\n@");
        }
        file.close();
    }

    private ArrayList<Integer> dictionarySearcher(String s) {
        s = s.trim();
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0;
        int r = dictionary.getWords().size() - 1;

        while (l <= r) {
            int i = (l + r) / 2;

            if (dictionary.getWords().get(i).getWord_target().substring(0,
                    Math.min(dictionary.getWords().get(i).getWord_target().length(), s.length())).equalsIgnoreCase(s)) {
                int j = i;
                while (dictionary.getWords().get(i).getWord_target().substring(0,
                        Math.min(dictionary.getWords().get(i).getWord_target().length(), s.length())).equalsIgnoreCase(s)) {
                    i--;
                    if (i < 0) {
                        break;
                    }
                }
                while (dictionary.getWords().get(j).getWord_target().substring(0,
                        Math.min(dictionary.getWords().get(j).getWord_target().length(), s.length())).equalsIgnoreCase(s)) {
                    j++;
                    if (j > dictionary.getWords().size() - 1) {
                        break;
                    }
                }
                list.add(++i);
                list.add(--j);
                return list;
            }
            else if (dictionary.getWords().get(i).getWord_target().compareToIgnoreCase(s) < 0) {
                l = i + 1;
            }
            else {
                r = i - 1;
            }
        }
        return null;
        //return new ArrayList<>(-1);

    }

    public ArrayList<Word> getListWordSearch(String s) {
        ArrayList<Integer> index = dictionarySearcher(s);
        if (index != null) {
            int a = index.get(0);
            int b = index.get(1);
            ArrayList<Word> list = new ArrayList<>();
            for (int i = a; i <= b; i++) {
                list.add(dictionary.getWords().get(i));
            }
            return list;
        } else {
            return null;
        }
    }

}
