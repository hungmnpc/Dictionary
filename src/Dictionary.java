
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

    public ArrayList<Integer> dictionarySearcher(String s) {
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

    public void show() {
        for (Word v : words) {
            System.out.println(v.getWord());
        }
    }

    public void show(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println(words.get(i).getWord());
        }
    }

}
