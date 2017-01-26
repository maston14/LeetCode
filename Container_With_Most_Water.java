package LeetCode;

/**
 * Created by YIZHONGQI on 04/11/2016.
 */
public class Container_With_Most_Water {


    public class Solution {
        public int maxArea( int[] height ) {
            if ( height == null || height.length == 0 ) return 0;
            int lo = 0, hi = height.length - 1;
            int max = 0;
            // 从两头开始,因为这时gap最大
            while ( lo < hi ) {
                int lo_h = height[lo];
                int hi_h = height[hi];
                max = Math.max( max, Math.min( lo_h, hi_h ) * ( hi - lo ) );
                // 选择两端中高度较小的, 向中间移动, 跳过比较小的还矮的, 因为gap小了,高度还小了, 不可能会有maxArea, 直到碰到一个比较小的高度高的时候
                if ( lo_h <= hi_h ) {
                    while ( lo < hi && height[++lo] <= lo_h ) ;
                } else {
                    while ( lo < hi && height[--hi] <= hi_h ) ;
                }
            }
            return max;
        }
    }


    // revised, 每次算一个最大值之后,尽可能的往中间移动
    public int maxArea_fast( int[] height ) {
        if ( height == null || height.length == 0 ) return 0;
        int head = 0;
        int tail = height.length - 1;
        int max = Math.min( height[head], height[tail] ) * ( tail - head );
        while ( head < tail ) {
            int lomax = height[head];
            int himax = height[tail];
            int real_h = lomax < himax ? lomax : himax;
            max = Math.max( max, real_h * ( tail - head ) );
            if ( height[head] < height[tail] ) {
                while ( head < tail && height[head] <= lomax )
                    head++;
            } else {
                while ( head < tail && height[tail] <= himax )
                    tail--;
            }
        }
        return max;
    }


    // origin
    public int maxArea_Origin( int[] height ) {
        if ( height == null || height.length == 0 ) return 0;
        int head = 0;
        int tail = height.length - 1;
        int max = Math.min( height[head], height[tail] ) * ( tail - head );
        while ( head < tail ) {
            if ( height[head] < height[tail] ) {
                head++;
                if ( height[head] < height[head - 1] ) {
                    continue;
                } else if ( head < tail ) {
                    max = Math.max( max, Math.min( height[head], height[tail] ) * ( tail - head ) );
                }
            } else {
                tail--;
                if ( height[tail] < height[tail + 1] ) {
                    continue;
                } else if ( head < tail ) {
                    max = Math.max( max, Math.min( height[head], height[tail] ) * ( tail - head ) );
                }
            }
        }
        return max;
    }

}
