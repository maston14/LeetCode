package LeetCode;

/**
 * Created by YIZHONGQI on 20/11/2016.
 */
public class Implement_Trie {


    // 假设字符集只有26个小写字母
    // 如果不限定26个小写字母,可以用HashMap代替Array
    class TrieNode {
        TrieNode[] map;
        Boolean isEnd;
        // Initialize your data structure here.
        public TrieNode() {
            map = new TrieNode[26];
            isEnd = false;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            char[] ch_a = word.toCharArray();
            TrieNode t = root;
            for(char ch : ch_a){
                if(t.map[ch-'a'] != null){
                    t = t.map[ch-'a'];
                }else{
                    t.map[ch-'a'] = new TrieNode();
                    t = t.map[ch-'a'];
                }
            }
            t.isEnd = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            char[] ch_a = word.toCharArray();
            TrieNode t = root;
            for(char ch : ch_a){
                if(t.map[ch-'a'] != null){
                    t = t.map[ch-'a'];
                }else
                    return false;
            }
            return t.isEnd;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            char[] ch_a = prefix.toCharArray();
            TrieNode t = root;
            for(char ch : ch_a){
                if(t.map[ch-'a'] != null){
                    t = t.map[ch-'a'];
                }else
                    return false;
            }
            if(t.isEnd)
                return true;

            for(TrieNode tn : t.map)
                if(tn != null)
                    return true;

            return false;
        }
    }

}
