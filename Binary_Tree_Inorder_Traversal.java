package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by YIZHONGQI on 19/11/2016.
 */
public class Binary_Tree_Inorder_Traversal {


    // iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode t = root;
        while( t != null || stack.size() > 0){
            // 从root起,一路走左走到底
            while(t != null){
                stack.push(t);
                t = t.left;
            }
            // 从stack pop出来一个并访问,同时进到这个的右,再重复走左到底
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            t = cur.right;
        }
        return ans;
    }
}
