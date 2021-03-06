package LeetCode;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Ugly_Number {

    public boolean isUgly( int num ) {
        if ( num <= 0 ) return false;
        if ( num == 1 ) return true;
        while ( num % 2 == 0 )
            num = num >> 1;
        while ( num % 3 == 0 )
            num /= 3;
        while ( num % 5 == 0 )
            num /= 5;
        return num == 1;
    }
}
