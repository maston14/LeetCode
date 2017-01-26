package LeetCode;

/**
 * Created by YIZHONGQI on 22/12/2016.
 */
public class Longest_Substring_with_At_Most_Two_Distinct_Characters_159 {

    public class Solution {
        public int lengthOfLongestSubstringTwoDistinct( String s ) {
            int[] count = new int[256];
            int num = 0, i = 0, res = 0;
            for ( int j = 0; j < s.length(); j++ ) {
                if ( count[s.charAt( j )]++ == 0 )
                    num++;
                if ( num > 2 ) {
                    while ( --count[s.charAt( i++ )] > 0 ) ;
                    num--;
                }
                res = Math.max( res, j - i + 1 );
            }
            return res;
        }
    }
}
