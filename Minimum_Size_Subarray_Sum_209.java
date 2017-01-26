package LeetCode;

/**
 * Created by YIZHONGQI on 22/01/2017.
 */
public class Minimum_Size_Subarray_Sum_209 {

    public class Solution {
        public int minSubArrayLen( int s, int[] nums ) {
            if ( nums == null || nums.length == 0 )
                return 0;
            int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

            while ( j < nums.length ) {
                sum += nums[j++];

                while ( sum >= s ) {
                    min = Math.min( min, j - i );
                    sum -= nums[i++];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
}
