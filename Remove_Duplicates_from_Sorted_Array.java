package LeetCode;

/**
 * Created by YIZHONGQI on 11/12/2016.
 */
public class Remove_Duplicates_from_Sorted_Array {

    // 只用一个index
    public class Solution {
        public int removeDuplicates( int[] nums ) {
            int len = nums.length;
            if ( nums == null || len == 0 )
                return 0;

            int cur = 1;
            for ( int i = 1; i < len; i++ ) {
                if ( nums[i] != nums[cur - 1] ) {
                    nums[cur++] = nums[i];
                }
            }
            return cur;
        }
    }


    public class Solution_origin {
        public int removeDuplicates( int[] nums ) {
            int len = nums.length;
            if ( nums == null || len == 0 )
                return 0;

            // 一个指针指向可插入的位置,一个数保存上一个插入答案的数
            int cur = 1;
            int prevNum = nums[0];
            for ( int i = 1; i < len; i++ ) {
                if ( nums[i] != prevNum ) {
                    nums[cur] = nums[i];
                    prevNum = nums[i];
                    cur++;
                }
            }
            return cur;
        }
    }
}
