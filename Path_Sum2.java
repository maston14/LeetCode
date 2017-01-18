package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class Path_Sum2 {


    //nicer coding
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        pathSum(root, sum, new ArrayList<Integer>(), res);
        return res;
    }

    void pathSum(TreeNode root, int sum, List<Integer> sol, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        sol.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<Integer>(sol));
        } else {
            pathSum(root.left, sum - root.val, sol, res);
            pathSum(root.right, sum - root.val, sol, res);
        }

        sol.remove(sol.size() - 1);
    }


    // original
    public List<List<Integer>> pathSum_notVeryFast(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return res;
            dfs(root, res, list, sum, 0);
        return res;
    }

    public void dfs(TreeNode node, List<List<Integer>> res, List<Integer> list, int sum, int cur){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            if( sum == cur + node.val){
                list.add(node.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        }else{
            list.add(node.val);
            dfs(node.left, res, list, sum, cur+node.val);
            dfs(node.right, res, list, sum, cur+node.val);
            list.remove(list.size() - 1);
        }
    }


}
