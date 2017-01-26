package LeetCode;

import java.util.PriorityQueue;

/**
 * Created by YIZHONGQI on 29/11/2016.
 */
public class Kth_Largest_Element_in_a_Array {


    // quick select 跟快排差不多,只是分了一次后,不用两边都搜,搜一边就好,平均是O(n),最坏O(n^2)
    public class Solution_QuickSelect {
        public int findKthLargest( int[] nums, int k ) {
            if ( nums == null || nums.length == 0 ) return Integer.MAX_VALUE;
            return findKthLargest( nums, 0, nums.length - 1, nums.length - k ); // 直接传入要找的index
        }

        public int findKthLargest( int[] nums, int start, int end, int k ) {// quick select: kth smallest
            //if (start > end) return Integer.MAX_VALUE;

            int pivot = nums[end];// Take A[end] as the pivot,
            int left = start;
            for ( int i = start; i < end; i++ ) {
                if ( nums[i] <= pivot ) // Put numbers < pivot to pivot's left
                    swap( nums, left++, i );
            }
            swap( nums, left, end );// Finally, swap A[end] with A[left]

            if ( left == k )// Found kth smallest number
                return nums[left];
            else if ( left < k )// Check right part
                return findKthLargest( nums, left + 1, end, k );
            else // Check left part
                return findKthLargest( nums, start, left - 1, k );
        }

        void swap( int[] A, int i, int j ) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }


    // use heap, O(n*logK)
    public class Solution {
        public int findKthLargest( int[] nums, int k ) {
            PriorityQueue<Integer> pq = new PriorityQueue<>( k );
            for ( int n : nums ) {
                if ( pq.size() < k )
                    pq.offer( n );
                else if ( n > pq.peek() ) {
                    pq.poll();
                    pq.offer( n );
                }
            }
            return pq.peek();
        }
    }
}
