package LeetCode;

/**
 * Created by YIZHONGQI on 28/01/2017.
 */
public class Add_and_Search_Word_211 {

    // Trie
    public class WordDictionary {
        public class TrieNode {
            public TrieNode[] children;
            public boolean isEnd;
            public TrieNode() {
                children = new TrieNode[26];
                isEnd = false;
            }
        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode node = root;
            for ( char c : word.toCharArray() ) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return match( word.toCharArray(), 0, root );
        }

        private boolean match(char[] chs, int k, TrieNode node) {
            if (k == chs.length) return node.isEnd;
            if (chs[k] != '.') {
                return node.children[chs[k] - 'a'] != null && match( chs, k + 1, node.children[chs[k] - 'a'] );
            } else {
                for ( int i = 0; i < node.children.length; i++ ) {
                    if ( node.children[i] != null ) {
                        if ( match( chs, k + 1, node.children[i] ) ) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
