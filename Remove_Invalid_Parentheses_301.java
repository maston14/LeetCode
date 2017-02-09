package LeetCode;

import java.util.*;

/**
 * Created by ZHONGQI on 2/6/17.
 */
public class Remove_Invalid_Parentheses_301 {


    // 从左扫找多余的')', 然后从右找多余的'('
    public class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<>();
            remove(s, ans, 0, 0, new char[]{'(', ')'});
            return ans;
        }

        public void remove( String s, List<String> ans, int start, int last_remove, char[] pair ) {
            int stack = 0;
            // 遍历s，找到 non valid 的位置
            for( int i = start; i < s.length(); i++ ) {
                if( s.charAt( i ) == pair[0] ) stack++;
                if( s.charAt( i ) == pair[1] ) stack--;
                if( stack >= 0 ) continue;
                // 找到一个 non valid 的位置
                for( int j = last_remove; j <= i; j++ ) {
                    // 此时是多了一个')', 那么在 i 之前的任何一个')'去掉都可以
                    // 从last_remove开始找，避免重复，且只找第一个')',找到后remove，此时前面的部分都是valid，递归的找后面的
                    if( s.charAt( j ) == pair[1] && ( j == last_remove || s.charAt( j - 1 ) != pair[1] ) ) {
                        remove( s.substring( 0, j ) + s.substring( j + 1 ), ans, i, j, pair );
                    }
                }
                // 这里return保证了minimum remove
                return;
            }

            // 这里从右往左找多余的'('
            String reversed = new StringBuilder( s ).reverse().toString();
            // 表明从左到右完了, 开始从右到左
            if( pair[0] == '(' ) {
                remove( reversed, ans, 0, 0, new char[]{ ')', '(' }  );
            }else {
                // 这里只在从右到左完了之后才add, 此时的reversed是被reverse过两次了, 先reverse了再传给右到左,然后右到左完了,又再reverse回来
                ans.add( reversed );
            }
        }

    }


    /* very slow
     就是维护一个队列, 每次取队列头, 去check 是不是 valid,
        如果 valid 且是第一次valid, 那么这个长度就是 remove minimun number 的长度, 那么答案应该都是这个长度
        如果 valid, 但不是第一次valid, 那么去看长度符不符合
        只要valid, 后面都continue

        如果 not valid, 那么每一位都remove试试, 放进队列
    */
    public class Solution_BFS {
        public List<String> removeInvalidParentheses(String s) {
            List<String> list = new ArrayList<>();
            if( s == null ) {
                return list;
            }

            Deque<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            queue.offer( s );
            visited.add( s );

            boolean found = false;

            while( !queue.isEmpty() ) {
                String cur = queue.poll();

                if( isValid( cur ) ) {
                    list.add( cur );
                    found = true;
                }
                // once found a answer, there is no need to add new string into the string
                // all other possible answers must be still in the queue
                if( found ) {
                    continue;
                }

                for( int i = 0; i < cur.length(); i++ ) {
                    if( cur.charAt( i ) != '(' && cur.charAt( i ) != ')' ){
                        continue;
                    }
                    String temp = cur.substring( 0, i ) + cur.substring( i + 1 );
                    if( !visited.contains( temp ) ) {
                        visited.add( temp );
                        queue.offer( temp );
                    }
                }

            }

            return list;
        }

        public boolean isValid( String s ) {
            if( s == null ) {
                return false;
            }
            int count = 0;
            for( char c : s.toCharArray() ) {
                if( c == '(' ) {
                    count++;
                }else if( c == ')' ) {
                    if( count-- == 0 ) {
                        return false;
                    }
                }
            }

            return count == 0;
        }
    }
}
