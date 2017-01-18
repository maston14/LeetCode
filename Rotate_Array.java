package LeetCode;

/**
 * Created by YIZHONGQI on 06/11/2016.
 */
public class Rotate_Array {

    //O(1) space
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        // 全部reverse
        reverse(nums,0,len-1);

        // 把前后两部分再分别正置回来
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }

    public void reverse(int[] nums, int start, int end){

        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }

    }

}
