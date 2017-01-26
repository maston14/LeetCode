package LeetCode;

/**
 * Created by YIZHONGQI on 11/12/2016.
 */
public class Remove_Duplicates_from_Sorted_Array2 {

    // 非常短
    public class Solution_Short {
        public int removeDuplicates( int[] nums ) {
            int i = 0;
            for ( int n : nums )
                if ( i < 2 || n > nums[i - 2] )
                    nums[i++] = n;
            return i;
        }
    }


    // neat condition
    public class Solution {
        public int removeDuplicates( int[] nums ) {
            int len = nums.length;
            if ( nums == null || len == 0 )
                return 0;

            int cur = 1;
            int count = 0;

            for ( int i = 1; i < len; i++ ) {
                if ( nums[i] > nums[cur - 1] ) {
                    nums[cur++] = nums[i];
                    count = 0;
                } else if ( count < 1 ) {
                    nums[cur++] = nums[i];
                    count++;
                }
            }

            return cur;
        }
    }


    // origin version, 感觉判断的条件写的有点啰嗦
    public class Solution_Origin {
        public int removeDuplicates( int[] nums ) {
            int len = nums.length;
            if ( nums == null || len == 0 )
                return 0;

            int cur = 1;
            int count = 1;
            int prevNum = nums[0];

            for ( int i = 1; i < len; i++ ) {
                if ( nums[i] == prevNum && count < 2 ) {
                    nums[cur] = prevNum;
                    cur++;
                    count++;
                } else if ( nums[i] != prevNum ) {
                    nums[cur] = nums[i];
                    prevNum = nums[i];
                    count = 1;
                    cur++;
                }
            }

            return cur;
        }
    }
}
