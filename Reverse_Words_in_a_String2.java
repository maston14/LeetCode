package LeetCode;

/**
 * Created by YIZHONGQI on 14/12/2016.
 */
public class Reverse_Words_in_a_String2 {


    // 先全部reverse, 再每个词reverse
    public class Solution {
        public void reverseWords( char[] s ) {
            int len = s.length;

            reverse( s, 0, len - 1 );
            int i = 0, j = 0;
            for (; j < len; j++ ) {
                if ( j == len - 1 || s[j + 1] == ' ' ) {
                    reverse( s, i, j );
                    i = j + 2;
                }
            }
        }

        public void reverse( char[] s, int start, int end ) {
            while ( start < end ) {
                char t = s[start];
                s[start++] = s[end];
                s[end--] = t;
            }
        }

    }
}
