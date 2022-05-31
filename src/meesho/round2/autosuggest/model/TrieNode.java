package meesho.round2.autosuggest.model;

import java.util.HashMap;

public class TrieNode {

    private Character character;

    private HashMap<Character, TrieNode> charMap;

    private boolean isWordEnd;

    public TrieNode(Character character) {
       this(character, false);
    }

    public TrieNode(Character character, boolean isWordEnd) {
        this.character = character;
        this.charMap = new HashMap<>();
        this.isWordEnd = isWordEnd;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public HashMap<Character, TrieNode> getCharMap() {
        return charMap;
    }

    public void setCharMap(HashMap<Character, TrieNode> charMap) {
        this.charMap = charMap;
    }

    public boolean isWordEnd() {
        return isWordEnd;
    }

    public void setWordEnd(boolean wordEnd) {
        isWordEnd = wordEnd;
    }
}
