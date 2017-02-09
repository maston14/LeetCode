package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class Binary_Tree_Path_257 {

    public class Solution_StringBuilder {
        public List<String> binaryTreePaths( TreeNode root ) {
            List<String> rst = new ArrayList<String>();
            if ( root == null ) return rst;
            StringBuilder sb = new StringBuilder();
            helper( rst, sb, root );
            return rst;
        }

        public void helper( List<String> rst, StringBuilder sb, TreeNode root ) {
            if ( root == null ) return;
            int origin_len = sb.length();
            if ( root.left == null && root.right == null ) {
                sb.append( root.val );
                rst.add( sb.toString() );
                sb.delete( origin_len, sb.length() );
                return;
            }
            sb.append( root.val + "->" );
            helper( rst, sb, root.left );
            helper( rst, sb, root.right );
            sb.delete( origin_len, sb.length() );
            return;

        }
    }

    // nicer code
    public List<String> binaryTreePaths( TreeNode root ) {
        List<String> answer = new ArrayList<String>();
        if ( root != null )
            searchBT( root, "", answer );
        return answer;
    }

    private void searchBT( TreeNode root, String path, List<String> answer ) {
        if ( root.left == null && root.right == null )
            answer.add( path + root.val );

        if ( root.left != null )
            searchBT( root.left, path + root.val + "->", answer );

        if ( root.right != null )
            searchBT( root.right, path + root.val + "->", answer );
    }


    // origin
    public List<String> binaryTreePaths_ugly( TreeNode root ) {
        List<String> res = new ArrayList<>();
        if ( root == null ) return res;
        List<Integer> path = new ArrayList<>();
        //System.out.println(sb.toString());
        dfs( res, path, root );
        return res;
    }

    public void dfs( List<String> res, List<Integer> path, TreeNode node ) {
        if ( node == null )
            return;

        path.add( node.val );

        if ( node.left == null && node.right == null ) {
            StringBuilder sb = new StringBuilder();
            for ( int i : path ) {
                sb.append( i );
                sb.append( "->" );
            }
            int len = sb.length();
            sb.delete( len - 2, len );
            res.add( sb.toString() );
        } else {
            dfs( res, path, node.left );
            dfs( res, path, node.right );
        }
        path.remove( path.size() - 1 );
    }

}
