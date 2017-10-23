package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Populating_Next_Right_Pointers_in_Each_Node2_117 {

    public void connect(TreeLinkNode root) {
        if ( root == null ) {
            return;
        }
        Deque<TreeLinkNode> cur_queue = new LinkedList<>();
        Deque<TreeLinkNode> next_queue = new LinkedList<>();

        cur_queue.offerLast(root);

        while( !cur_queue.isEmpty() ) {
            TreeLinkNode cur_node = cur_queue.pollFirst();
            if ( cur_node.left != null ) {
                next_queue.offerLast(cur_node.left);
            }
            if ( cur_node.right != null ) {
                next_queue.offerLast(cur_node.right);
            }
            cur_node.next = cur_queue.peekFirst();
            if ( cur_queue.isEmpty() ) {
                Deque<TreeLinkNode> temp = cur_queue;
                cur_queue = next_queue;
                next_queue = temp;
            }
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
