package LeetCode;

/**
 * Created by YIZHONGQI on 30/12/2016.
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {

    public class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if( head == null ) return null;
            return helper( head, null);
        }
        public TreeNode helper( ListNode head, ListNode tail) {

            ListNode fast = head;
            ListNode slow = head;

            if( head == tail ) return null;

            while( fast != tail && fast.next != tail ){
                fast = fast.next.next;
                slow = slow.next;
            }

            TreeNode root = new TreeNode( slow.val );
            root.left = helper( head, slow );
            root.right = helper( slow.next, tail );

            return root;
        }
    }
}
