package LeetCode;

public class Maximum_Subarray_53 {
    public int maxSubArray_DP_Origin(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for ( int i = 1; i < nums.length; i++ ) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
