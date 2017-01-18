package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 13/01/2017.
 */
public class Pascal_Triangle_118 {

    public class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            if( numRows < 1 )
                return ans;
            List<Integer> first = new ArrayList<>();
            first.add(1);
            ans.add(first);
            for( int i = 1; i < numRows; i++ ) {
                List<Integer> list = new ArrayList<>();
                List<Integer> temp = ans.get( i - 1 );
                list.add(1);
                for( int j = 1; j < i; j++ ){
                    list.add( temp.get( j - 1 ) + temp.get( j ) );
                }
                list.add(1);
                ans.add(list);
            }
            return ans;
        }
    }
}
