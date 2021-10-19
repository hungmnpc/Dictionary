import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> words;
    public DictionaryManagement dictionaryManagement;

    /**
     * contructor.
     */
    public Dictionary() throws IOException {
        words = new ArrayList<>();
        dictionaryManagement = new DictionaryManagement(this);
        dictionaryManagement.insertFromFile();
    }

    public void show() {
        for (Word v : words) {
            System.out.println(v.getWord());
        }
    }

    public ArrayList<Word> getWords() {
        return words;
    }
}
