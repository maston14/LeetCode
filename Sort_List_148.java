package LeetCode;

/**
 * Created by YIZHONGQI on 22/01/2017.
 */
public class Sort_List_148 {


    public class Solution_MergeSort {
        public ListNode sortList( ListNode head ) {
            if ( head == null || head.next == null )
                return head;
            // 把list分成两段
            ListNode prev = null, slow = head, fast = head;

            // prev指向slow前面的node, 最后把原list分成以 head 开头和以 slow 开头的两个list
            while ( fast != null && fast.next != null ) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = null;

            ListNode l1 = sortList( head );
            ListNode l2 = sortList( slow );

            return merge( l1, l2 );
        }

        public ListNode merge( ListNode head1, ListNode head2 ) {
            ListNode dummy = new ListNode( 0 );
            ListNode p = dummy;

            while ( head1 != null && head2 != null ) {
                if ( head1.val <= head2.val ) {
                    p.next = head1;
                    head1 = head1.next;
                } else {
                    p.next = head2;
                    head2 = head2.next;
                }
                p = p.next;
            }

            if ( head1 != null ) {
                p.next = head1;
            }
            if ( head2 != null ) {
                p.next = head2;
            }
            return dummy.next;
        }
    }


    public class Solution_QuickSort {
        public ListNode sortList( ListNode head ) {
            if ( head == null || head.next == null )
                return head;
            // 不能分两段, 得分成3段, 小 等 大
            ListNode less = new ListNode( 0 ), p_less = less;
            ListNode equal = new ListNode( 0 ), p_equal = equal;
            ListNode greater = new ListNode( 0 ), p_greater = greater;

            ListNode cur = head;
            int pivot = head.val;

            while ( cur != null ) {
                if ( cur.val < pivot ) {
                    p_less.next = cur;
                    p_less = p_less.next;
                } else if ( cur.val == pivot ) {
                    p_equal.next = cur;
                    p_equal = p_equal.next;
                } else {
                    p_greater.next = cur;
                    p_greater = p_greater.next;
                }
                cur = cur.next;
            }
            // end the list with null
            p_less.next = p_equal.next = p_greater.next = null;

            // 这里 equal的list就不用再sort了, 直接merge
            return merge( merge( sortList( less.next ), sortList( greater.next ) ), equal.next );
        }

        public ListNode merge( ListNode head1, ListNode head2 ) {
            ListNode dummy = new ListNode( 0 );
            ListNode p = dummy;

            while ( head1 != null && head2 != null ) {
                if ( head1.val <= head2.val ) {
                    p.next = head1;
                    head1 = head1.next;
                } else {
                    p.next = head2;
                    head2 = head2.next;
                }
                p = p.next;
            }

            if ( head1 != null ) {
                p.next = head1;
            }
            if ( head2 != null ) {
                p.next = head2;
            }
            return dummy.next;
        }
    }
}
