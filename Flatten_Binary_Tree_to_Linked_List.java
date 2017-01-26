package LeetCode;

/**
 * Created by YIZHONGQI on 13/11/2016.
 */
public class Flatten_Binary_Tree_to_Linked_List {

    // nicer coding style
    public class Solution {
        public void flatten( TreeNode root ) {
            if ( root == null )
                return;

            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = null;

            flatten( left );
            flatten( right );

            // left是flatten后的, 把left放到root.right
            // 然后走到root.right的最后, 接上之前的right
            root.right = left;
            TreeNode cur = root;
            while ( cur.right != null )
                cur = cur.right;
            cur.right = right;
        }
    }


    // 前序遍历,每次先把right存下来,对left进行flatten,然后把root.right = root.left
    // 然后从新的右树走,把旧的right放到新的right的末尾,然后对旧的右树进行flatten
    public void flatten( TreeNode root ) {
        if ( root == null ) return;
        if ( root.left == null && root.right == null ) return;

        TreeNode r = root.right;

        flatten( root.left );

        root.right = root.left;
        root.left = null;

        TreeNode t = root;

        while ( t.right != null )
            t = t.right;

        if ( t != null )
            t.right = r;

        flatten( r );
    }


}
