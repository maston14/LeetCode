package LeetCode;

/**
 * Created by YIZHONGQI on 14/12/2016.
 */
public class Rotate_List {

    /*
    Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
     */


    // 搞成一个cycle, 找地方断开
    public class Solution_Cycle {
        public ListNode rotateRight( ListNode head, int k ) {
            if ( head == null )
                return head;

            int len = 1;
            ListNode p = head;
            while ( p.next != null ) {
                p = p.next;
                len++;
            }
            p.next = head;

            k = k % len;

            int step = len - k;
            p = head;
            while ( step > 1 ) {
                p = p.next;
                step--;
            }
            ListNode nh = p.next;
            p.next = null;
            return nh;

        }
    }


    // 找三个位置, 然后重新插, 代码繁琐
    public class Solution_Origin {
        public ListNode rotateRight( ListNode head, int k ) {
            if ( head == null )
                return head;
            int len = 1;
            ListNode tail = head;
            // 找原来的尾部
            while ( tail.next != null ) {
                len++;
                tail = tail.next;
            }
            // 要用 %len
            k = k % len;
            ListNode nh = head;
            if ( k > 0 ) {
                // 找到要插得位置
                int step = len - k;
                ListNode newEnd = head;
                while ( step > 1 ) {
                    newEnd = newEnd.next;
                    step--;
                }

                nh = newEnd.next;
                newEnd.next = null;
                tail.next = head;

            }
            return nh;
        }
    }
}
