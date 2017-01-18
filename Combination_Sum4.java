package LeetCode;

/**
 * Created by YIZHONGQI on 15/12/2016.
 */
public class Combination_Sum4 {

    /*
    nums = [1, 2, 3]
    target = 4

    The possible combination ways are:
    (1, 1, 1, 1)
    (1, 1, 2)
    (1, 2, 1)
    (1, 3)
    (2, 1, 1)
    (2, 2)
    (3, 1)

    Note that different sequences are counted as different combinations.

    Therefore the output is 7.
     */

    public class SolutionDP {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for( int i = 1; i <= target; i++ ){
                int sum = 0;
                for( int j = 0; j < nums.length; j++){
                     if( i >= nums[j])
                        sum += dp[ i - nums[j]];
                }
                dp[i] = sum;
            }
            return dp[target];
        }
    }


    public class Solution_Recursive {
        public int combinationSum4(int[] nums, int target) {
            if (target == 0) {
                return 1;
            }

            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (target >= nums[i]) {
                    res += combinationSum4(nums, target - nums[i]);
                }
            }
            return res;
        }
    }
}
