package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by YIZHONGQI on 06/11/2016.
 */
public class Subsets {

    //iterative
    public List<List<Integer>> subsets_bit(int[] nums) {
        int max_res = 1 << nums.length; // 比如nums长度为3,那么范围就是000-111

        List<List<Integer>> answer = new LinkedList<>();
        for (int i = 0; i < max_res; i++) {
            List<Integer> subset = new LinkedList<>();
            for (int bit = 0; bit < nums.length; bit++) {
                if ( ( (i >> bit) & 1) == 1)
                    subset.add(nums[bit]);
            }
            answer.add(subset);
        }

        return answer;
    }


    // recursive
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, nums, 0);
        res.add(new ArrayList<Integer>());
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(res,list,nums,i+1);
            list.remove(list.size() - 1);
        }
    }

}
