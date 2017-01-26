package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YIZHONGQI on 12/11/2016.
 */
public class Maximum_Depth_of_Binary_Tree {

    // DFS
    public int maxDepth( TreeNode root ) {
        if ( root == null )
            return 0;

        Deque<TreeNode> node = new LinkedList<>();
        Deque<Integer> depth = new LinkedList<>();
        node.push( root );
        depth.push( 1 );
        int max = 0;

        while ( node.size() > 0 ) {
            TreeNode t = node.pop();
            int temp = depth.pop();
            max = Math.max( temp, max );
            if ( t.left != null ) {
                node.push( t.left );
                depth.push( temp + 1 );
            }
            if ( t.right != null ) {
                node.push( t.right );
                depth.push( temp + 1 );
            }
        }
        return max;
    }


    // BFS
    public int maxDepth_BFS( TreeNode root ) {
        if ( root == null )
            return 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer( root );
        int count = 0;
        while ( queue.size() > 0 ) {
            int toPoll = queue.size();
            while ( toPoll-- > 0 ) {
                TreeNode t = queue.poll();
                if ( t.left != null ) queue.offer( t.left );
                if ( t.right != null ) queue.offer( t.right );
            }
            count++;
        }
        return count;
    }
}
