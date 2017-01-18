package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 06/11/2016.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0, nums.length-1);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int start, int end){
        if(start == end){
            List<Integer> list = new ArrayList<>();
            for(int i : nums)
                list.add(i);
            res.add(list);
        }else{
            for(int i = start; i <= end; i++){
                swap(nums,i,start); // 第一层遍历,每次选一个元素作为开始元素
                dfs(res, nums, start+1, end);
                swap(nums,i,start); // 回溯,遍历好了就把他换回来
            }
        }
    }

    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
