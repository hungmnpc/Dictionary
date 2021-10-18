import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

    public boolean checkAlready(Word word) {
        for (Word v : words) {
            if (v.getWord().equals(word.getWord())) {
                System.out.println("đã có");
                return false;
            }
        }
        return  true;
    }

    public void insertNewWord(Word word) throws IOException {
        words.add(word);
        this.sort();

        File file = new File(dictionaryManagement.getData_url());
        FileWriter fw = new FileWriter(file,true);
        fw.write(word.getWord_target() + " " + word.getWord_pronounce() + "\n" + word.getWord_explain() + "\n\n@");
        fw.close();
    }

    public void editWord(Word currentWord, Word newWord) throws IOException {
        words.remove(currentWord);
        words.add(newWord);
        this.sort();
        FileWriter file = new FileWriter(dictionaryManagement.getData_url());

        for (Word word : words) {
            file.write( word.getWord_target() + " " + word.getWord_pronounce() + "\n" + word.getWord_explain() + "\n\n@");
        }
        file.close();
    }


    public void delete(Word word) throws IOException {
        words.remove(word);
        FileWriter file = new FileWriter(dictionaryManagement.getData_url());
        for (Word w : words) {
            file.write(w.getWord_target() + " " + w.getWord_pronounce() + "\n" + w.getWord_explain() + "\n\n@");
        }
        file.close();
    }

    public void show() {
        for (Word v : words) {
            System.out.println(v.getWord());
        }
    }

    public ArrayList<Word> getListWordSearch(String s) {
        ArrayList<Integer> index =  dictionaryManagement.dictionarySearcher(s);
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
