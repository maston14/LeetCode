package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 12/11/2016.
 */
public class Find_Leaves_of_Binary_Tree {


    // 自底向上定义高度,叶子的高度为0,同一高度的进同一层的list
    public List<List<Integer>> findLeaves( TreeNode root ) {
        List<List<Integer>> res = new ArrayList<>();
        height( root, res );
        return res;
    }

    private int height( TreeNode node, List<List<Integer>> res ) {
        if ( node == null ) return -1;

        int h = 1 + Math.max( height( node.left, res ), height( node.right, res ) );
        // 若第一次到该level,加一个list
        if ( res.size() < h + 1 )
            res.add( new ArrayList<Integer>() );

        res.get( h ).add( node.val );
        return h;
    }

    // 每次深搜
    public List<List<Integer>> findLeaves_dfs( TreeNode root ) {
        List<List<Integer>> ans = new ArrayList<>();
        if ( root == null ) return ans;
        while ( root.left != null || root.right != null ) {
            List<Integer> list = new ArrayList<>();
            dfs( root.left, root, list, true );
            dfs( root.right, root, list, false );
            ans.add( list );
        }
        List<Integer> list = new ArrayList<>();
        list.add( root.val );
        ans.add( list );
        return ans;
    }

    public void dfs( TreeNode node, TreeNode father, List<Integer> list, boolean left ) {
        if ( node == null ) return;
        if ( node.left == null && node.right == null ) {
            list.add( node.val );
            if ( left )
                father.left = null;
            else
                father.right = null;
        }
        dfs( node.left, node, list, true );
        dfs( node.right, node, list, false );
    }

}
