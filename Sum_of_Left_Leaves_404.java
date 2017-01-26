package LeetCode;

/**
 * Created by YIZHONGQI on 12/01/2017.
 */
public class Sum_of_Left_Leaves_404 {

    public class Solution {
        public int sumOfLeftLeaves( TreeNode root ) {
            if ( root == null ) return 0;
            int ans = 0;
            if ( root.left != null ) {
                if ( root.left.left == null && root.left.right == null ) ans += root.left.val;
                else ans += sumOfLeftLeaves( root.left );
            }
            ans += sumOfLeftLeaves( root.right );

            return ans;
        }
    }


    public class Solution_Origin {
        public int sumOfLeftLeaves( TreeNode root ) {
            if ( root == null || ( root.left == null && root.right == null ) )
                return 0;
            return helper( root, null );
        }

        public int helper( TreeNode node, TreeNode father ) {
            if ( node == null )
                return 0;
            if ( father != null && node != null && father.left == node && node.left == null && node.right == null )
                return node.val;
            return helper( node.left, node ) + helper( node.right, node );
        }
    }
}
