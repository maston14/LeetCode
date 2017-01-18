package LeetCode;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        for(int i = 1, tmax = nums[0], tmin = nums[0];i < nums.length;i++){
            if(nums[i] < 0){
                int temp = tmax;
                tmax = tmin;
                tmin = temp;
            }

            tmax = Math.max(nums[i],tmax*nums[i]);
            tmin = Math.min(nums[i],tmin*nums[i]);

            max = Math.max(tmax,max);
        }
        return max;
    }

}
