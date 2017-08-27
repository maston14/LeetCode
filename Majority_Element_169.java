package LeetCode;

import java.util.Arrays;

/**
 * Created by ZHONGQI on 8/27/17.
 */
public class Majority_Element_169 {
    // sort first. nlogn
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}