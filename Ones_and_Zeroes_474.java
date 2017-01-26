package LeetCode;

/**
 * Created by YIZHONGQI on 21/12/2016.
 */
public class Ones_and_Zeroes_474 {

    // simple dp
    public class Solution {
        public int findMaxForm( String[] strs, int m, int n ) {
            int[][] dp = new int[m + 1][n + 1];
            for ( String s : strs ) {
                int[] count = zero_one( s );
                // 从后开始循环, 避免不够减的情况
                for ( int i = m; i >= count[0]; i-- ) {
                    for ( int j = n; j >= count[1]; j-- ) {
                        dp[i][j] = Math.max( dp[i][j], 1 + dp[i - count[0]][j - count[1]] );
                    }
                }
            }
            return dp[m][n];
        }

        public int[] zero_one( String s ) {
            int[] res = new int[2];
            for ( char c : s.toCharArray() ) {
                res[c - '0']++;
            }
            return res;
        }
    }
}
