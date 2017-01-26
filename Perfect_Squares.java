package LeetCode;

/**
 * Created by YIZHONGQI on 20/11/2016.
 * <p>
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class Perfect_Squares {

    public class Solution {
        public int numSquares( int n ) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for ( int i = 2; i < n + 1; i++ ) {
                int maxTarget = (int) Math.sqrt( i );

                // if i is perfect square, 直接设为1; 小小的剪枝
                if ( maxTarget * maxTarget == i ) {
                    dp[i] = 1;
                    continue;
                }

                // 把i 去减所有比他小的perfect square, 找一个最小的
                int min = Integer.MAX_VALUE;
                for ( int j = maxTarget; j >= 1; j-- ) {
                    int temp = 1 + dp[i - j * j];
                    if ( temp < min )
                        min = temp;
                }
                dp[i] = min;
            }
            return dp[n];
        }
    }

}
