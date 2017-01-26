package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Created by YIZHONGQI on 24/12/2016.
 */
public class Flatten_Nested_List_Iterator {


    // 每次把栈顶的list元素倒叙入栈
    public class NestedIterator implements Iterator<Integer> {

        Deque<NestedInteger> stack;

        public NestedIterator( List<NestedInteger> nestedList ) {
            stack = new ArrayDeque<>();
            for ( int i = nestedList.size() - 1; i >= 0; i-- )
                stack.push( nestedList.get( i ) );
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while ( stack.size() > 0 ) {
                NestedInteger tmp = stack.peek();
                if ( tmp.isInteger() ) {
                    return true;
                }
                tmp = stack.pop();
                List<NestedInteger> tmpList = tmp.getList();
                for ( int i = tmpList.size() - 1; i >= 0; i-- )
                    stack.push( tmpList.get( i ) );
            }
            return false;
        }
    }
}
