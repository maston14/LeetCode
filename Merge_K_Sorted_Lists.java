package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by YIZHONGQI on 04/11/2016.
 */
public class Merge_K_Sorted_Lists {

    //use mergesort
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end){
            int mid = start + (end - start) / 2; //这样分,偶数的时候可以均分
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);
            return new Merge_Two_Sorted_List().mergeTwoLists(left, right); // 在Merge_Two_Sorted_List里
        } else {
            return null;
        }
    }


    // with PriorityQueue
    public ListNode mergeKLists_pq(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        ListNode ansHead = null;
        ListNode p = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
                new Comparator<ListNode>(){
                    public int compare(ListNode a, ListNode b){
                        return a.val - b.val;
                    }
                }
        );
        for(ListNode node : lists){
            if(node != null)
                pq.offer(node);
        }

        while(pq.size() > 0){
            ListNode hnode = pq.poll();
            if(hnode.next != null)
                pq.offer(hnode.next);

            if(ansHead == null){
                ansHead = hnode;
                p = ansHead;
            }else{
                p.next = hnode;
                p = p.next;
            }
        }

        if(p != null)
            p.next = null;
        return ansHead;

    }

}
