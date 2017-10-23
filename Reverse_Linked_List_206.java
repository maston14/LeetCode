package LeetCode;

/**
 * Created by YIZHONGQI on 13/12/2016.
 */
public class Reverse_Linked_List_206 {


    //
    public class Solution_NoHelper {
        public ListNode reverseList( ListNode head ) {

            if ( head == null || head.next == null )
                return head;

            ListNode newHead = reverseList( head.next );

            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }


    // recursive
    // 就是每次都变换一对之间的指针方向,然后一直到最后
    public class Solution_Recursive {
        public ListNode reverseList( ListNode head ) {

            return helper( null, head );
        }

        private ListNode helper( ListNode prev, ListNode cur ) {
            if ( cur == null )
                return prev;

            ListNode next = cur.next;
            cur.next = prev;

            return helper( cur, next );
        }
    }


    // 从head开始,把head的后面一个查到头上去
    public class Solution_Insert2Head {
        public ListNode reverseList( ListNode head ) {
            ListNode dummy = new ListNode( 0 );
            dummy.next = head;
            ListNode p = head;
            while ( p != null && p.next != null ) {
                ListNode t = p.next;
                p.next = t.next;
                t.next = dummy.next;
                dummy.next = t;
            }
            return dummy.next;
        }
    }
}
