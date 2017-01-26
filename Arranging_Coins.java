package LeetCode;

/**
 * Created by YIZHONGQI on 02/12/2016.
 */
public class Arranging_Coins {


    // 一元二次方程的通解
    public class Solution_Math {
        public int arrangeCoins( int n ) {
            return (int) ( ( -1 + Math.sqrt( 1 + 8 * (long) n ) ) / 2 );
        }
    }

    // binary search
    public class Solution_better {
        public int arrangeCoins( int n ) {
            //convert int to long to prevent integer overflow
            long nLong = (long) n;

            long st = 0;
            long ed = nLong;

            long mid = 0;

            while ( st <= ed ) {
                mid = st + ( ed - st ) / 2;

                if ( mid * ( mid + 1 ) <= 2 * nLong ) {
                    st = mid + 1;
                } else {
                    ed = mid - 1;
                }
            }

            return (int) ( st - 1 );
        }
    }


    // origin, 判断条件写的有点啰嗦
    public class Solution {
        public int arrangeCoins( int n ) {

            long target = n;
            long start = 1;
            long end = n / 2 + 1;

            while ( start <= end ) {
                long mid = start + ( end - start ) / 2;


                long judge = mid * ( mid + 1 ) / 2;

                if ( judge == target || ( judge < target && ( mid + 1 ) * ( mid + 2 ) / 2 > target ) )
                    return (int) mid;
                else if ( judge < target )
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            return 0;
        }
    }
}
