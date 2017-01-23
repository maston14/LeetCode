package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 21/01/2017.
 */
public class Sum_Root_to_Leaf_Numbers_129 {


    public class Solution {
        public int sumNumbers(TreeNode root) {
            return sum(root, 0);
        }

        public int sum(TreeNode node, int s){
            if (node == null)
                return 0;

            if (node.right == null && node.left == null)
                return s * 10 + node.val;

            return sum(node.left, s * 10 + node.val) + sum(node.right, s * 10 + node.val);
        }
    }



    public class Solution_Origin {
        public int sumNumbers(TreeNode root) {
            if( root == null )
                return 0;
            List<String> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            helper( root, sb, list );
            int ans = 0;
            for( String s : list ) {
                ans += Integer.valueOf(s);
            }
            return ans;
        }

        public void helper( TreeNode node, StringBuilder sb, List<String> list ) {
            if( node == null )
                return;
            sb.append( node.val );
            if( node != null && node.left == null && node.right == null ) {
                list.add( sb.toString() );
            }else{
                helper( node.left, sb, list );
                helper( node.right, sb, list );
            }
            sb.deleteCharAt( sb.length() - 1 );
            return;
        }
    }
}
