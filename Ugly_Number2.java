package LeetCode;

/**
 * Created by YIZHONGQI on 13/11/2016.
 */
public class Ugly_Number2 {


    /*
    The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
    because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:

    (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
    (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
    (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
    We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.

    Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.

    Every step we choose the smallest one, and move one step after,including nums with same value.
     */


    public int nthUglyNumber( int n ) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index1 = 0, index2 = 0, index3 = 0;
        for ( int i = 1; i < n; i++ ) {
            int t1 = ugly[index1] * 2;
            int t2 = ugly[index2] * 3;
            int t3 = ugly[index3] * 5;
            int min = Math.min( Math.min( t1, t2 ), t3 );
            ugly[i] = min;
            if ( t1 == min )
                index1++;
            if ( t2 == min )
                index2++;
            if ( t3 == min )
                index3++;
        }
        return ugly[n - 1];
    }


    // more formal expression
    public int nthUglyNumber_Formal( int n ) {
        int[] ugly = new int[n];

        int[] primes = new int[]{2, 3, 5};
        int[] index = new int[3];
        int[] candidate = new int[3];

        for ( int i = 0; i < 3; i++ )
            candidate[i] = primes[i];

        ugly[0] = 1;

        for ( int i = 1; i < n; i++ ) {
            int min = candidate[0];
            for ( int j = 1; j < 3; j++ )
                if ( candidate[j] < min )
                    min = candidate[j];

            ugly[i] = min;

            for ( int j = 0; j < 3; j++ ) {
                if ( candidate[j] == min ) {
                    index[j]++;
                    candidate[j] = primes[j] * ugly[index[j]];
                }

            }
        }
        return ugly[n - 1];
    }

}
