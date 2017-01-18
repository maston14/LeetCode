package LeetCode;

import java.util.Arrays;

/**
 * Created by YIZHONGQI on 18/12/2016.
 */
public class Longest_Consecutive_Sequence_128 {



    // 排序的写法, naive, O(nlogn)
    public class Solution {
        public int longestConsecutive(int[] nums) {
            Arrays.sort(nums);
            int max = 1;
            int count = 1;
            for( int i = 0; i < nums.length - 1; i++ ){
                if( nums[ i ] == nums[ i + 1 ] - 1 )
                    count++;
                else if(nums[ i ] == nums[ i + 1 ]){
                    continue;
                }else{
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
            return max;
        }
    }
}
