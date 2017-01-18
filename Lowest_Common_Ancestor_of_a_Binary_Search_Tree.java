package LeetCode;

/**
 * Created by YIZHONGQI on 10/11/2016.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    // concise
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = q.val < root.val ? root.left : root.right;
        return root;
    }

}
