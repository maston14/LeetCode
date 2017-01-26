package LeetCode;

/**
 * Created by YIZHONGQI on 03/11/2016.
 */
public class Sort_Colors {

    // shorter
    public class Solution {
        public void sortColors( int[] nums ) {
            int red = 0;
            int blue = nums.length - 1;

            for ( int i = 0; i <= blue; i++ ) {

                if ( nums[i] == 0 ) {
                    int temp = nums[red];
                    nums[red++] = nums[i];
                    nums[i] = temp;

                } else if ( nums[i] == 2 ) {
                    int temp = nums[blue];
                    nums[blue--] = nums[i];
                    // 跟blue换完以后, 要推一位, 因为可能换过来的是 0 或者 2, 需要再换一次
                    nums[i--] = temp;
                }
            }
        }
    }


    // 两边指针,origin version
    public void sortColors( int[] nums ) {
        int red = 0;
        int blue = nums.length - 1;
        while ( red < nums.length && nums[red] == 0 )
            red++;
        while ( blue >= 0 && nums[blue] == 2 )
            blue--;
        for ( int i = red; i <= blue; i++ ) {
            if ( nums[i] == 2 ) {
                int temp = nums[blue];
                nums[blue--] = 2;
                nums[i] = temp;
                while ( blue >= 0 && nums[blue] == 2 )
                    blue--;
            }
            if ( nums[i] == 0 ) {
                int temp = nums[red];
                nums[red++] = 0;
                nums[i] = temp;
            }
        }

    }
}
