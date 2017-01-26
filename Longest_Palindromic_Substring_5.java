package LeetCode;

/**
 * Created by YIZHONGQI on 12/01/2017.
 */
public class Longest_Palindromic_Substring_5 {


    /*
    DP method, slow
    dp(i, j) represents whether s(i ... j) can form a palindromic substring,
    dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring.
    When we found a palindrome, check if it's the longest one. Time complexity O(n^2).
    */
    public class Solution_DP {
        public String longestPalindrome( String s ) {
            int len = s.length();
            String res = null;

            boolean[][] dp = new boolean[len][len];

            for ( int i = len - 1; i >= 0; i-- ) {
                for ( int j = i; j < len; j++ ) {

                    dp[i][j] = ( s.charAt( i ) == s.charAt( j ) ) && ( j - i < 3 || dp[i + 1][j - 1] );

                    if ( dp[i][j] && ( res == null || j - i + 1 > res.length() ) ) {
                        res = s.substring( i, j + 1 );
                    }
                }
            }

            return res;

        }
    }
}
