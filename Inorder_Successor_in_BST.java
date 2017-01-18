package LeetCode;

/**
 * Created by YIZHONGQI on 19/11/2016.
 */
public class Inorder_Successor_in_BST {

    // recursion
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

         if( p!= null && p.right != null){
            TreeNode t = p.right;
            while(t.left != null)
                t = t.left;
            return t;
        }
        // if p has no right son
        while (root != null && root.val <= p.val)
            root = root.right;
        if (root == null)
            return null;
        TreeNode left = inorderSuccessor(root.left, p);
        return (left != null && left.val > p.val) ? left : root;
    }



    // iterative
    public TreeNode inorderSuccessor_iterative(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;

        // p有right,successor必在p的right中
        if(p.right != null){
            TreeNode t = p.right;
            while(t.left != null)
                t = t.left;
            return t;
        }
        // p没有right
        TreeNode res = null;

        while(root!=null) {
            if(root.val > p.val) {
                res = root;
                root = root.left;
            }
            else root = root.right;
        }
        return res;
    }
}
