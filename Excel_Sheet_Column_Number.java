package LeetCode;

/**
 * Created by YIZHONGQI on 21/12/2016.
 */
public class Excel_Sheet_Column_Number {

    public class Solution {
        public int titleToNumber(String s) {
            char[] ch_a = s.toCharArray();
            int index = 1;
            int sum = 0;
            for( int i = ch_a.length - 1; i >= 0; i-- ){
                sum += ( ch_a[i] - 'A' + 1 ) * index;
                index *= 26;
            }
            return sum;
        }
    }
}
