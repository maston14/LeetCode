package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 15/12/2016.
 */
public class Combinations_of_Factor {

    // faster
    public class Solution {
        public List<List<Integer>> getFactors( int n ) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            List<Integer> cd = new ArrayList<>();

            helper( ans, list, n, 2 );
            return ans;
        }

        public void helper( List<List<Integer>> ans, List<Integer> list, int target, int start ) {
            if ( target == 1 ) {
                if ( list.size() > 1 )
                    ans.add( new ArrayList<Integer>( list ) );
                return;
            } else if ( target > 1 ) {
                // 这里只考虑到根号target
                int mid = (int) Math.sqrt( target );
                if ( start <= mid ) {
                    for ( int i = start; i <= mid; i++ ) {
                        if ( target % i == 0 ) {
                            list.add( i );
                            System.out.println( list );
                            helper( ans, list, target / i, i );
                            list.remove( list.size() - 1 );
                        }
                    }
                }
                // 再加上target就好
                list.add( target );
                helper( ans, list, target / target, target );
                list.remove( list.size() - 1 );

            }
        }
    }


    public class Solution_Origin {
        public List<List<Integer>> getFactors( int n ) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            List<Integer> cd = new ArrayList<>();

            helper( ans, list, n, 2 );
            return ans;
        }

        public void helper( List<List<Integer>> ans, List<Integer> list, int target, int start ) {
            if ( target == 1 ) {
                if ( list.size() > 1 )
                    ans.add( new ArrayList<Integer>( list ) );
                return;
            } else if ( target > 1 ) {
                for ( int i = start; i <= target; i++ ) {
                    if ( target % i == 0 ) {
                        list.add( i );
                        helper( ans, list, target / i, i );
                        list.remove( list.size() - 1 );
                    }
                }
            }
        }
    }
}
