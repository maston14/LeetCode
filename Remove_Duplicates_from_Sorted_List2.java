package LeetCode;

/**
 * Created by YIZHONGQI on 11/12/2016.
 */
public class Remove_Duplicates_from_Sorted_List2 {


    // 2个pointer
    public class Solution_Shorter {
        public ListNode deleteDuplicates( ListNode head ) {
            if ( head == null )
                return head;

            ListNode dummy = new ListNode( 0 );
            dummy.next = head;

            ListNode prev = dummy;
            ListNode cur = dummy.next;

            while ( cur != null ) {
                while ( cur.next != null && cur.val == cur.next.val )
                    cur = cur.next;

                if ( prev.next == cur )
                    prev = cur;
                else
                    prev.next = cur.next;

                cur = cur.next;
            }
            return dummy.next;
        }
    }


    // 3个pointer
    public class Solution_Origin {
        public ListNode deleteDuplicates( ListNode head ) {
            if ( head == null )
                return head;

            ListNode dummy = new ListNode( 0 );
            dummy.next = head;

            ListNode prev = dummy;
            ListNode start = dummy.next;
            ListNode end = start.next;

            while ( start != null && end != null ) {
                if ( start.val != end.val ) {
                    prev = start;
                    start = end;
                    end = end.next;
                } else {
                    while ( end != null && end.val == start.val ) {
                        end = end.next;
                    }
                    if ( end == null )
                        prev.next = null;
                    else {
                        prev.next = end;
                        start = end;
                        end = end.next;
                    }

                }
            }
            return dummy.next;
        }
    }
}
