package LeetCode;

/**
 * Created by YIZHONGQI on 01/12/2016.
 */
public class Move_Zeros_283 {

    public class Solution {
        public void moveZeroes( int[] nums ) {
            int j = 0;
            for( int i = 0; i < nums.length; i++ ) {
                if( nums[i] != 0 ) {
                    nums[j++] = nums[i];
                }
            }
            for( ; j < nums.length; j++ ) {
                nums[j] = 0;
            }
        }
    }


    public class Solution_Swap {
        public void moveZeroes( int[] nums ) {
            int j = 0;
            for ( int i = 0; i < nums.length; i++ ) {
                if ( nums[i] != 0 ){
                    swap(nums, i, j++ );
                }
            }
        }
        public void swap( int[] nums, int i, int j ) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
