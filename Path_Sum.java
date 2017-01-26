package LeetCode;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class Path_Sum {

    public boolean hasPathSum( TreeNode root, int sum ) {
        if ( root == null ) return false;
        sum -= root.val;
        if ( root.left == null && root.right == null && sum == 0 )
            return true;
        else {
            return hasPathSum( root.left, sum ) || hasPathSum( root.right, sum );
        }
    }

}
