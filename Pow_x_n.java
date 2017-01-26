package LeetCode;

/**
 * Created by YIZHONGQI on 30/11/2016.
 */
public class Pow_x_n {

    // 主要考虑n正负的情况,同时用divide and conquer,可以算到log(n)

    public class Solution {
        public double myPow( double x, int n ) {

            if ( n < 0 ) return 1 / x * myPow( 1 / x, -( n + 1 ) );

            if ( n == 0 ) return 1;
            if ( n == 2 ) return x * x;

            if ( n % 2 == 0 )
                return myPow( myPow( x, n / 2 ), 2 );
            else
                return x * myPow( myPow( x, n / 2 ), 2 );
        }
    }

    public class Solution2 {
        public double myPow( double x, int n ) {

            if ( n == 0 ) return 1;
            double t = myPow( x, n / 2 );

            if ( n % 2 != 0 ) {
                return n > 0 ? x * t * t : ( 1 / x ) * t * t;
            } else {
                return t * t;
            }
        }
    }

    public class Solution3 {
        public double myPow( double x, int n ) {
            if ( n == 0 ) return 1;
            if ( n < 0 ) {
                n = -n;
                x = 1 / x;
            }
            return n % 2 == 0 ? myPow( x * x, n / 2 ) : x * myPow( x * x, n / 2 );
        }
    }
}
