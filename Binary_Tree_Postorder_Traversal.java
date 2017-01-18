package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by YIZHONGQI on 19/11/2016.
 */
public class Binary_Tree_Postorder_Traversal {


    /* one stack
    我们使用prev变量跟踪上一次访问的节点。假设栈顶元素是curr。
    1.当prev是curr的父节点时，
        我们正在向下遍历树。
        此时，优先遍历curr的左孩子（将左孩子压入栈）。
        如果没有左孩子，再看右孩子。
        如果左右孩子都不存在（curr是叶节点），就输出curr的值并弹出栈顶元素。
    2.如果prev是curr的左孩子，
        我们正在从左子树向上遍历。
        我们看一下curr的右孩子。
        如果可以，就从右孩子向下遍历（将右孩子压入栈），否则打印curr的值并弹出栈顶元素。
    3.如果prev是curr的右孩子，
        我们正在从右子树向上遍历。打印curr的值并弹出栈顶元素。
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            Deque<TreeNode> st = new ArrayDeque<>();
            TreeNode prev = null;
            st.push(root);
            while(st.size() > 0){
                TreeNode cur = st.peek();
                if( prev == null || prev.left == cur || prev.right == cur){
                    if(cur.left != null)
                        st.push(cur.left);
                    else if(cur.right != null)
                        st.push(cur.right);
                    else
                        list.add(st.pop().val);
                }else if(cur.left == prev){
                    if(cur.right != null)
                        st.push(cur.right);
                    else
                        list.add(st.pop().val);
                }else if(cur.right == prev){
                    list.add(st.pop().val);
                }
                prev = cur;
            }
        }
        return list;
    }





    /* two stacks
    设置两个栈stk, stk2；
    将根结点压入第一个栈stk；
    弹出stk栈顶的结点，并把该结点压入第二个栈stk2；
    将当前结点的左孩子和右孩子先后分别入栈stk；
    当所有元素都压入stk2后，依次弹出stk2的栈顶结点，并访问之。
    第一个栈的入栈顺序是：根结点，左孩子和右孩子；于是，压入第二个栈的顺序是：根结点，右孩子和左孩子。因此，弹出的顺序就是：左孩子，右孩子和根结点。
    */
    public List<Integer> postorderTraversal_twoStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null){
            Deque<TreeNode> st1 = new ArrayDeque<>();
            Deque<TreeNode> st2 = new ArrayDeque<>();
            st1.push(root);
            while(st1.size() > 0){
                TreeNode t = st1.pop();
                st2.push(t);
                if(t.left != null)
                    st1.push(t.left);
                if(t.right != null)
                    st1.push(t.right);
            }
            while(st2.size() > 0){
                list.add(st2.pop().val);
            }
        }
        return list;
    }
}
