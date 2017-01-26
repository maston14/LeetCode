package LeetCode;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.
 */
public class Reverse_Linked_List2 {

    public ListNode reverseBetween( ListNode head, int m, int n ) {

        ListNode dummy = new ListNode( 0 );

        int step = n - m;
        dummy.next = head;
        ListNode fixed = dummy;

        // 走到要reverse的头上
        while ( m > 1 ) {
            if ( fixed == null )
                return dummy.next;
            fixed = fixed.next;
            m--;
        }

        ListNode cur = fixed.next;
        //每次把一个插到头上
        while ( cur != null && cur.next != null && step > 0 ) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = fixed.next;
            fixed.next = temp;
            step--;
        }
        return dummy.next;
    }

}
