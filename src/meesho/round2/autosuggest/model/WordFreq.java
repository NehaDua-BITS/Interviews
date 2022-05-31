package meesho.round2.autosuggest.model;

public class WordFreq {

    private String word;

    private int frequency;

    public WordFreq(String word) {
        this(word, 0);
    }

    public WordFreq(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}
