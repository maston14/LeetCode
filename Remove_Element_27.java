package LeetCode;

/**
 * Created by YIZHONGQI on 20/01/2017.
 */
public class Remove_Element_27 {

    public class Solution {
        public int removeElement(int[] nums, int val) {
            int j = 0;
            for( int i = 0; i < nums.length; i++ ) {
                if( nums[i] != val ) {
                    nums[j++] = nums[i];
                }
            }
            return j;
        }
    }
}
