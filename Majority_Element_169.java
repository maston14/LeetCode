package LeetCode;

import java.util.Arrays;

/**
 * Created by ZHONGQI on 8/27/17.
 */
public class Majority_Element_169 {

    // Moore's voting. O(n) time, O(1) space
    public int majorityElement(int[] nums) {
        int major = 0;
        int counter = 0;
        for (int i : nums) {
            if(counter == 0 || i == major) {
                counter++;
                major = i;
            } else {
                counter--;
            }
        }
        return major;
    }

    // sort first. nlogn
    public int majorityElement_sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}