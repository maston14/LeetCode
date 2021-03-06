package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 20/11/2016.
 */
public class Nested_List_Weight_Sum {

    public class NestedInteger {
        public boolean isInteger() {
            return true;
        }

        public Integer getInteger() {
            return 1;
        }

        public List<NestedInteger> getList() {
            List<NestedInteger> list = new ArrayList<NestedInteger>();
            return list;
        }
    }

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return null if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public class Solution {
        public int depthSum( List<NestedInteger> nestedList ) {
            int sum = 0;
            for ( NestedInteger ni : nestedList ) {
                if ( ni.isInteger() )
                    sum += ni.getInteger();
                else
                    sum += getValue( ni, 1 );
            }
            return sum;
        }

        public int getValue( NestedInteger nestedInteger, int level ) {
            int sum = 0;
            if ( nestedInteger.isInteger() ) {
                sum += nestedInteger.getInteger();
            } else {
                level++;
                List<NestedInteger> list = nestedInteger.getList();
                for ( NestedInteger ni : list ) {
                    if ( ni.isInteger() )
                        sum += ni.getInteger() * level;
                    else
                        sum += getValue( ni, level );
                }
            }
            return sum;
        }
    }
}
