package LeetCode;

/**
 * Created by YIZHONGQI on 30/11/2016.
 */
public class Add_Binary {

    public class Solution {
        public String addBinary(String a, String b) {
            char[] ch_a = a.toCharArray();
            char[] ch_b = b.toCharArray();
            StringBuilder ans = new StringBuilder();

            int i = ch_a.length - 1;
            int j = ch_b.length - 1;
            int carry = 0;

            while(i >= 0 || j >= 0){

                int val_a = i >= 0 ? ch_a[i--] - '0' : 0;
                int val_b = j >= 0 ? ch_b[j--] - '0' : 0;

                int t = val_a + val_b + carry;

                ans.append( t % 2 );
                carry = t / 2;
            }
            if( carry == 1 )
                ans.append( carry );
            return ans.reverse().toString();
        }
    }
}
