package LeetCode;

/**
 * Created by YIZHONGQI on 13/11/2016.
 */
public class Count_Complete_Tree_Nodes {


    // Iterative Version
    int height( TreeNode root ) {
        return root == null ? -1 : 1 + height( root.left );
    }

    public int countNodes_Iterative( TreeNode root ) {
        int nodes = 0, h = height( root ); // 得到tree的高度

        while ( root != null ) {
            // 从root开始,先看右子树的最坐下节点的高度,如果是h-1,证明root的左子树,是完全树,加上这些节点
            if ( height( root.right ) == h - 1 ) {
                nodes += 1 << h; // root的左子树的节点个数是 (1 << h) - 1, 再加上root自己,就是 1 << h
                root = root.right;
            } else {
                // 左子树不是完全树,那么,右子树是完全树,加上右子树和root,然后进入左子树
                nodes += 1 << h - 1;
                root = root.left;
            }
            h--;
        }
        return nodes;
    }


    // 改进版, 每次先判断子树是不是complete,是的话直接返回计算的结果,就不用再进这颗子树递归了
    public int countNodes( TreeNode root ) {
        if ( root == null ) return 0;

        TreeNode l = root, r = root;
        int height = 0;
        while ( r != null ) {
            r = r.right;
            l = l.left;
            height++;
        }
        if ( l == null )
            return ( 1 << height ) - 1;

        return 1 + countNodes( root.left ) + countNodes( root.right );
    }

    // basic recursive, 会爆,效率低
    public int countNodes_Naive( TreeNode root ) {
        if ( root == null )
            return 0;
        return 1 + countNodes_Naive( root.left ) + countNodes_Naive( root.right );
    }
}
