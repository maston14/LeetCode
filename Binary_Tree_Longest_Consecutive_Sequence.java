package LeetCode;

/**
 * Created by YIZHONGQI on 09/11/2016.
 */
public class Binary_Tree_Longest_Consecutive_Sequence {


    // without global variable
    public int longestConsecutive_NoGlobalVar(TreeNode root) {
        if(root == null)
            return 0;
        else
            return Math.max(helper(root.left, 1, root.val+1), helper(root.right, 1, root.val+1));

    }
    public int helper(TreeNode root, int cur, int target){
        if(root == null)
            return cur;
        if(root.val == target)
            cur++;
        else
            cur = 1;
        int l = helper(root.left, cur, root.val+1);
        int r = helper(root.right, cur, root.val+1);
        return Math.max(Math.max(l,r),cur);
    }


    // with void return recursive
    int max1 = 1;
    public int longestConsecutive1(TreeNode root) {
        if(root == null)
            return 0;
        helper1(root,0,root.val+1);
        return max;

    }
    public void helper1(TreeNode root, int cur, int target){
        if(root == null)
            return;
        if(root.val == target)
            cur++;
        else
            cur = 1;
        max1 = Math.max(cur, max1);
        helper1(root.left, cur, root.val+1);
        helper1(root.right, cur, root.val+1);

    }

    // origin
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        helper(root);
        return max;

    }
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int left = 1;
        int right = 1;

        if(root.left != null && root.left.val == root.val + 1)
            left = helper(root.left) + 1;
        else
            helper(root.left);

        if(root.right != null && root.right.val == root.val + 1)
            right = helper(root.right) + 1;
        else
            helper(root.right);

        int cur = Math.max(left, right);
        max = Math.max(cur, max);
        return cur;
    }

}
