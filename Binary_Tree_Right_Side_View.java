package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by YIZHONGQI on 11/11/2016.
 */
public class Binary_Tree_Right_Side_View {

    // divide and conquer
    public List<Integer> rightSideView_dc( TreeNode root ) {
        if ( root == null )
            return new ArrayList<Integer>();

        List<Integer> left = rightSideView_dc( root.left );
        List<Integer> right = rightSideView_dc( root.right );

        List<Integer> res = new ArrayList<Integer>();

        res.add( root.val );

        for ( int i = 0; i < Math.max( left.size(), right.size() ); i++ ) {

            if ( i >= right.size() )
                res.add( left.get( i ) );
            else
                res.add( right.get( i ) );

        }

        return res;
    }


    // recursive, 用层数和list size比较,每层只加一个进去
    public List<Integer> rightSideView( TreeNode root ) {
        List<Integer> result = new ArrayList<Integer>();
        rightView( root, result, 0 );
        return result;
    }

    public void rightView( TreeNode curr, List<Integer> result, int currDepth ) {
        if ( curr == null ) {
            return;
        }
        if ( currDepth == result.size() ) { // 优先遍历右边,每一层只有碰到第一个的时候才会加!!!
            result.add( curr.val );
        }

        rightView( curr.right, result, currDepth + 1 );
        rightView( curr.left, result, currDepth + 1 );

    }

    // naive, 类似于逐层遍历,每次输出最右,非常慢
    public List<Integer> rightSideView_Slow( TreeNode root ) {
        List<Integer> ans = new ArrayList<>();
        if ( root == null )
            return ans;
        Deque<TreeNode> cur = new ArrayDeque<>();
        Deque<TreeNode> next = new ArrayDeque<>();
        cur.offer( root );
        while ( cur.size() > 0 ) {
            int count = 1;
            while ( cur.size() > 0 ) {
                TreeNode t = cur.poll();
                if ( count > 0 ) {
                    ans.add( t.val );
                    count--;
                }
                if ( t.right != null ) next.offer( t.right );
                if ( t.left != null ) next.offer( t.left );
            }
            Deque<TreeNode> t = cur;
            cur = next;
            next = t;
        }
        return ans;
    }

}
