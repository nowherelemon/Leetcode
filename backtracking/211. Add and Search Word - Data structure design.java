/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
*/


class WordDictionary {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            this.isWord = false;
            children = new TrieNode[26];
        }
    }
        
    TrieNode root;
        
    

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] sc = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < sc.length; i++) {
            if (cur.children[sc[i] - 'a'] == null) {
                cur.children[sc[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[sc[i] - 'a'];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return innerSearch(word, root);
    }
    
    private boolean innerSearch(String word, TrieNode cur) {
        if (word.length() < 1) {
            return cur.isWord;
        }
        char c = word.charAt(0);
        if (c != '.') {
            if (cur.children[c - 'a'] == null) {
                return false;
            } else {
                return innerSearch(word.substring(1), cur.children[c - 'a']);
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null && innerSearch(word.substring(1), cur.children[i])) {
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
