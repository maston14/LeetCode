package LeetCode;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class Product_of_Array_Except_Self {

    // O(1) space
    public int[] productExceptSelf_noExtraSpace( int[] nums ) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for ( int i = 1; i < len; i++ ) {
            res[i] = res[i - 1] * nums[i - 1]; // 这个loop, res[i]表示nums[i]左边的乘积
        }
        int right = 1;
        for ( int i = len - 1; i >= 0; i-- ) { // 这个loop,把res[i]右边的再乘上
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }


    // O(N) space
    public int[] productExceptSelf( int[] nums ) {
        int[] res = new int[nums.length];

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int l = 1;
        int r = 1;
        for ( int i = 0; i < nums.length; i++ ) {
            left[i] = l;
            right[nums.length - 1 - i] = r;
            l *= nums[i];
            r *= nums[nums.length - 1 - i];
        }
        for ( int i = 0; i < nums.length; i++ ) {

            res[i] = left[i] * right[i];
        }
        return res;
    }
}
