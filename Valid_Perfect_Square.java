package LeetCode;

/**
 * Created by YIZHONGQI on 04/12/2016.
 */
public class Valid_Perfect_Square {


    // 涉及乘法的二分, 记得用long, 注意溢出的问题
    public class Solution {
        public boolean isPerfectSquare( int num ) {
            if ( num == 1 )
                return true;
            long start = 1;
            long end = num / 2;
            while ( start <= end ) {
                long mid = start + ( end - start ) / 2;
                long temp = mid * mid;
                if ( temp == num )
                    return true;
                else if ( temp < num )
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            return false;
        }
    }
}
