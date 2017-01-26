package LeetCode;

/**
 * Created by YIZHONGQI on 21/11/2016.
 */
public class Plus_One_LinkedList {


    /*
    因为是+1, 所以目标是找9.
    找到不是9的最低的位置,这样所有的进位都在这位之前
     */
    public class Solution {
        public ListNode plusOne( ListNode head ) {
            ListNode dummy = new ListNode( 0 );
            dummy.next = head;
            ListNode p = dummy.next;
            ListNode lastNon9 = dummy;

            // 找到最低的不为9的一位
            while ( p != null ) {
                if ( p.val != 9 )
                    lastNon9 = p;
                p = p.next;
            }

            lastNon9.val++;
            while ( lastNon9.next != null ) {
                lastNon9 = lastNon9.next;
                lastNon9.val = 0;
            }
            if ( dummy.val == 0 ) return dummy.next;
            else return dummy;
        }
    }
}
