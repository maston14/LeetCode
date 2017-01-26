package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 21/11/2016.
 * <p>
 * <p>
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class Binary_Search_Tree_Iterator {


    public class BSTIterator {

        Deque<TreeNode> stack;

        public BSTIterator( TreeNode root ) {
            stack = new ArrayDeque<>();
            pushAll( root );
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return stack.size() > 0;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode temp = stack.pop();
            pushAll( temp.right );
            return temp.val;
        }

        public void pushAll( TreeNode node ) {
            while ( node != null ) {
                stack.push( node );
                node = node.left;
            }
        }
    }
}
