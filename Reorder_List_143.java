package LeetCode;

/**
 * Created by YIZHONGQI on 25/01/2017.
 */
public class Reorder_List_143 {


    // 先把链表对半拆, 然后后半部分倒转一下, 然后把后半部分一个个插到前半部分中间
    public class Solution_Origin {
        public void reorderList(ListNode head) {
            if( head == null || head.next == null || head.next.next == null )
                return;

            ListNode slow = head, fast = head;

            while( fast != null && fast.next != null ) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 把链表切成
            ListNode secondHalfHead = slow.next;
            slow.next = null;

            secondHalfHead = reverse( secondHalfHead );

            boolean flag = true;
            ListNode p = head;
            while( p != null && secondHalfHead != null ) {
                ListNode temp = secondHalfHead;

                ListNode next = p.next;
                secondHalfHead = secondHalfHead.next;

                temp.next = p.next;
                p.next = temp;

                p = next;
            }
        }

        public ListNode reverse( ListNode head ) {
            if( head == null ){
                return head;
            }
            ListNode dummy = new ListNode( 0 );
            dummy.next = head;
            ListNode fix = head, cur = head.next;

            while( cur != null ) {
                ListNode temp = cur;
                fix.next = cur.next;
                cur = fix.next;

                temp.next = dummy.next;
                dummy.next = temp;
            }

            return dummy.next;
        }
    }
}
