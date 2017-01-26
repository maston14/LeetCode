package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YIZHONGQI on 21/11/2016.
 */
public class Three_Sum_15 {

    // 这里的target是0


    public class Solution_Shorter {
        public List<List<Integer>> threeSum( int[] nums ) {
            List<List<Integer>> res = new ArrayList<>();
            if ( nums.length < 3 )
                return res;
            Arrays.sort( nums );

            for ( int i = 0; i < nums.length - 2; i++ ) {
                if ( i > 0 && nums[i] == nums[i - 1] )
                    continue;
                int lo = i + 1;
                int hi = nums.length - 1;
                int target = 0 - nums[i];
                while ( lo < hi ) {
                    int temp_sum = nums[lo] + nums[hi];
                    if ( temp_sum == target ) {
                        res.add( Arrays.asList( nums[i], nums[lo], nums[hi] ) );
                        while ( lo < hi && nums[lo] == nums[lo + 1] ) lo++;
                        while ( lo < hi && nums[hi] == nums[hi - 1] ) hi--;
                        lo++;
                        hi--;
                    } else if ( temp_sum < target )
                        lo++;
                    else
                        hi--;
                }
            }
            return res;
        }
    }

    public class Solution {
        public List<List<Integer>> threeSum( int[] nums ) {
            List<List<Integer>> res = new ArrayList<>();
            if ( nums.length < 3 ) return res;

            // 排序一下
            Arrays.sort( nums );

            for ( int i = 0; i < nums.length; i++ ) {
                // 因为要不重复的,所以如果跟nums[i-1]一样,答案肯定被包括了
                if ( i > 0 && nums[i] == nums[i - 1] )
                    continue;
                // 对于nums[i],从i+1到最后,两个指针开始扫
                int head = i + 1;
                int end = nums.length - 1;

                if ( end - head < 1 ) break;
                int target = 0 - nums[i];
                // 这里下面就是一个用pointer的2sum
                while ( head < end ) {
                    int sum = nums[head] + nums[end];
                    if ( sum == target ) {
                        List<Integer> list = new ArrayList<>();
                        list.add( nums[i] );
                        list.add( nums[head] );
                        list.add( nums[end] );
                        res.add( list );

                        while ( head + 1 < end && nums[head] == nums[head + 1] )
                            head++;

                        while ( end - 1 > head && nums[end] == nums[end - 1] )
                            end--;

                        head++;
                        end--;
                    } else if ( sum < target ) {
                        head++;
                    } else
                        end--;
                }
            }
            return res;
        }
    }

}
