package LeetCode;

/**
 * Created by YIZHONGQI on 09/11/2016.
 */
public class Closest_Binary_Search_Tree_Value {


    // recursive
    public int closestValue_R( TreeNode root, double target ) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;
        if ( kid == null ) return a;
        int b = closestValue( kid, target );
        return Math.abs( a - target ) < Math.abs( b - target ) ? a : b;
    }

    //concise iterative
    public int closestValue_Improved( TreeNode root, double target ) {
        int ret = root.val;
        while ( root != null ) {
            if ( Math.abs( target - root.val ) < Math.abs( target - ret ) ) {
                ret = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return ret;
    }

    // origin
    public int closestValue( TreeNode root, double target ) {
        TreeNode p = root;
        double closest = root.val;
        while ( p != null ) {
            double cur = p.val;
            closest = Math.abs( cur - target ) < Math.abs( closest - target ) ? cur : closest;
            if ( cur > target ) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (int) closest;
    }

}
