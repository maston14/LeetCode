package LeetCode;

import java.util.*;

/**
 * Created by ZHONGQI on 2/6/17.
 */
public class Random_Pick_Index_398 {


    // use a map to store the list of index for each value
    public class Solution_Origin {

        Map<Integer,List<Integer>> map;

        public Solution_Origin(int[] nums) {
            map = new HashMap<>();
            for( int i = 0; i < nums.length; i++ ) {
                if( !map.containsKey( nums[i] ) ) {
                    map.put( nums[i], new ArrayList<>() );
                }
                map.get( nums[i] ).add( i );
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get( target );
            if( list == null || list.size() == 0 ) {
                return -1;
            }
            Random r = new Random();
            int index = list.get( r.nextInt( list.size() ) );
            return index;
        }
    }
}
