package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Symmetric_Tree {

    // 递归
    public boolean isSymmetric( TreeNode root ) {
        if ( root == null ) return true;
        return isSame( root.left, root.right );
    }

    public Boolean isSame( TreeNode t1, TreeNode t2 ) {
        if ( t1 == null && t2 == null ) return true;
        if ( t1 == null || t2 == null ) return false;

        if ( t1.val == t2.val )
            return isSame( t1.left, t2.right ) && isSame( t1.right, t2.left );
        else
            return false;
    }

    // 非递归DFS
    public boolean isSymmetric_DFS( TreeNode root ) {
        if ( root == null ) {
            return true;
        }
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        while ( left != null || right != null || !leftStack.isEmpty() || !leftStack.isEmpty() ) {
            if ( left == null && right != null ) {
                return false;
            }
            if ( left != null && right == null ) {
                return false;
            }
            if ( left != null && right != null ) {
                if ( left.val != right.val ) {
                    return false;
                }
                leftStack.push( left );
                rightStack.push( right );
                left = left.left;
                right = right.right;
            } else {
                left = leftStack.pop().right;
                right = rightStack.pop().left;
            }
        }
        return true;
    }

    // 非递归BFS
    public boolean isSymmetric_BFS( TreeNode root ) {
        if ( root == null ) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        if ( root.left != null && root.right != null ) {
            q.offer( root.left );
            q.offer( root.right );
        } else if ( root.left == null && root.right == null )
            return true;
        else
            return false;

        while ( !q.isEmpty() ) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if ( t1 == null && t2 == null )
                continue;
            else if ( t1 == null || t2 == null )
                return false;
            else if ( t1.val != t2.val )
                return false;
            q.offer( t1.left );
            q.offer( t2.right );
            q.offer( t1.right );
            q.offer( t2.left );
        }
        return true;
    }

}
