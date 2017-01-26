package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 14/12/2016.
 */
public class Combinations {


    // backtracking
    public class Solution {
        public List<List<Integer>> combine( int n, int k ) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            helper( ans, list, 1, k, n );
            return ans;
        }

        public void helper( List<List<Integer>> ans, List<Integer> list, int start, int k, int end ) {
            if ( k == 0 ) {
                ans.add( new ArrayList<Integer>( list ) );
                return;
            } else {
                for ( int i = start; i <= end; i++ ) {
                    list.add( i );
                    helper( ans, list, i + 1, k - 1, end );
                    list.remove( list.size() - 1 );
                }
            }
        }
    }
}
