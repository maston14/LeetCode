package LeetCode;

/**
 * Created by YIZHONGQI on 20/11/2016.
 */
public class Paint_Fence {


    // O(1) Space
    public class Solution_O1 {
        public int numWays( int n, int k ) {
            if ( n == 0 ) return 0;
            if ( n == 1 ) return k;
            if ( n == 2 ) return k * k;
            int ans = 0;
            int prev2 = k;
            int prev1 = k * k;
            for ( int i = 2; i < n; i++ ) {
                ans = prev1 * ( k - 1 ) + prev2 * ( k - 1 );
                prev2 = prev1;
                prev1 = ans;
            }
            return ans;

        }
    }


    // O(n) Space
    public class Solution_On {
        public int numWays( int n, int k ) {
            if ( n == 0 ) return 0;
            if ( n == 1 ) return k;
            if ( n == 2 ) return k * k;

            int[] dp = new int[n];
            dp[0] = k;
            dp[1] = k * k;

            for ( int i = 2; i < n; i++ )
                /*
                1. 不管前面怎么样,只要跟i-1的颜色不一样,肯定ok -> dp[i-1]*(k-1)
                2. 跟i-1颜色一样,那么就要跟i-2的颜色不一样 -> dp[i-2]*(k-1)
                 */
                dp[i] = dp[i - 1] * ( k - 1 ) + dp[i - 2] * ( k - 1 );
            return dp[n - 1];

        }
    }
}
