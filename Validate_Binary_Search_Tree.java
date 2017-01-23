package LeetCode;

/**
 * Created by YIZHONGQI on 21/11/2016.
 */
public class Validate_Binary_Search_Tree {


    // 把max和min当做参数
    public class Solution1 {
        public boolean isValidBST(TreeNode root) {

            return isValid(root, null, null);
        }

        public boolean isValid(TreeNode root, Integer min, Integer max) {

            if(root == null)
                return true;

            if(min != null && root.val <= min)
                return false;

            if(max != null && root.val >= max)
                return false;

            return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
        }
    }


    // 从根节点开始,找左子树最大的和右子树最小的, 看是不是左最大小于根,右最下大于根
    // 是的话就进入左右子树,做一样的事
    public class Solution2 {
        public boolean isValidBST(TreeNode root) {

            if( root == null )
                return true;

            if( root.left != null ) {
                TreeNode t = root.left;
                while( t.right != null )
                    t = t.right;
                if( t.val >= root.val )
                    return false;
            }
            if( root.right != null ){
                TreeNode t = root.right;
                while( t.left != null )
                    t = t.left;
                if( t.val <= root.val )
                    return false;
            }
            return isValidBST( root.left ) && isValidBST( root.right );
        }
    }
}
