package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class Longest_Absolute_File_Path {
    public static void main(String[] args){
    }

    // use stack
    public int lengthLongestPath(String input) {
        //Stack<Integer> st = new Stack<>();
        Deque<Integer> st = new ArrayDeque<>(); // 用deque而不是stack, stack慢
        int max = 0;
        String[] path = input.split("\\n");
        st.push(0);
        for(String s : path){
            int lev = s.lastIndexOf("\t") + 1; // 以 \t 的个数来判断当前位置
            while(lev+1 < st.size()) st.pop(); // pop到自己的父级层
            int curLen = st.peek() + 1 + s.length() - lev; // 计算当前为止的文件长度
            st.push(curLen);
            if(s.contains(".")) // 如果有 . 证明是文件,计算长度. 每次都是算的 dir/的长度, 所以最后要-1
                max = Math.max(max,curLen-1);
        }
        return max;
    }

}
