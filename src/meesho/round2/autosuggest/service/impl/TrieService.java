package meesho.round2.autosuggest.service.impl;

import meesho.round2.autosuggest.model.TrieNode;
import meesho.round2.autosuggest.model.WordFreq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieService {

    private int maxWords;

    public TrieService(int limit) {
        this.maxWords = limit;
    }

    public Map<String, List<WordFreq>> getAllWordFrequencies(List<String> words) {
        HashMap<String, List<WordFreq>> wordMap = new HashMap<>();
        buildTrie(words, wordMap);
        return wordMap;
    }

    /**
     * Returns frequency of all words with given prefix
     * @param words
     * @param wordMap
     * @return
     */
    public TrieNode buildTrie(List<String> words, HashMap<String, List<WordFreq>> wordMap) {
        return new TrieNode('Z');
    }

}
