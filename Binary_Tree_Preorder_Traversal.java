package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by YIZHONGQI on 19/11/2016.
 */
public class Binary_Tree_Preorder_Traversal {


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        if(root != null)
            stack.push(root);

        while( stack.size() > 0){
            TreeNode t = stack.pop();
            list.add(t.val);
            // 先推右儿子
            if(t.right != null)
                stack.push(t.right);
            // 再推左儿子
            if(t.left != null)
                stack.push(t.left);
        }

        return list;
    }
}
