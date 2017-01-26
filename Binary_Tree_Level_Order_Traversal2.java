package LeetCode;

import java.util.*;

/**
 * Created by YIZHONGQI on 10/11/2016.
 */
public class Binary_Tree_Level_Order_Traversal2 {

    // dfs
    public List<List<Integer>> levelOrderBottom_dfs( TreeNode root ) {
        List<List<Integer>> ans = new ArrayList<>(); // 这里不用linkedlist是因为后面有大量的get操作
        dfs( ans, root, 0 );
        return ans;
    }

    public void dfs( List<List<Integer>> ans, TreeNode node, int level ) {
        if ( node == null ) return;

        // 第一次遍历到level这层时在ans中加一个元素,代表这一层的值
        if ( level > ans.size() - 1 )
            ans.add( 0, new ArrayList<Integer>() );

        dfs( ans, node.left, level + 1 );
        dfs( ans, node.right, level + 1 );

        ans.get( ans.size() - 1 - level ).add( node.val );
    }

    // bfs 双队列
    public List<List<Integer>> levelOrderBottom( TreeNode root ) {
        List<List<Integer>> ans = new LinkedList<>();
        if ( root == null ) return ans;
        Deque<TreeNode> curL = new LinkedList<>();
        Deque<TreeNode> nextL = new LinkedList<>();
        curL.offer( root );
        while ( curL.size() != 0 ) {
            List<Integer> list = new ArrayList<>();

            while ( curL.size() != 0 ) {
                TreeNode t = curL.poll();

                list.add( t.val );

                if ( t.left != null )
                    nextL.offer( t.left );

                if ( t.right != null )
                    nextL.offer( t.right );
            }

            ans.add( 0, list );
            Deque<TreeNode> temp = curL;
            curL = nextL;
            nextL = temp;
        }
        return ans;
    }

    // bfs的单队列写法
    public List<List<Integer>> levelOrderBottom_bfs2( TreeNode root ) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ( root == null ) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add( root );
        while ( q.size() > 0 ) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for ( int i = 0; i < size; i++ ) {
                TreeNode node = q.poll();
                list.add( node.val );
                if ( node.left != null ) q.add( node.left );
                if ( node.right != null ) q.add( node.right );
            }
            result.add( 0, list );
        }
        return result;

    }

}
