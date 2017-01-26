package LeetCode;

/**
 * Created by YIZHONGQI on 20/11/2016.
 */
public class Paint_House {

    // O(1) Space
    public class Solution {
        public int minCost( int[][] costs ) {
            if ( costs == null ) return 0;
            int num = costs.length;
            if ( num == 0 || costs[0].length != 3 ) return 0;


            int dp0 = costs[0][0];
            int dp1 = costs[0][1];
            int dp2 = costs[0][2];

            for ( int i = 1; i < num; i++ ) {
                int t0 = dp0;
                int t1 = dp1;
                int t2 = dp2;

                dp0 = costs[i][0] + Math.min( t1, t2 );
                dp1 = costs[i][1] + Math.min( t0, t2 );
                dp2 = costs[i][2] + Math.min( t0, t1 );
            }
            return Math.min( dp0, Math.min( dp1, dp2 ) );
        }
    }


    // O(n) Space
    public class Solution_On {
        public int minCost( int[][] costs ) {
            if ( costs == null ) return 0;
            int num = costs.length;
            if ( num == 0 || costs[0].length != 3 ) return 0;

            int[][] dp = new int[num][3];
            dp[0][0] = costs[0][0];
            dp[0][1] = costs[0][1];
            dp[0][2] = costs[0][2];

            for ( int i = 1; i < num; i++ ) {
                dp[i][0] = costs[i][0] + Math.min( dp[i - 1][1], dp[i - 1][2] );
                dp[i][1] = costs[i][1] + Math.min( dp[i - 1][0], dp[i - 1][2] );
                dp[i][2] = costs[i][2] + Math.min( dp[i - 1][0], dp[i - 1][1] );
            }
            return Math.min( dp[num - 1][0], Math.min( dp[num - 1][1], dp[num - 1][2] ) );
        }
    }
}
