package LeetCode;

/**
 * Created by YIZHONGQI on 20/11/2016.
 */
public class Paint_House2 {

    // （n*k) time, 维护上一行的最小的两个数的index: minindex, min2index
    // O(1) Space
    public class Solution {
        public int minCostII( int[][] costs ) {
            if ( costs == null || costs.length == 0 ) return 0;

            int n = costs.length, k = costs[0].length;
            // min1 is the index of the 1st-smallest cost till previous house
            // min2 is the index of the 2nd-smallest cost till previous house
            int min1index = -1, min2index = -1;

            for ( int i = 0; i < n; i++ ) {
                int last1 = min1index, last2 = min2index;
                min1index = -1;
                min2index = -1;

                for ( int j = 0; j < k; j++ ) {
                    if ( j != last1 ) {
                        // current color j is different to last min1
                        costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                    } else {
                        costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                    }

                    // find the indices of 1st and 2nd smallest cost of painting current house i
                    if ( min1index < 0 || costs[i][j] < costs[i][min1index] ) {
                        min2index = min1index;
                        min1index = j;
                    } else if ( min2index < 0 || costs[i][j] < costs[i][min2index] ) {
                        min2index = j;
                    }
                }
            }

            return costs[n - 1][min1index];
        }
    }


    // 跟paint house没什么区别
    // O(n*k*k) time
    public class Solution_OkSpace {
        public int minCostII( int[][] costs ) {
            if ( costs == null || costs.length == 0 ) return 0;
            int n = costs.length;
            int k = costs[0].length;

            int[] dp = new int[k];
            int[] temp = new int[k];
            for ( int i = 0; i < k; i++ )
                dp[i] = costs[0][i];

            for ( int i = 1; i < n; i++ ) {
                for ( int j = 0; j < k; j++ )
                    temp[j] = dp[j];
                for ( int j = 0; j < k; j++ ) {
                    dp[j] = costs[i][j] + min( temp, j );
                }
            }
            int min = dp[0];
            for ( int i : dp )
                if ( i < min )
                    min = i;
            return min;
        }

        public int min( int[] dp, int pos ) {
            int min = Integer.MAX_VALUE;
            for ( int i = 0; i < dp.length; i++ ) {
                if ( i != pos && dp[i] < min )
                    min = dp[i];
            }
            return min;
        }
    }

}
