package LeetCode;

/**
 * Created by ZHONGQI on 2/8/17.
 */
public class Wildcard_Matching_44 {

    /*
    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

    '*' 是单独使用的

     */

    public class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null ) {
                return false;
            }
            // 2d dp's size is s + 1, p + 1
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

            dp[0][0] = true;

            // 0th row 代表着 s 为空字符的时候的情况
            for (int i = 1; i < p.length() + 1; i++) {
                // 只有碰到 * 的时候并把 * 算成 empty
                if (p.charAt( i - 1 ) == '*' && dp[0][i - 1] ) {
                    dp[0][i] = true;
                }
            }
            for (int i = 1 ; i < s.length() + 1; i++) {
                for (int j = 1; j < p.length() + 1; j++) {
                    // case 1: '?' && case 2: equal char - have the same behavior
                    if( p.charAt( j - 1 ) == s.charAt( i - 1) || p.charAt( j - 1 ) == '?' ) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    /* case 3: '*'
                            3.1 要么不用 * : dp[i][j - 1]
                            3.2 要么用 * : dp[i - 1][j]
                     */
                    if( p.charAt( j - 1 ) == '*' ) {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
            return dp[s.length()][p.length()];

        }
    }
}
