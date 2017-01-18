package LeetCode;

import java.util.List;

/**
 * Created by YIZHONGQI on 11/01/2017.
 */
public class Word_Break_139 {

    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

            boolean[] dp = new boolean[s.length() + 1 ];
            dp[0] = true;

            for( int i = 1; i < dp.length; i++ ) {
                for( int j = 0; j < i; j++){
                    if( dp[j] && contain( s.substring( j, i ), wordDict ) ) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[ dp.length - 1 ];
        }

        public boolean contain(String s, List<String> wordDict) {
            for( String temp : wordDict ){
                if( temp.equals( s ) )
                    return true;
            }
            return false;
        }
    }
}
