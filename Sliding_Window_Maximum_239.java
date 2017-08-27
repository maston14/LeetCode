package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ZHONGQI on 2/24/17.
 */
public class Sliding_Window_Maximum_239 {

    public class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if( nums == null || nums.length == 0 || k == 0 ) {
                return new int[0];
            }
            int len = nums.length;
            int[] ans = new int[len - k + 1];
            int idx = 0;

            Deque<Integer> queue = new ArrayDeque<>();

            // At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window.
            for( int i = 0; i < len; i++ ) {
                // remove index out of range k
                while( !queue.isEmpty() && queue.peek() < i - k + 1 ) {
                    queue.poll();
                }
                // remove smaller numbers in k range as they are useless
                while( !queue.isEmpty() && nums[queue.peekLast()] < nums[i] ) {
                    queue.pollLast();
                }

                queue.offer( i );

                if( i >= k - 1) {
                    ans[idx++] = nums[queue.peek()];
                }
            }

            return ans;
        }
    }

    public class Solution_Naive {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] ans = new int[nums.length - k + 1];
            if( nums.length == 0 ) {
                return new int[0];
            }
            for( int i = 0; i <= nums.length - k; i++ ) {
                ans[i] = findMax( nums, i, i + k - 1 );
            }
            return ans;
        }

        public int findMax( int[] nums, int start, int end ) {
            int temp = nums[start];
            for( int i = start; i <= end; i++ ){
                if( nums[i] > temp ) {
                    temp = nums[i];
                }
            }
            return temp;
        }
    }
}
