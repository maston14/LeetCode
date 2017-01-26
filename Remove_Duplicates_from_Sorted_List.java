package LeetCode;

/**
 * Created by YIZHONGQI on 11/12/2016.
 */
public class Remove_Duplicates_from_Sorted_List {


    // recursive way
    public class Solution_recursive {
        public ListNode deleteDuplicates( ListNode head ) {
            if ( head == null || head.next == null )
                return head;
            head.next = deleteDuplicates( head.next );
            return head.val == head.next.val ? head.next : head;
        }
    }

    // origin
    public class Solution_Origin {
        public ListNode deleteDuplicates( ListNode head ) {
            if ( head == null )
                return head;
            ListNode prev = head;
            ListNode cur = prev.next;
            while ( cur != null ) {
                if ( cur.val == prev.val ) {
                    prev.next = cur.next;
                    cur = prev.next;
                    continue;
                }
                prev = cur;
                cur = cur.next;
            }
            return head;
        }
    }
}
