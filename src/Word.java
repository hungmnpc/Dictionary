public class Word {
    private String word_target;
    private String word_explain;
    private String word_pronounce;

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

    public static void main(String[] args) {
        Word hello = new Word();
        hello.setWord_target("Hello");
        hello.setWord_explain("Xin chào");
        hello.setWord_pronounce("/həˈləʊ/");

        Word apple  = new Word();
        apple.setWord_target("apple ");
        apple.setWord_explain("Quả táo");
        apple.setWord_pronounce("/ˈæpl/");

        DictionaryManagement alo = new DictionaryManagement();
        alo.insertFromCommandline();

        Dictionary newList = new Dictionary();
        newList.add(hello);
        newList.add(apple);
        newList.show();
    }

}
