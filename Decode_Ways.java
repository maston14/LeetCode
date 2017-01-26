package LeetCode;

/**
 * Created by YIZHONGQI on 17/11/2016.
 */
public class Decode_Ways {


    // O(1)空间
    public int numDecodings_fast( String s ) {
        int len = s.length();
        if ( len == 0 || s.charAt( 0 ) == '0' ) return 0;
        // r2: decode ways of s[i-2] , r1: decode ways of s[i-1]
        int pre1 = 1, pre2 = 1;
        char[] ch_a = s.toCharArray();
        for ( int i = 1; i < len; i++ ) {
            // zero voids ways of the last because zero cannot be used separately
            if ( ch_a[i] == '0' ) pre1 = 0;

            // possible two-digit letter, so new r1 is sum of both while new r2 is the old r1
            if ( ch_a[i - 1] == '1' || ( ch_a[i - 1] == '2' && ch_a[i] <= '6' ) ) {
                pre1 = pre2 + pre1;
                pre2 = pre1 - pre2;
                /*
                int temp = pre1;
                pre1 = pre1 + pre2;
                pre2 = temp;
                 */
            } else {
                // one-digit letter, no new way added
                pre2 = pre1;
            }
        }

        return pre1;
    }

    // O(1), more readable
    public class Solution {
        public int numDecodings( String s ) {
            int len = s.length();
            if ( len == 0 || s.charAt( 0 ) == '0' ) return 0;
            int pre1 = 1, pre2 = 1;
            char[] ch_a = s.toCharArray();

            for ( int i = 1; i < len; i++ ) {
                int cur = 0;

                int v_cur = ch_a[i] - '0';
                if ( v_cur >= 1 && v_cur <= 9 )
                    cur += pre1;

                int v_pre = 10 * ( ch_a[i - 1] - '0' ) + ch_a[i] - '0';
                if ( v_pre >= 10 && v_pre <= 26 )
                    cur += pre2;

                pre2 = pre1;
                pre1 = cur;
            }
            return pre1;
        }
    }


    // O(n)空间
    public int numDecodings( String s ) {
        if ( s == null || s.equals( "" ) ) return 0;
        char[] ch_a = s.toCharArray();
        int[] dp = new int[ch_a.length + 1];
        if ( ch_a[0] == '0' ) return 0;
        dp[0] = 1;
        dp[1] = 1;
        for ( int i = 2; i < dp.length; i++ ) {
            // 自己和前面一位
            String pre = String.valueOf( ch_a[i - 2] ) + String.valueOf( ch_a[i - 1] );
            int v_pre = Integer.valueOf( pre );

            if ( v_pre >= 10 && v_pre <= 26 )
                dp[i] += dp[i - 2];

            // 只看自己这位
            String cur = String.valueOf( ch_a[i - 1] );
            int v_cur = Integer.valueOf( cur );

            if ( v_cur >= 1 && v_cur <= 9 )
                dp[i] += dp[i - 1];
        }
        return dp[dp.length - 1];
    }
}
