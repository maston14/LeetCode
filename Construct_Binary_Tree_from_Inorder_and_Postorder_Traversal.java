package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 18/12/2016.
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    // 跟 preOrder和inOrder的写法一样, 只是遍历从array尾部往前
    // 这样相当于把postOrder和inOrder倒过来, 就是(根,右,左)和(右,根,左), 相当于以右下斜的方向恢复树
    public class Solution_iterative {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0 || postorder.length == 0) return null;

            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

            TreeNode root = new TreeNode(postorder[postorder.length - 1]);
            TreeNode cur = root;
            stack.push(root);

            for( int p = postorder.length - 2, i = inorder.length - 1; p >= 0; p--){
                if( cur.val != inorder[i] ) {
                    cur.right = new TreeNode(postorder[p]);
                    stack.push(cur);
                    cur = cur.right;
                } else {
                    i--;
                    while( stack.size() > 0 && stack.peek().val == inorder[i] ){
                        cur = stack.pop();
                        i--;
                    }
                    cur.left = new TreeNode( postorder[ p ] );
                    cur = cur.left;
                }
            }

            return root;
        }
    }

    // origin, recursive
    public class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
        }

        public TreeNode helper(int[] inorder, int in_start, int in_end, int[] postorder, int p_end){
            if( in_start > in_end || p_end < 0 )
                return null;
            TreeNode root = new TreeNode(postorder[p_end]);
            int r = -1;
            for( int i = in_start; i <= in_end; i++ ){
                if( inorder[i] == postorder[p_end] )
                    r = i;
            }
            root.left = helper(inorder, in_start, r - 1, postorder, p_end - ( in_end - r ) - 1);
            root.right = helper(inorder, r + 1, in_end, postorder, p_end - 1);

            return root;
        }
    }
}
