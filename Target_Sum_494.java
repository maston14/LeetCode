package LeetCode;

/**
 * Created by YIZHONGQI on 23/01/2017.
 */
public class Target_Sum_494 {

    /*
    Input: nums is [1, 1, 1, 1, 1], S is 3.
    Output: 5
    Explanation:

    -1+1+1+1+1 = 3
    +1-1+1+1+1 = 3
    +1+1-1+1+1 = 3
    +1+1+1-1+1 = 3
    +1+1+1+1-1 = 3

    There are 5 ways to assign symbols to make the sum of nums be target 3.

    1. The length of the given array is positive and will not exceed 20.
    2. The sum of elements in the given array will not exceed 1000.
    3. Your output answer is guaranteed to be fitted in a 32-bit integer.
     */
    public class Solution {
        //题目给了所有的sum不超过1000
        private int scale = 1000;

        public int findTargetSumWays( int[] nums, int S ) {
            if ( nums == null || nums.length == 0 || S > 1000 )
                return 0;

            int[][] dp = new int[nums.length][2 * scale + 1];
            dp[0][scale - nums[0]]++;
            dp[0][scale + nums[0]]++;
            for ( int i = 1; i < nums.length; i++ ) {
                for ( int j = 0; j < 2 * scale + 1; j++ ) {
                    if ( dp[i - 1][j] != 0 ) {
                        dp[i][j - nums[i]] += dp[i - 1][j];
                        dp[i][j + nums[i]] += dp[i - 1][j];
                    }
                }
            }

            return dp[nums.length - 1][scale + S];
        }
    }
}
