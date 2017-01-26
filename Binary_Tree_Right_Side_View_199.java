package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by YIZHONGQI on 15/01/2017.
 */
public class Binary_Tree_Right_Side_View_199 {


    // 每个level只取一个, 用result size 和 deoth 来看这层取过没有
    public class Solution {
        public List<Integer> rightSideView( TreeNode root ) {
            List<Integer> result = new ArrayList<Integer>();
            rightView( root, result, 0 );
            return result;
        }

        public void rightView( TreeNode curr, List<Integer> result, int currDepth ) {

            if ( curr == null ) {
                return;
            }
            if ( currDepth == result.size() ) {
                result.add( curr.val );
            }
            // 每次都先right, 这样保证取到的一定是最右
            rightView( curr.right, result, currDepth + 1 );
            rightView( curr.left, result, currDepth + 1 );

        }
    }

    // 按level遍历,每次输出最右边
    public class Solution_LevelTraversal {
        public List<Integer> rightSideView( TreeNode root ) {
            List<Integer> ans = new ArrayList<>();
            if ( root == null )
                return ans;
            Queue<TreeNode> cur = new ArrayDeque<>();
            Queue<TreeNode> next = new ArrayDeque<>();

            cur.offer( root );
            while ( cur.size() > 0 ) {

                while ( cur.size() > 0 ) {

                    TreeNode temp = cur.poll();

                    if ( temp.left != null ) {
                        next.offer( temp.left );
                    }
                    if ( temp.right != null ) {
                        next.offer( temp.right );
                    }

                    if ( cur.size() == 0 ) {
                        ans.add( temp.val );
                    }
                }

                Queue<TreeNode> t = cur;
                cur = next;
                next = t;
            }
            return ans;
        }
    }
}
