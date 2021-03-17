import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

class TrieNode {
    private final char c;
    private Map<Character, TrieNode> children;
    private boolean endOfWord = false;	// indicates that is the is last character of a word

    public TrieNode(char c) {
        this.c = c;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void insert(String s, int pos) {
        if (s == null || pos >= s.length()) return;
        // allocate on demand
        if (children == null) children = new HashMap<>();

        char c = s.charAt(pos);
        TrieNode node = children.get(c);
        // make sure we have a child with char c
        if (node == null) {
            node = new TrieNode(c);
            children.put(c, node);
        }

        // if we are the last node in the sequence of chars that make up the string
        if (pos == s.length() - 1)
            node.endOfWord = true;
        else
            node.insert(s, pos + 1);
    }

    // Performs a lookup in this Trie of the substring starts at pos index of s
    // Returns TrieNode of the last char of s if this Trie contains the substring, or null otherwise
    public TrieNode lookup(String s, int pos) {
        if (s == null) return null;
        if (pos >= s.length() || children == null)
            return null;
        else if (pos == s.length() - 1)
            return children.get(s.charAt(pos));
        else {
            TrieNode node = children.get(s.charAt(pos));
            return node == null ? null : node.lookup(s, pos + 1);
        }
    }

    public TrieNode getChild(char child) {
        return children == null ? null : children.get(child);
    }
}


class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode((char)0);
        for (String word : wordDict) {
            root.insert(word, 0);
        }
        Boolean[] canBreakCache = new Boolean[s.length()];
        Map<Integer, List<List<String>>> wordsCache = new HashMap<>();
        List<List<String>> list = getWordsFromPosition(0, s, root, canBreakCache, wordsCache);

        return list.stream()
                .map(wordList -> String.join(" ", wordList))
                .collect(toList());
    }

    // starts analyzing s from startIndex position
    // returns all possible combinations of words
    private List<List<String>> getWordsFromPosition(int startIndex, String s, TrieNode root, Boolean[] canBreakCache, Map<Integer, List<List<String>>> cache) {
        List<List<String>> cachedList = cache.get(startIndex);
        if (cachedList != null) return cachedList;
        List<List<String>> resList = new ArrayList<>();
        if (startIndex == s.length()) return resList;
        List<Integer> wordEnds = getWordEnds(s, root, startIndex);
        for (int i : wordEnds)
            if (canBreak(i, s, root, canBreakCache)) {
                List<List<String>> list = getWordsFromPosition(i, s, root, canBreakCache, cache);
                if (list.size() == 0) { // this is the last word in s
                    List<String> tmp = new LinkedList<>();
                    tmp.add(s.substring(startIndex, i));
                    resList.add(tmp);
                } else {
                    list.forEach(subList -> {
                        LinkedList<String> tmp = new LinkedList<>(subList);
                        tmp.addFirst(s.substring(startIndex, i));
                        resList.add(tmp);
                    });
                }
            }
        cache.put(startIndex, resList);
        return resList;
    }

    private boolean canBreak(int startIndex, String s, TrieNode root, Boolean[] cache) {
        if (startIndex == s.length()) return true;
        if (cache[startIndex] != null) return cache[startIndex];
        List<Integer> wordEnds = getWordEnds(s, root, startIndex);
        for (int i : wordEnds)
            if (canBreak(i, s, root, cache)) {
                cache[startIndex] = true;
                return true;
            }
        cache[startIndex] = false;
        return false;
    }

    // start searching s for words from startIndex
    // returns ending positions of existing words, exclusive
    // list is sorted descending
    private List<Integer> getWordEnds(String s, TrieNode root, int startIndex) {
        LinkedList<Integer> list = new LinkedList<>();
        int pos = startIndex;
        TrieNode node = root;
        while (pos < s.length()) {
            node = node.getChild(s.charAt(pos));
            if (node == null) return list;
            pos++;
            if (node.isEndOfWord()) list.addFirst(pos);
        }
        return list;
    }
}