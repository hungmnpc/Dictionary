import java.util.ArrayList;

public class Dictionary {
    ArrayList<Word> words;

    /**
     * contructor.
     */
    public Dictionary() {
        words = new ArrayList<>();
    }

    public void add(Word newWord) {
        words.add(newWord);
    }

    public void show() {
        for (Word v : words) {
            System.out.println(v.getWord());
        }
    }

}
