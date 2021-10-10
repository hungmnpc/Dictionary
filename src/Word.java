public class Word implements Comparable<Word> {
    private String word_target;
    private String word_pronounce;
    private String word_explain;

    @Override
    public int compareTo(Word s) {
        return this.getWord_target().compareTo(s.getWord_target());
    }

    public Word() {
        word_target = "";
        word_pronounce = "";
        word_explain = "";
    }

    public Word(String s1, String s2, String s3) {
        word_target = s1;
        word_pronounce = s2;
        word_explain = s3;
    }


    /**
     * set Word_target.
     */
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    /**
     * get Word_target.
     */
    public String getWord_target() {
        return word_target;
    }

    /**
     * set Word_explain.
     */
    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    /**
     * get Word_explain.
     */
    public String getWord_explain() {
        return word_explain;
    }

    /**
     * set Word_pronounce.
     */
    public void setWord_pronounce(String word_pronounce) {
        this.word_pronounce = word_pronounce;
    }

    /**
     * get Word_pronounce.
     */
    public String getWord_pronounce() {
        return word_pronounce;
    }

    /**
     * get Word.
     * @return
     */
    public String getWord() {
        return String.format("\t%s\t\t|\t\t%s\t\t|\t\t%s", getWord_target(), getWord_pronounce(), getWord_explain());
    }

//    public static void main(String[] args) throws IOException {
//
//        Dictionary newList = new Dictionary();
//
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//
//        ArrayList<Integer> list = newList.dictionarySearcher(s);
//        if (list != null) {
//            newList.show(list.get(0), list.get(1));
//        } else {
//            System.out.println("Hung dbrr");
//        }
//
//
//        //newList.show();
//    }

}
