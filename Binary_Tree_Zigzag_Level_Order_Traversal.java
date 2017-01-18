package LeetCode;

import java.util.*;

/**
 * Created by YIZHONGQI on 11/11/2016.
 */
public class Binary_Tree_Zigzag_Level_Order_Traversal {


    // recursive version && DFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        travel(res, 0, root);
        return res;
    }
    private void travel(List<List<Integer>> res, int level, TreeNode cur) {
        if (cur == null) return;
        if (res.size() <= level) {
            res.add(new LinkedList<Integer>());
        }
        if (level % 2 == 0) {
            res.get(level).add(cur.val);
        }   else {
            res.get(level).add(0, cur.val);
        }
        travel(res, level + 1, cur.left);
        travel(res, level + 1, cur.right);
    }


    // BFS one queue version
    public List<List<Integer>> zigzagLevelOrder_OneQueue(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Boolean flag = true;
        while(!q.isEmpty()){
            LinkedList<Integer> path = new LinkedList<>();
            int levelNums = q.size();

            for(int i = 0; i < levelNums; i++){
                root = q.poll();
                if(flag){
                    path.add(root.val);
                }else{
                    path.addFirst(root.val);
                }

                if(root.left != null)
                    q.offer(root.left);
                if(root.right != null)
                    q.offer(root.right);
            }
            res.add(path);
            flag = !flag;
        }

        return res;
    }


    // BFS 加一个flag判断是否要反插
    public List<List<Integer>> zigzagLevelOrder_TwoQueue(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Deque<TreeNode> curL = new LinkedList<>();
        Deque<TreeNode> nextL = new LinkedList<>();
        Boolean reverse = false;
        curL.offer(root);
        while(curL.size() != 0){
            List<Integer> list = new LinkedList<>(); // 因为后面会不断的add(0,val),这样的插入要用linkedlist

            while(curL.size() != 0){
                TreeNode t = curL.poll();

                if(!reverse)
                    list.add(t.val);
                else
                    list.add(0,t.val);

                if(t.left != null)
                    nextL.offer(t.left);

                if(t.right != null)
                    nextL.offer(t.right);
            }
            reverse = !reverse;

            ans.add(list);
            Deque<TreeNode> temp = curL;
            curL = nextL;
            nextL = temp;
        }
        return ans;
    }


    // 用2个stack实现
    public List<List<Integer>> zigzagLevelOrder_TwoStack(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        Deque<TreeNode> curSt = new ArrayDeque<>();
        Deque<TreeNode> nextSt = new ArrayDeque<>();
        curSt.push(root);
        Boolean r2l = true;
        while(curSt.size() > 0){
            List<Integer> list = new ArrayList<>();
            while(curSt.size()>0){
                TreeNode t = curSt.pop();
                if(r2l){
                    if(t.left != null)nextSt.push(t.left);
                    if(t.right != null)nextSt.push(t.right);
                }else{
                    if(t.right != null)nextSt.push(t.right);
                    if(t.left != null)nextSt.push(t.left);
                }
                list.add(t.val);
            }
            r2l = !r2l;
            result.add(list);

            Deque<TreeNode> temp = curSt;
            curSt = nextSt;
            nextSt = temp;
        }
        return result;
    }

}
