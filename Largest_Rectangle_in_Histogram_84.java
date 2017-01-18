package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 17/01/2017.
 */
public class Largest_Rectangle_in_Histogram_84 {

    public class Solution {
        public int largestRectangleArea(int[] heights) {

            int len = heights.length;
            int ans = 0;
            Deque<Integer> stack = new ArrayDeque<>();

            // 每个元素进一次stack, 注意这里的 i<=n 是为了在遍历完之后可以把还在stack里的再算一遍
            for( int i = 0; i <= len; i++ ) {
                int h = (i == len ? 0 : heights[i]);
                if( stack.size() == 0 || h >= heights[stack.peek()] ) {
                    stack.push(i);
                }else {
                    int tp = stack.pop();
                    // 弹出stack顶之后, 以弹出的 top 和 i 之间的长度作为底, 不包括 top 和 i
                    ans = Math.max( ans, heights[tp] * ( stack.size() == 0 ? i : i - 1 - stack.peek() ) );
                    // 这里的i没有入stack, 所以要 i--, 看下次能不能入栈
                    i--;
                }
            }
            return ans;
        }
    }
}
