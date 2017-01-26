package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YIZHONGQI on 05/12/2016.
 */
public class Maximum_Size_Subarray_Sum_Equals_k {

    // much nicer
    // 扫描求和的时候就开始查map, 这样一遍扫完结果也出来了.
    public class Solution {
        public int maxSubArrayLen( int[] nums, int k ) {

            int sum = 0, max = 0;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            for ( int i = 0; i < nums.length; i++ ) {
                // 不用数组,直接求sum,每次都进map
                sum = sum + nums[i];
                if ( sum == k )
                    max = i + 1;
                else if ( map.containsKey( sum - k ) )
                    max = Math.max( max, i - map.get( sum - k ) );

                // 同样的值,只放位置最前面的一个
                if ( !map.containsKey( sum ) )
                    map.put( sum, i );
            }
            return max;
        }
    }


    // origin, with hashmap
    public class Solution_Origin {
        public int maxSubArrayLen( int[] nums, int k ) {
            if ( nums == null || nums.length == 0 )
                return 0;

            int[] sum = new int[nums.length + 1];
            Map<Integer, List<Integer>> map = new HashMap<>();

            sum[0] = 0;
            List<Integer> list = new ArrayList<>();
            list.add( -1 );
            map.put( 0, list );

            for ( int i = 1; i < nums.length + 1; i++ ) {
                sum[i] = sum[i - 1] + nums[i - 1];
                if ( !map.containsKey( sum[i] ) ) {
                    List<Integer> l = new ArrayList<>();
                    l.add( i );
                    map.put( sum[i], l );
                } else {
                    List<Integer> l = map.get( sum[i] );
                    l.add( i );
                }
            }

            int ans = 0;

            for ( int i = 0; i < nums.length + 1; i++ ) {
                List<Integer> l = map.get( k + sum[i] );
                if ( l != null ) {
                    int lastPos = l.get( l.size() - 1 );
                    if ( lastPos > i && lastPos - i > ans )
                        ans = lastPos - i;
                }
            }
            return ans;
        }
    }
}
