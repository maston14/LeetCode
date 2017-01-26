package LeetCode;

/**
 * Created by YIZHONGQI on 22/01/2017.
 */
public class Partition_List_86 {

    public class Solution {
        public ListNode partition( ListNode head, int x ) {
            if ( head == null || head.next == null ) {
                return head;
            }

            ListNode dummy1 = new ListNode( 0 );
            ListNode dummy2 = new ListNode( 0 );

            ListNode p1 = dummy1, p2 = dummy2, cur = head;

            while ( cur != null ) {
                if ( cur.val < x ) {
                    p1.next = cur;
                    p1 = p1.next;
                } else {
                    p2.next = cur;
                    p2 = p2.next;
                }
                cur = cur.next;
            }

            p1.next = dummy2.next;
            p2.next = null;

            return dummy1.next;
        }
    }
}
