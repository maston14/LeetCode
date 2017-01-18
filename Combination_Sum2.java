package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YIZHONGQI on 06/11/2016.
 */
public class Combination_Sum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combSum_recursion(res,list,candidates,target,0);
        return res;
    }

    private void combSum_recursion(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){

        if(target == 0){
            res.add(new ArrayList<Integer>(list));
        }else if(target > 0){
            for(int i = start; i < candidates.length;i++){
                if( i != start && candidates[i] == candidates[i-1]) //去掉重复的组合
                    continue;
                if( candidates[i] <= target){
                    list.add(candidates[i]);
                    combSum_recursion(res,list,candidates,target-candidates[i],i+1);
                    list.remove(list.size()-1); // 回溯
                }
            }
        }
    }

}
