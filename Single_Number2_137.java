package LeetCode;

/**
 * Created by YIZHONGQI on 22/01/2017.
 */
public class Single_Number2_137 {

    /*
    Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
     */

    // 计数每一位的 1 的个数, 然后 % 3
    public class Solution {
        public int singleNumber( int[] nums ) {
            int ans = 0;
            // 一位一位来
            for ( int i = 0; i < 32; i++ ) {
                int sum = 0;
                // 对每一位, 统计这一位的 1 的个数
                for ( int j = 0; j < nums.length; j++ ) {
                    sum += ( nums[j] >> i ) & 1;
                }
                sum %= 3;
                // 把这一位放到答案中
                ans |= sum << i;
            }
            return ans;
        }
    }
}
