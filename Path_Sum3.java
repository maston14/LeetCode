package LeetCode;

import java.util.HashMap;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class Path_Sum3 {

    // backtracking, with preSum
    public int pathSum_bt( TreeNode root, int sum ) {
        HashMap<Integer, Integer> preSum = new HashMap(); // 用一个map来存访问一个node时他之前的preSum(这个值包括自己), key是值,value是到这个值有几条路径
        preSum.put( 0, 1 );
        return helper_bt( root, 0, sum, preSum );
    }

    public int helper_bt( TreeNode root, int cur, int sum, HashMap<Integer, Integer> preSum ) {
        if ( root == null ) {
            return 0;
        }

        cur += root.val;
        int res = preSum.getOrDefault( cur - sum, 0 ); // 在map中找key = cur - sum是否存在, 若存在,则表示在该路径上, 去掉cur - sum的前缀开始,到现在这个节点,就有一条和为sum的路

        preSum.put( cur, preSum.getOrDefault( cur, 0 ) + 1 ); // 把以该node结尾的preSum加入到map中

        res += helper_bt( root.left, cur, sum, preSum ) + helper_bt( root.right, cur, sum, preSum );

        preSum.put( cur, preSum.get( cur ) - 1 ); // 回溯
        return res;
    }
    //******************************************************************************************************************
    // 2次dfs
    //******************************************************************************************************************

    public int pathSum( TreeNode root, int sum ) {
        if ( root == null )
            return 0;
        return findPath( root, sum ) + pathSum( root.left, sum ) + pathSum( root.right, sum );
    }

    public int findPath( TreeNode root, int sum ) {
        int res = 0;
        if ( root == null )
            return res;
        if ( sum == root.val )
            res++;
        res += findPath( root.left, sum - root.val );
        res += findPath( root.right, sum - root.val );
        return res;
    }

    //******************************************************************************************************************
    // with boolean
    //******************************************************************************************************************

    public int pathSum_boolean( TreeNode root, int sum ) {

        if ( root == null ) return 0;
        return helper( root, sum, false );
    }

    // Either the path has not started, or it has to go all the way to the end.
    private int helper( TreeNode root, int sum, boolean hasStarted ) {

        if ( root == null ) return 0;

        // if the path has not started, we start now or not.
        if ( !hasStarted ) {
            return helper( root, sum, true ) + helper( root.left, sum, false ) + helper( root.right, sum, false );
        }
        // if the path has started
        sum -= root.val;
        return helper( root.left, sum, true ) + helper( root.right, sum, true ) + ( sum == 0 ? 1 : 0 );
    }

}
