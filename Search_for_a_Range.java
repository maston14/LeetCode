package LeetCode;

/**
 * Created by YIZHONGQI on 01/12/2016.
 */
public class Search_for_a_Range {

    // 两次binary search, 找两边
    public class Solution_TwoBinarySearch {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = {-1,-1};
            int start = 0;
            int end = nums.length - 1;
            while(start < end){
                int mid = (start + end)/2; // 这样取中点,每次都偏向左边
                if(nums[mid] < target)
                    start = mid + 1;
                else
                    end = mid;
            }
            if(nums[start] != target)
                return ans;
            ans[0] = start;

            end = nums.length - 1;
            while(start < end){
                int mid = (start + end)/2 + 1; // 这样取中点,每次都偏向右边
                if(nums[mid] > target)
                    end = mid - 1;
                else
                    start = mid;
            }
            ans[1] = start;

            return ans;
        }
    }


    // 一次binary search找到target,然后左右搜边界
    public class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] ans = {-1,-1};
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[mid] == target){
                    int left = mid - 1;
                    int right = mid + 1;
                    while(left >= 0 && nums[left] == target)
                        left--;
                    while(right < nums.length && nums[right] == target)
                        right++;
                    ans[0] = left+1;
                    ans[1] = right - 1;
                    return ans;

                }else if(nums[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            return ans;
        }
    }
}
