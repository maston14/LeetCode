package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 17/12/2016.
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {


    /*
    1. Keep pushing the nodes from the preorder into a stack
    (and keep making the tree by adding nodes to the left of the previous node) until the top of the stack matches the inorder.
    2.At this point, pop the top of the stack until the top does not equal inorder
    相当于以左下斜着的方向恢复树
     */
    // iterative
    public class Solution_Iterative {
        public TreeNode buildTree( int[] preorder, int[] inorder ) {
            if ( preorder.length == 0 ) return null;
            Deque<TreeNode> stack = new ArrayDeque<>();

            TreeNode root = new TreeNode( preorder[0] ), cur = root;

            for ( int i = 1, j = 0; i < preorder.length; i++ ) {
                // 从preorder开始入栈,直到cur元素等于inorder中j指向的元素
                // 这时说明inorder[j]的左子树的元素的访问完了
                // 此时, i已经指向preorder中inorder[j]的后一个元素, 而cur还指向inorder[j]
                // 这个i指向的元素要么是cur的右子树的,要么是stack中某个节点的右子树的
                if ( cur.val != inorder[j] ) {
                    cur.left = new TreeNode( preorder[i] );
                    stack.push( cur );
                    cur = cur.left;
                } else {
                    j++;
                    // 这时cur时指向 inorder和preorder match的那个元素, 这个元素不在stack中, 且cur元素的左子树访问完了
                    // 这时栈顶元素的cur的父节点, 如果这元素和inorder match了,说明cur没有右子树, 那么弹出cur的父节点,去看cur的父节点有没有右子树
                    // 因为如果cur有右子树, 那么在inorder中, cur的下一个元素是cur的右子树中的元素, 而栈内都是cur的祖辈节点
                    while ( stack.size() > 0 && stack.peek().val == inorder[j] ) {
                        cur = stack.pop();
                        j++;
                    }
                    cur.right = new TreeNode( preorder[i] );
                    cur = cur.right;
                }
            }
            return root;
        }
    }

    // 删掉无用的参数 pend
    public class Solution_Recursive {
        public TreeNode buildTree( int[] preorder, int[] inorder ) {
            return helper( preorder, 0, inorder, 0, inorder.length - 1 );
        }

        public TreeNode helper( int[] preorder, int pstart, int[] inorder, int istart, int iend ) {
            if ( pstart > preorder.length - 1 || istart > iend )
                return null;
            TreeNode root = new TreeNode( preorder[pstart] );
            int r = -1;
            for ( int i = istart; i <= iend; i++ ) {
                if ( inorder[i] == preorder[pstart] )
                    r = i;
            }
            int cut = pstart + ( r - istart );
            root.left = helper( preorder, pstart + 1, inorder, istart, r - 1 );
            root.right = helper( preorder, cut + 1, inorder, r + 1, iend );
            return root;
        }
    }


    // origin, recursive, 有些繁琐
    public class Solution_Origin {
        public TreeNode buildTree( int[] preorder, int[] inorder ) {
            return helper( preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1 );
        }

        public TreeNode helper( int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend ) {
            if ( pstart > pend || istart > iend )
                return null;
            TreeNode root = new TreeNode( preorder[pstart] );
            int r = -1;
            for ( int i = istart; i <= iend; i++ ) {
                if ( inorder[i] == preorder[pstart] )
                    r = i;
            }
            int cut = pstart + ( r - istart );
            root.left = helper( preorder, pstart + 1, cut, inorder, istart, r - 1 );
            root.right = helper( preorder, cut + 1, pend, inorder, r + 1, iend );
            return root;
        }
    }
}
