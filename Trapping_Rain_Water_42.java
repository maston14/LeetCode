package LeetCode;

/**
 * Created by YIZHONGQI on 16/01/2017.
 */
public class Trapping_Rain_Water_42 {

    public class Solution_Shorter {
        public int trap( int[] height ) {
            if ( height.length < 3 )
                return 0;

            int l = 0, r = height.length - 1;
            int level = 0, water = 0;

            while ( l < r ) {
                // 这里直接比较l r对应的高度, 选矮的, 这里就是lower, 并且把indice往中间移动
                int lower = height[height[l] < height[r] ? l++ : r--];
                /* level 存的是上一轮中较小的那个, 只有当现在更小时, 才能存水
                     比如上一轮是 height[l] 小, 现在已经是 height[l + 1] 了, 只有当 height[l + 1] 比 height[l] 小时, 才能存水
                     如果 height[l + 1] 比 height[r] 大了, 那么 level就会被更新成 height[r]
                */
                level = Math.max( level, lower );
                water += level - lower;
            }
            return water;
        }
    }

    public class Solution {
        public int trap( int[] height ) {
            if ( height.length < 3 )
                return 0;

            int lo = 0, hi = height.length - 1, ans = 0;

            // find the left and right edge which can hold water
            while ( lo < height.length - 1 && height[lo] <= height[lo + 1] ) lo++;
            while ( hi > 0 && height[hi] <= height[hi - 1] ) hi--;

            while ( lo < hi ) {

                int left = height[lo];
                int right = height[hi];

                if ( left <= right ) {
                    // add volum until an edge larger than the left edge
                    while ( lo < hi && left > height[++lo] ) {
                        ans += left - height[lo];
                    }
                } else {
                    // add volum until an edge larger than the right volum
                    while ( lo < hi && height[--hi] < right ) {
                        ans += right - height[hi];
                    }
                }
            }
            return ans;
        }
    }
}
