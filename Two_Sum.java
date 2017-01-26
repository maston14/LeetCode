package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Two_Sum {

    public int[] twoSum( int[] nums, int target ) {
        int[] ans = new int[2];

        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        for ( int i = 0; i < nums.length; i++ ) {
            index.put( nums[i], i );
        }
        Arrays.sort( nums );
        int h = 0;
        int t = nums.length - 1;
        while ( h < t ) {
            if ( nums[h] + nums[t] < target ) {
                h++;
            } else if ( nums[h] + nums[t] > target ) {
                t--;
            } else {
                int x = index.get( nums[h] );
                int y = index.get( nums[t] );
                ans[0] = x < y ? x : y;
                ans[1] = x > y ? x : y;
                break;
            }
        }
        return ans;
    }


    public int[] twoSum2( int[] nums, int target ) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for ( int i = 0; i < nums.length; i++ ) map.put( nums[i], i );
        for ( int i = 0; i < nums.length; i++ ) {
            int needed = target - nums[i];
            if ( map.containsKey( needed ) && map.get( needed ) != i ) return ( new int[]{i, map.get( needed )} );
        }
        return null;
    }

}
