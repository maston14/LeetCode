package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 01/12/2016.
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {


    // concise recursive, better
    public class Solution_concise {
        public TreeNode sortedArrayToBST( int[] nums ) {
            if ( nums == null || nums.length == 0 ) {
                return null;
            }
            return getTreeNode( nums, 0, nums.length - 1 );
        }

        private TreeNode getTreeNode( int[] nums, int start, int end ) {
            if ( start > end ) {
                return null;
            }
            int middle = start + ( end - start ) / 2;
            TreeNode node = new TreeNode( nums[middle] );
            node.left = getTreeNode( nums, start, middle - 1 );
            node.right = getTreeNode( nums, middle + 1, end );
            return node;
        }
    }

    // iterative, 用stack模拟递归
    public class Solution {

        public class rangeNode {
            TreeNode node;
            int start;
            int end;

            // 用这个数据结构来代替递归的 st 和 ed
            rangeNode( TreeNode node, int start, int end ) {
                this.node = node;
                this.start = start;
                this.end = end;
            }
        }

        public TreeNode sortedArrayToBST( int[] nums ) {
            if ( nums == null || nums.length == 0 ) {
                return null;
            }

            Deque<rangeNode> stack = new ArrayDeque<>();
            TreeNode root = new TreeNode( 0 );
            rangeNode start_node = new rangeNode( root, 0, nums.length - 1 );
            stack.push( start_node );
            while ( stack.size() > 0 ) {
                rangeNode cur = stack.pop();
                int s = cur.start;
                int e = cur.end;
                int mid = s + ( e - s ) / 2;
                cur.node.val = nums[mid];
                if ( s <= mid - 1 ) {
                    TreeNode l_node = new TreeNode( 0 );
                    cur.node.left = l_node;
                    stack.push( new rangeNode( l_node, s, mid - 1 ) );
                }

                if ( mid + 1 <= e ) {
                    TreeNode r_node = new TreeNode( 0 );
                    cur.node.right = r_node;
                    stack.push( new rangeNode( r_node, mid + 1, e ) );
                }
            }
            return root;
        }
    }


    // origin recursive, not clean
    public class Solution_origin {
        public TreeNode sortedArrayToBST( int[] nums ) {

            return helper( nums, 0, nums.length - 1 );
        }

        public TreeNode helper( int[] nums, int start, int end ) {
            if ( start > end ) return null;
            int mid = start + ( end - start ) / 2;
            TreeNode father = new TreeNode( nums[mid] );

            if ( end - start <= 2 ) {
                if ( start < mid )
                    father.left = new TreeNode( nums[start] );
                if ( mid < end )
                    father.right = new TreeNode( nums[end] );
            } else {

                father.left = helper( nums, start, mid - 1 );

                father.right = helper( nums, mid + 1, end );

            }
            return father;
        }
    }
}
