package LeetCode;

/**
 * Created by ZHONGQI on 2/24/17.
 */
public class Edit_Distance_72 {

    /*
    要处理 "" 的情况, 所以要 dp[len1 + 1][len2 + 1]

    If they are not equal, we need to consider three cases:

    Replace word1[i - 1] by word2[j - 1] (dp[i][j] = dp[i - 1][j - 1] + 1 (for replacement));
    Delete word1[i - 1] and word1[0..i - 2] = word2[0..j - 1] (dp[i][j] = dp[i - 1][j] + 1 (for deletion));
    Insert word2[j - 1] to word1[0..i - 1] and word1[0..i - 1] + word2[j - 1] = word2[0..j - 1] (dp[i][j] = dp[i][j - 1] + 1 (for insertion)).
     */

    /*
    以上分析可以发现, 每次只要上一行就行, 所以不用存 2D, 存一行或者一列就好, 每次更新这一行
     */
    public class Solution_1D_DP {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();

            int[] dp = new int[len1 + 1];
            for( int i = 1; i < len1 + 1; i++ ) {
                dp[i] = i;
            }

            // 这样是 一列一列 的更新, 每次出原来的一列
            for( int j = 1; j < len2 + 1; j++ ) {
                // pre 就是原来的dp[i-1][j-1]
                int pre = dp[0];
                dp[0] = j;
                for( int i = 1; i < len1 + 1; i++ ) {
                    int temp = dp[i];
                    if( word1.charAt( i - 1 ) == word2.charAt( j - 1 ) ) {
                        dp[i] = pre;
                    }else {
                        // dp[i - 1] 是改好的, 所以就是之前的dp[i - 1][j]
                        // dp[i] 是还没改的, 所以还是上一行的, 就是原来的dp[i][j - 1]
                        dp[i] = Math.min( pre, Math.min( dp[i - 1], dp[i] ) ) + 1;
                    }
                    // 每次更新pre
                    pre = temp;
                }
            }

            return dp[len1];
        }
    }


    public class Solution_2D_DP {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();

            int[][] dp = new int[len1 + 1][len2 + 1];

            for( int i = 1; i < len1 + 1; i++ ) {
                dp[i][0] = i;
            }
            for( int j = 1; j < len2 + 1; j++ ) {
                dp[0][j] = j;
            }

            for( int i = 1; i < len1 + 1; i++ ) {
                for( int j = 1; j < len2 + 1; j++ ) {
                    if( word1.charAt( i - 1 ) == word2.charAt( j - 1 ) ) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }else {
                        dp[i][j] = Math.min( dp[i - 1][j - 1] + 1, Math.min( dp[i - 1][j], dp[i][j - 1] ) + 1 );
                    }
                }
            }
            return dp[len1][len2];
        }
    }
}
