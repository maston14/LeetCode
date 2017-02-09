package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by YIZHONGQI on 30/01/2017.
 */
public class Binary_Tree_Vertical_Order_Traversal_314 {
    public class Solution {
        public List<List<Integer>> verticalOrder( TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            if( root == null ) {
                return ans;
            }
            // 用 head 和 tail 来记录当前 ans 的头 尾 分别是第几列
            int head = 0, tail = 0;
            ans.add( new ArrayList<Integer>() );
            // 按层序遍历, 用一个position队列记录对应的node是属于哪一列
            Deque<TreeNode> nodes = new LinkedList<>();
            Deque<Integer> position = new LinkedList<>();

            nodes.offer( root );
            position.offer( 0 );

            while( nodes.size() > 0 ) {
                // 先poll出来
                TreeNode cur = nodes.poll();
                int cur_pos = position.poll();

                // 左右子树分别进队列
                if( cur.left != null ) {
                    nodes.offer( cur.left );
                    position.offer( cur_pos - 1 );
                }
                if( cur.right != null ) {
                    nodes.offer( cur.right );
                    position.offer( cur_pos + 1 );
                }

                // 因为是按列, 且层序, 所以 ans 队列是依次向两边扩张, 且head和tail之间必定是连续的
                if( cur_pos < head ) {
                    // 向左扩张
                    List<Integer> list = new ArrayList<>();
                    list.add( cur.val );
                    ans.add( 0, list );
                    // 更新head
                    head = cur_pos;
                }else if( cur_pos > tail ) {
                    // 向右扩张
                    List<Integer> list = new ArrayList<>();
                    list.add( cur.val );
                    ans.add( list );
                    // 更新tail
                    tail = cur_pos;
                }else {
                    // 属于已经出现过的列, 直接根据和head的距离找到相应的列
                    ans.get( cur_pos - head ).add( cur.val );

                }
            }

            return ans;
        }
    }
}
