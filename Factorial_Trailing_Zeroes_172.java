package LeetCode;

/**
 * Created by YIZHONGQI on 22/12/2016.
 */
/*
Given an integer n, return the number of trailing zeroes in n!.
 */
public class Factorial_Trailing_Zeroes_172 {

    // 只要找有 5 和 2 的因子, 因为2很充足, 找5的个数就可以
    // 所以求 n/5, 但是因为比如25, 125, 可以贡献不止一个5, 所以要不断 /5, 直到 n < 5

    public class Solution {
        public int trailingZeroes( int n ) {
            if ( n < 5 ) return 0;
            int sum = 0;
            while ( n > 0 ) {

                sum += n / 5;
                n /= 5;
            }
            return sum;
        }
    }


    public class Solution_Recursive {
        public int trailingZeroes( int n ) {
            return n == 0 ? 0 : n / 5 + trailingZeroes( n / 5 );
        }
    }
}
