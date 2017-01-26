package LeetCode;

/**
 * Created by YIZHONGQI on 03/11/2016.
 */
public class Insertion_Sort_List {

    public ListNode insertionSortList( ListNode head ) {
        if ( head == null ) return head;
        ListNode dummyHead = new ListNode( 0 );
        dummyHead.next = head;
        ListNode p = head;
        ListNode iter = dummyHead;
        while ( p.next != null ) {
            if ( p.val > p.next.val ) {
                while ( iter != p && p.next.val >= iter.next.val ) {
                    iter = iter.next;
                }
                ListNode temp = p.next;
                p.next = p.next.next;
                temp.next = iter.next;
                iter.next = temp;

                iter = dummyHead;
            } else
                p = p.next;
        }
        return dummyHead.next;
    }


    // origin verison
    public ListNode insertionSortList_slow( ListNode head ) {
        if ( head == null ) return head;
        ListNode dummyHead = new ListNode( 0 );
        dummyHead.next = head;
        ListNode p = head;
        ListNode iter = dummyHead;
        while ( p.next != null ) {
            while ( iter != p && p.next.val > iter.next.val ) {
                iter = iter.next;
            }
            if ( iter == p ) {
                p = p.next;
            } else {
                ListNode temp = p.next;
                p.next = p.next.next;
                temp.next = iter.next;
                iter.next = temp;
            }
            iter = dummyHead;
        }
        return dummyHead.next;
    }
}
