package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 19/01/2017.
 */
public class Serialize_and_Deserialize_Binary_Tree_297 {

    /* 序列化时,前序遍历来序列化, null 用 # 来记录,
      1
     / \
    2  #
   / \
  #  #
    比如 1, 2, #, #, #

    解码时, 用一个 queue
    */
    public class Codec_PreOrder_Recursive {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preorder( root, sb );
            return sb.deleteCharAt( sb.length() - 1 ).toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            Deque<String> queue = new ArrayDeque<>();
            for( String s : nodes ) {
                queue.offer( s );
            }
            return buildTree( queue );
        }

        public void preorder( TreeNode node, StringBuilder sb ) {
            if( node == null ) {
                sb.append("#,");
                return;
            }
            sb.append( node.val + "," );
            preorder( node.left, sb );
            preorder( node.right, sb );
        }

        public TreeNode buildTree( Deque<String> queue ) {
            String cur = queue.poll();
            if( cur.equals("#") ) {
                return null;
            }else{
                TreeNode node = new TreeNode( Integer.valueOf( cur ) );
                node.left = buildTree( queue );
                node.right = buildTree( queue );
                return node;
            }
        }
    }
}
