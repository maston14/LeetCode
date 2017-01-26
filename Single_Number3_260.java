package LeetCode;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Single_Number3_260 {

    /*
    Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
    Find the two elements that appear only once.
     */

    public int[] singleNumber( int[] nums ) {
        int num1 = 0;
        int num2 = 0;
        int xor = 0;

        // 整个数组都 xor 一下
        for ( int i : nums ) {
            xor ^= i;
        }

        // 因为有两个数是唯一的, 其他都是成对的, 所以全部 xor 的结果, 一定不为0, 肯定有某一位是 1, 而这个 1 是两个数中某个数特有的
        // 用这一位, 去分开两个数
        int unique = xor & ~( xor - 1 );

        for ( int i : nums ) {
            if ( ( i & unique ) == 0 ) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        return new int[]{num1, num2};

    }

}
