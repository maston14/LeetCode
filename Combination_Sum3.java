package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 06/11/2016.
 */
public class Combination_Sum3 {

    public List<List<Integer>> combinationSum3( int k, int n ) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs( res, list, k, n, 1 );
        return res;
    }

    public void dfs( List<List<Integer>> res, List<Integer> list, int k, int n, int start ) {
        if ( k == 0 && n == 0 ) {
            res.add( new ArrayList<>( list ) ); // 记得新建一个list
        } else {
            for ( int i = start; i <= 9; i++ ) {
                list.add( i );
                dfs( res, list, k - 1, n - i, i + 1 );
                list.remove( list.size() - 1 );
            }
        }
    }

}
