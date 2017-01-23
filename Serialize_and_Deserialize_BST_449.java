package LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 21/01/2017.
 */
public class Serialize_and_Deserialize_BST_449 {
    /*
    可以像leetcode297 那样, 所有的叶子都存成null, 来做, 但BST有更好的性质, 可以减少null空间的浪费
     */

    /*
    serialize的时候直接preorder一下, 不用管null
    deserialize的时候, 把nodes放进一个queue,
        1 先poll一个出来,
        2 然后后面把比这个小的都poll出来,放进一个新队列, 这里面的都是左子树
        3 剩下的nodes就是右子树, 递归调用
     */
    public class Codec {

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preorder( root, sb );
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if( data == null || data.equals( "" ) ) return null;
            String[] nodes = data.split(",");
            Deque<String> queue = new ArrayDeque<>();
            queue.addAll( Arrays.asList( nodes ) );
            return buildTree( queue );
        }

        public void preorder( TreeNode node, StringBuilder sb ) {
            if( node == null )
                return;
            sb.append( node.val + ",");
            preorder( node.left, sb );
            preorder( node.right, sb );
        }

        public TreeNode buildTree( Deque<String> nodes ) {

            if( nodes.size() == 0 )
                return null;

            int cur_val = Integer.valueOf( nodes.poll() );
            TreeNode cur = new TreeNode( cur_val );
            // a new queue for nodes that are smaller than the cur
            Deque<String> left_nodes = new ArrayDeque<>();
            while( nodes.size() > 0 && cur_val > Integer.valueOf( nodes.peek() ) ) {
                left_nodes.offer( nodes.poll() );
            }

            cur.left = buildTree( left_nodes );
            cur.right = buildTree( nodes );

            return cur;
        }
    }
}
