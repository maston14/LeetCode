package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by YIZHONGQI on 04/12/2016.
 */
public class Multiply_Strings {


    // 老外是这么教乘法的,一对一对乘起来
    public class Solution {
        public String multiply( String num1, String num2 ) {
            int m = num1.length(), n = num2.length();
            int[] pos = new int[m + n];

            for ( int i = m - 1; i >= 0; i-- ) {
                for ( int j = n - 1; j >= 0; j-- ) {
                    int mul = ( num1.charAt( i ) - '0' ) * ( num2.charAt( j ) - '0' );
                    int p1 = i + j;
                    int p2 = i + j + 1;
                    int sum = mul + pos[p2];

                    pos[p1] += sum / 10;
                    pos[p2] = ( sum ) % 10;
                }
            }

            StringBuilder sb = new StringBuilder();
            for ( int p : pos ) if ( !( sb.length() == 0 && p == 0 ) ) sb.append( p );
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }


    // origin, 一位位乘,再按每一位的结果,加起来
    public class Solution_Complex {
        public String multiply( String num1, String num2 ) {
            List<Integer> ans = new LinkedList<>();
            char[] ch_a1 = num1.toCharArray();
            char[] ch_a2 = num2.toCharArray();
            int len2 = num2.length();

            for ( int i = len2 - 1; i >= 0; i-- ) {
                ans = add( ans, mulit( ch_a1, ch_a2[i], len2 - 1 - i ) );
            }
            StringBuilder sb = new StringBuilder();
            for ( int i : ans )
                sb.append( i );
            return sb.toString();
        }

        public List<Integer> mulit( char[] num, char single, int pos ) {
            List<Integer> ans = new LinkedList<>();
            int lower = single - '0';
            if ( lower == 0 ) {
                ans.add( 0 );
                return ans;
            }
            int carry = 0;
            for ( int i = num.length - 1; i >= 0; i-- ) {
                int a = num[i] - '0';
                int mul = a * lower + carry;
                ans.add( 0, mul % 10 );
                carry = mul / 10;
            }
            if ( carry != 0 )
                ans.add( 0, carry );
            if ( ans.get( 0 ) != 0 )
                for ( int i = 0; i < pos; i++ )
                    ans.add( 0 );

            return ans;
        }

        public List<Integer> add( List<Integer> a, List<Integer> b ) {
            List<Integer> ans = new LinkedList<>();
            int carry = 0;
            int i = a.size() - 1;
            int j = b.size() - 1;

            while ( i >= 0 || j >= 0 ) {
                int ta = i >= 0 ? a.get( i-- ) : 0;
                int tb = j >= 0 ? b.get( j-- ) : 0;
                int temp = ta + tb + carry;
                ans.add( 0, temp % 10 );
                carry = temp / 10;
            }
            if ( carry != 0 )
                ans.add( 0, carry );
            return ans;
        }
    }
}
