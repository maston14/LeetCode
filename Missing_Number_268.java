package LeetCode;

import java.util.Arrays;

public class Missing_Number_268 {

    public int missingNumber_SumUp(int[] nums) {
        int total = ( nums.length + 0 ) * ( nums.length + 1 ) / 2;
        for ( int i = 0; i < nums.length; i++ ) {
            total -= nums[i];
        }
        return total;
    }

    // O(n) if sorted; otherwise, O(nlogn) for sort
    public int missingNumber_BinarySearh(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums.length;
        while ( l < h ) {
            int mid = ( l + h ) / 2;
            if ( mid == nums[mid] ) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

    public int missingNumber_XOR(int[] nums) {
        int result = 0;
        int i = 0;
        for (; i < nums.length; i++ ) {
            result ^= i ^ nums[i];
        }
        return result ^ i;
    }
}
