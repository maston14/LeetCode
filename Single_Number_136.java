package LeetCode;

/**
 * Created by YIZHONGQI on 22/01/2017.
 */
public class Single_Number_136 {

    /*
    Given an array of integers, every element appears twice except for one. Find that single one.
     */

    public class Solution {
        public int singleNumber( int[] nums ) {
            int ans = 0;
            // 都 xor 一下就好了
            for ( int num : nums )
                ans ^= num;
            return ans;
        }
    }
}
