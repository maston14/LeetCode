package LeetCode;

/**
 * Created by YIZHONGQI on 11/11/2016.
 */
public class Unique_Paths_62 {

    /**
     * 这个问题可以简化成一个排列组合问题
     * 一共要走 m-1 + n-1步,
     * 所以总步数是 m+n-2, 相当于把m-1(向下的步数)就定下来,对n-1一步做排列,所以是 C(n-1,m+n-2)
     * AKA 把整个过程看做一个步数的序列,只有向下和向右两种走法,类似于 右右右下右 这种. 排列组合
     */
    public int uniquePaths_Combiantion( int m, int n ) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for ( int i = 1; i <= k; i++ )
            res = res * ( N - k + i ) / i;
        return (int) res;
    }

    // 因为只能往右或者往下, 每个block的可能路线由他的上面和左边决定
    public class Solution {
        public int uniquePaths( int m, int n ) {
            if ( m < 2 || n < 2 ) return 1;
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for ( int i = 0; i < m; i++ ) {
                for ( int j = 0; j < n; j++ ) {
                    if ( i == 0 && j == 0 )
                        continue;
                    else if ( i == 0 )
                        dp[i][j] = dp[i][j - 1];
                    else if ( j == 0 )
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            return dp[m - 1][n - 1];
        }

    }

}
