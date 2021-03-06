package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Valid_Parentheses_20 {

    public class Solution_Short {
        public boolean isValid( String s ) {
            if ( s == null || s.length() == 0 ) return true;
            Deque<Character> stack = new ArrayDeque<>();

            for( int i = 0; i < s.length(); i++ ) {
                char cur = s.charAt( i );
                if( !stack.isEmpty() && ( cur - stack.peek() == 1 || cur - stack.peek() == 2 ) ) {
                    stack.pop();
                }else {
                    stack.push( cur );
                }
            }
            // return true if no open parentheses left in stack
            return stack.isEmpty();
        }
    }

    public class Solution {
        public boolean isValid( String s ) {
            Deque<Character> stack = new LinkedList<>();
            // Iterate through string until empty
            for ( int i = 0; i < s.length(); i++ ) {
                // Push any open parentheses onto stack
                if ( s.charAt( i ) == '(' || s.charAt( i ) == '[' || s.charAt( i ) == '{' )
                    stack.push( s.charAt( i ) );
                    // Check stack for corresponding closing parentheses, false if not valid
                else if ( s.charAt( i ) == ')' && stack.size() > 0 && stack.peek() == '(' )
                    stack.pop();
                else if ( s.charAt( i ) == ']' && stack.size() > 0 && stack.peek() == '[' )
                    stack.pop();
                else if ( s.charAt( i ) == '}' && stack.size() > 0 && stack.peek() == '{' )
                    stack.pop();
                else
                    return false;
            }
            // return true if no open parentheses left in stack
            return stack.size() == 0;
        }
    }

}
