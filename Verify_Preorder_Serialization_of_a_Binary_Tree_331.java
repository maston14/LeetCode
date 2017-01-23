package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YIZHONGQI on 18/01/2017.
 */
public class Verify_Preorder_Serialization_of_a_Binary_Tree_331 {


    /*
    因为是前序遍历, 所以 X,#,# 是一个节点带两个叶子
    就是每次碰到 X,#,# 就合并成一个 # 入栈, 如果是一颗树最后应该只剩一个 #
     */
    public class Solution_Stack {
        public boolean isValidSerialization(String preorder) {
            if( preorder == null ) {
                return false;
            }

            String[] nodes = preorder.split(",");
            Deque<String> stack = new ArrayDeque<>();

            for( String s : nodes ) {
                while( s.equals("#") && stack.size() > 0 && stack.peek().equals( s ) ) {
                    stack.pop();
                    if( stack.size() == 0 || stack.peek().equals( "#" ) ) {
                        return false;
                    }
                    stack.pop();
                }
                stack.push(s);
            }

            return  stack.size() == 1 && "#".equals( stack.peek() );
        }
    }


    /*
    这个解法逻辑有点问题
    当把null看成叶子, 这样出度入度就会平衡
    而不是,出度入度平衡, 树的序列化就对了
    In a binary tree, if we consider null as leaves, then
        1. all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
        2. all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
    Suppose we try to build this tree.
    During building, we record the difference between out degree and in degree diff = outdegree - indegree.
    When the next node comes, we then decrease diff by 1, because the node provides an in degree.
    If the node is not null, we increase diff by 2, because it provides two out degrees.
    If a serialization is correct, diff should never be negative and diff will be zero when finished.
     */
    public class Solution_Degree {
        public boolean isValidSerialization(String preorder) {
            String[] nodes = preorder.split(",");

            int diff = 1;
            for (String node: nodes) {
                // 除了root, 每个节点有一个 入度
                if (--diff < 0) return false;
                // 非null的节点有两个 出度
                if (!node.equals("#")) diff += 2;
            }
            return diff == 0;
        }
    }


    // 还是stack的写法, 不是很简洁
    public class Solution_Naive {
        public boolean isValidSerialization(String preorder) {
            String[] nodes = preorder.split(",");
            LinkedList<String> stack = new LinkedList<>();
            for( String s : nodes ) {
                stack.add( s );
                while( stack.size() >= 3
                        && stack.get( stack.size() - 1 ).equals("#")
                        && stack.get( stack.size() - 2 ).equals("#")
                        && !stack.get( stack.size() - 3 ).equals("#") ) {
                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);
                    stack.add("#");
                }
            }
            return  stack.size() == 1 && "#".equals( stack.get( 0 ) );
        }
    }

}
