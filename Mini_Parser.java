package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 25/12/2016.
 */
public class Mini_Parser {

    // 写的有点长啊
    public class Solution_Origin {
        public NestedInteger deserialize(String s) {

            NestedInteger ans = new NestedInteger();
            Deque<NestedInteger> stack = new ArrayDeque<>();

            if( s == null || s.equals("") )
                return ans;

            char first = s.charAt(0);
            if( first == '-' || ( first >= '0' && first <= '9') ){
                ans.setInteger( Integer.valueOf( s ) );
                return ans;
            }

            int number = 0;
            int neg = 1;
            boolean end = true;

            char[] ch_a = s.toCharArray();

            for( int i = 0; i < ch_a.length; i++ ) {
                if( ch_a[i] == '[' ){
                    NestedInteger tmp = new NestedInteger();
                    // 如果stack非空, 那么这个NestedInteger肯定是stack顶元素的list中的一个元素
                    if( stack.size() != 0 ){
                        NestedInteger top = stack.peek();
                        top.add(tmp);
                    }
                    stack.push(tmp);
                }else if( ch_a[i] == ']'){
                    if( ch_a[i - 1] >= '0' && ch_a[i - 1] <= '9'){
                        NestedInteger top = stack.peek();
                        top.add( new NestedInteger( neg * number ));
                        neg = 1;
                        number = 0;
                    }
                    ans = stack.pop();
                }else if( ch_a[i] == '-'){
                    neg = -1;
                }else if( ch_a[i] == ',' ){
                    if( ch_a[i - 1] != ']'){
                        NestedInteger top = stack.peek();
                        top.add( new NestedInteger( neg * number ));
                        neg = 1;
                        number = 0;
                    }
                }else{
                    number = number * 10 + ch_a[i] - '0';
                }
            }
            return ans;
        }
    }
}
