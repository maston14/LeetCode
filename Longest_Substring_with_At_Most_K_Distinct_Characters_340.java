package LeetCode;

/**
 * Created by YIZHONGQI on 22/12/2016.
 */
public class Longest_Substring_with_At_Most_K_Distinct_Characters_340 {

    // sliding window
    public class Solution {
        public int lengthOfLongestSubstringKDistinct( String s, int k ) {

            int[] count = new int[256];

            int num = 0, i = 0, res = 0;

            for ( int j = 0; j < s.length(); j++ ) {
                // 这里比较之后直接++
                if ( count[s.charAt( j )]++ == 0 )
                    num++;

                if ( num > k ) {
                    // 这里先--, 然后i直接++
                    while ( --count[s.charAt( i++ )] > 0 ) ;
                    num--;
                }

                res = Math.max( res, j - i + 1 );
            }
            return res;
        }
    }
}
