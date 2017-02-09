package LeetCode;

import java.util.*;

/**
 * Created by ZHONGQI on 2/7/17.
 */
public class Word_Ladder_127 {


    // 同时从 begin 和 word 开始找
    public class Solution_TwoEndBFS {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordDict = new HashSet<>();
            wordDict.addAll(wordList);
            if( !wordDict.contains( endWord ) ) return 0;

            int ans = 1;

            // 2 个 set, 一头一尾
            Set<String> headSet = new HashSet<>();
            Set<String> tailSet = new HashSet<>();

            headSet.add( beginWord );
            tailSet.add( endWord );

            wordDict.remove( beginWord );
            wordDict.remove( endWord );

            boolean flip = false;

            while( !headSet.isEmpty() && !tailSet.isEmpty() ) {
                // 要交替着来
                if( flip ) {
                    Set<String> temp = headSet;
                    headSet = tailSet;
                    tailSet = temp;
                    flip = false;
                }else {
                    flip = true;
                }

                Set<String> nextSet = new HashSet<>();

                for( String s : headSet ) {
                    // 对每个词的每个位置
                    for( int i = 0; i < s.length(); i++ ) {
                        char[] word = s.toCharArray();
                        for( char ch = 'a'; ch <= 'z'; ch++ ) {
                            word[i] = ch;
                            String step = new String( word );

                            // 如果变了一位后,在另外一个集合中找到了,那就是答案
                            if( tailSet.contains( step ) )
                                return ans + 1;

                            if( wordDict.contains( step ) ){
                                wordDict.remove( step );
                                nextSet.add( step );
                            }
                        }
                    }
                }

                headSet = nextSet;
                ans++;
            }
            return 0;

        }
    }



    public class Solution_OneEndBFS {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordDict = new HashSet<String>();
            wordDict.addAll(wordList);

            Deque<String> queue = new LinkedList<>();
            queue.offer( beginWord );
            int ans = 0;
            while( !queue.isEmpty() ) {
                // 按层遍历
                int num = queue.size();
                for( int i = 0; i < num; i++ ) {
                    String cur = queue.poll();
                    // find the ans
                    if( cur.equals( endWord ) ) return ans + 1;
                    // 对每个词, 改变一个字母, 如果在wordDict中, 就加入队列, 并从wordDict中删除, 防止重复
                    for( int j = 0; j < cur.length(); j++ ) {
                        char[] word = cur.toCharArray();
                        // 对每一个位置, 尝试 'a' to 'z'
                        for( char ch = 'a'; ch <= 'z'; ch++ ) {
                            word[j] = ch;
                            String temp = new String( word );
                            if( wordDict.contains( temp ) ) {
                                queue.offer( temp );
                                wordDict.remove( temp );
                            }
                        }

                    }
                }
                // 更新层数
                ans++;
            }
            return 0;

        }

    }
}
