package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YIZHONGQI on 23/01/2017.
 */
public class Subsets2_90 {

    public class Solution {
        public List<List<Integer>> subsetsWithDup( int[] nums ) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();

            // 得先排序
            Arrays.sort( nums );
            dfs( res, list, nums, 0 );
            res.add( new ArrayList<Integer>() );
            return res;
        }

        public void dfs( List<List<Integer>> res, List<Integer> list, int[] nums, int start ) {
            for ( int i = start; i < nums.length; i++ ) {
                // 略过重复的
                if ( i > start && nums[i] == nums[i - 1] )
                    continue;
                list.add( nums[i] );
                res.add( new ArrayList<>( list ) );
                dfs( res, list, nums, i + 1 );
                list.remove( list.size() - 1 );
            }
        }
    }
}
