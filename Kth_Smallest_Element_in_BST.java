package LeetCode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 12/12/2016.
 */
public class Kth_Smallest_Element_in_BST {

    // 从root起,每次看left子树中的节点个数; 如果可以改node, 就是在每个node中加入其左子树的节点个数
    public class Solution_BST {
        public int kthSmallest(TreeNode root, int k) {
            int left_num = count(root.left);

            if(left_num == k - 1)
                return root.val;
            else if(left_num > k - 1){
                return kthSmallest(root.left, k);
            }else {
                return kthSmallest(root.right, k - left_num - 1);
            }

        }

        public int count(TreeNode node){
            if( node == null)
                return 0;
            return 1 + count(node.left) + count(node.right);
        }
    }




    public class Solution_Inorder {
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode t = root;
            int count = 0;
            while( t != null || stack.size() > 0) {
                while( t != null){
                    stack.push(t);
                    t = t.left;
                }
                TreeNode cur = stack.pop();
                count++;
                if(count == k)
                    return cur.val;
                t = cur.right;
            }
            return -1;
        }
    }

}
