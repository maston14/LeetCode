package LeetCode;

import java.util.Stack;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Valid_Parentheses {

    public boolean isValid(String s) {

        char[] input = s.toCharArray();

        Stack<Character> st = new Stack<>();
        for(char c : input){
            switch (c) {
                case '(':
                    st.push(c);
                    break;
                case ')':
                    if(!st.empty() && st.peek() == '(')
                        st.pop();
                    else {
                        return false;
                    }
                    break;
                case '{':
                    st.push(c);
                    break;
                case '}':
                    if(!st.empty() && st.peek() == '{')
                        st.pop();
                    else {
                        return false;
                    }
                    break;
                case '[':
                    st.push(c);
                    break;
                case ']':
                    if(!st.empty() && st.peek() == '[')
                        st.pop();
                    else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if(st.empty())
            return true;
        else {
            return false;
        }

    }

}
