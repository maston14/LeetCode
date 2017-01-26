package LeetCode;

/**
 * Created by YIZHONGQI on 05/11/2016.
 */
public class Counting_Bits {

    //An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
    //每个偶数n的1的位数,和n/2的是一样的;奇数的位数就是他前面的偶数+1.
    public int[] countBits( int num ) {
        int[] f = new int[num + 1];
        for ( int i = 1; i <= num; i++ ) f[i] = f[i >> 1] + ( i & 1 );
        return f;
    }

    // dp算法,就是找个规律,把数用二进制按位数分,(0,1),(2,3),(4,5,6,7),(8,9,10,11,12,13,14,15)......每个区间都是前面所有区间对应位置+1
    public int[] countBits_naive( int num ) {
        if ( num == 0 ) return new int[]{0};
        if ( num == 1 ) return new int[]{0, 1};

        int[] ans = new int[num + 1];
        ans[0] = 0;
        ans[1] = 1;
        int index = 4;
        for ( int i = 2; i < num + 1; i++ ) {

            if ( i == index ) {
                index = index << 1;
            }
            ans[i] = ans[i - index / 2] + 1;
        }
        return ans;
    }

}
