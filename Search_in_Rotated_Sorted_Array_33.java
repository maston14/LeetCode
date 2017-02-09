package LeetCode;

/**
 * Created by YIZHONGQI on 03/02/2017.
 */
public class Search_in_Rotated_Sorted_Array_33 {


    // 和正常的2分一样搜索, 就是找到 2种 特殊情况, 当 mid < target 要进左边 和 mid > target 要进右边
    public class Solution_Origin {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while( left <= right ) {
                int mid = left + ( right - left ) / 2;

                if( nums[mid] == target ){
                    return mid;
                } else if( nums[mid] < target && nums[mid] < nums[left] && nums[left] <= target ) {
                    right = mid - 1;
                } else if( ( nums[mid] < target) || ( nums[mid] > target && nums[mid] > nums[right] && nums[right] >= target ) ) {
                    left = mid + 1;
                } else if( nums[mid] > target ) {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
