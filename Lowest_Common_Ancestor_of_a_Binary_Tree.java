package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 11/11/2016.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree {

    // recursive
    public TreeNode lowestCommonAncestor( TreeNode root, TreeNode p, TreeNode q ) {

        if ( root == null || root == p || root == q )
            return root;

        TreeNode left = lowestCommonAncestor( root.left, p, q );
        TreeNode right = lowestCommonAncestor( root.right, p, q );



        return left != null ? left : right;
    }


    // origin, with global var, 先找到一条到p的path,然后从这条path尾开始一个个找,是否是q
    List<TreeNode> path;

    public TreeNode lowestCommonAncestor_Iterative( TreeNode root, TreeNode p, TreeNode q ) {
        if ( root == null ) return null;
        List<TreeNode> temp = new ArrayList<>();
        findPath( temp, root, p );
        path.add( p );
        for ( int i = path.size() - 1; i >= 0; i-- ) {
            TreeNode t = path.get( i );
            if ( findNode( t, q ) )
                return t;
        }
        return null;
    }

    public void findPath( List<TreeNode> temp, TreeNode node, TreeNode target ) {
        if ( node == null )
            return;
        if ( node == target ) {
            path = new ArrayList<>( temp );
            return;
        } else {
            temp.add( node );
            findPath( temp, node.left, target );
            findPath( temp, node.right, target );
            temp.remove( temp.size() - 1 );
        }
    }

    public boolean findNode( TreeNode node, TreeNode target ) {
        if ( node == null )
            return false;
        if ( node == target )
            return true;
        return findNode( node.left, target ) || findNode( node.right, target );
    }

}
