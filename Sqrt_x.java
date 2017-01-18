package LeetCode;

/**
 * Created by YIZHONGQI on 30/11/2016.
 */
public class Sqrt_x {

    // binary search
    public class Solution_Binary_search1 {
        public int mySqrt(int x) {
            if (0 == x) return 0;
            int left = 1, right = x, ans=0;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (mid <= x / mid) {
                    left = mid + 1;
                    ans = mid;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
    }



    public class Solution_Binary_search2 {
        public int mySqrt(int x) {
            if (x == 0)
                return 0;
            int left = 1, right = x; // 可以把范围缩小到x/2
            while (true) {
                int mid = left + (right - left)/2;
                if ( mid > x/mid ) {
                    right = mid - 1;
                } else {
                    if ( mid + 1 > x/(mid + 1) )
                        return mid;
                    left = mid + 1;
                }
            }
        }
    }

    // O(√n)
    public class Solution_slow {
        public int mySqrt(int x) {
            long t = x;
            long i = 1;
            while( i*i <= x)
                i++;
            return (int)i-1;
        }
    }
}
