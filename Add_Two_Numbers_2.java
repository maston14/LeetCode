package LeetCode;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Add_Two_Numbers_2 {


    // concise
    public class Solution {
        public ListNode addTwoNumbers( ListNode l1, ListNode l2 ) {
            ListNode prev = new ListNode( 0 );
            ListNode head = prev;
            int carry = 0;
            while ( l1 != null || l2 != null || carry != 0 ) {
                ListNode cur = new ListNode( 0 );
                int sum = ( ( l2 == null ) ? 0 : l2.val ) + ( ( l1 == null ) ? 0 : l1.val ) + carry;
                cur.val = sum % 10;
                carry = sum / 10;
                prev.next = cur;
                prev = cur;

                l1 = ( l1 == null ) ? l1 : l1.next;
                l2 = ( l2 == null ) ? l2 : l2.next;
            }
            return head.next;
        }
    }


    public class Solution_origin {
        public ListNode addTwoNumbers( ListNode l1, ListNode l2 ) {
            if ( l1 == null && l2 == null ) {
                return null;
            } else if ( l1 == null )
                return l2;
            else if ( l2 == null )
                return l1;

            int carry = 0;
            ListNode dummyHead = new ListNode( 0 );
            ListNode p = dummyHead;
            ListNode p1 = l1;
            ListNode p2 = l2;
            while ( p1 != null || p2 != null ) {
                int a = p1 != null ? p1.val : 0;
                int b = p2 != null ? p2.val : 0;
                int v = a + b + carry;
                p.next = new ListNode( v % 10 );
                p = p.next;
                carry = v / 10;
                if ( p1 != null )
                    p1 = p1.next;
                if ( p2 != null )
                    p2 = p2.next;
            }
            if ( carry == 1 )
                p.next = new ListNode( 1 );
            return dummyHead.next;
        }
    }

}
