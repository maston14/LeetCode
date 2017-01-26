package LeetCode;

/**
 * Created by YIZHONGQI on 15/12/2016.
 */
public class Coin_Change {

    /*
    经典的dp问题
     */
    // 空间优化, 用一维数组
    public class Solution {
        public int coinChange( int[] coins, int amount ) {
            if ( amount == 0 )
                return 0;
            int[] dp = new int[amount + 1];
            for ( int i = 1; i < amount + 1; i++ )
                dp[i] = Integer.MAX_VALUE;

            for ( int i = 0; i < coins.length; i++ ) {
                for ( int j = 1; j < amount + 1; j++ ) {
                    if ( j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE ) {
                        dp[j] = Math.min( dp[j], dp[j - coins[i]] + 1 );
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

        }
    }


    // 2维数组的版本
    public class Solution_2D_Array {
        public int coinChange( int[] coins, int amount ) {
            if ( amount == 0 )
                return 0;
            int[][] dp = new int[coins.length][amount + 1];
            for ( int i = 0; i < coins.length; i++ )
                for ( int j = 1; j <= amount; j++ )
                    dp[i][j] = Integer.MAX_VALUE;

            // initialize first row
            for ( int i = 0; i < amount + 1; i++ ) {
                if ( i % coins[0] == 0 )
                    dp[0][i] = i / coins[0];
            }

            for ( int i = 1; i < coins.length; i++ ) {
                for ( int j = 0; j < amount + 1; j++ ) {
                    if ( j < coins[i] ) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        int compare = dp[i][j - coins[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + dp[i][j - coins[i]];
                        dp[i][j] = Math.min( dp[i - 1][j], compare );

                    }
                }
            }
            return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
        }
    }
}
