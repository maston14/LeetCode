package LeetCode;

/**
 * Created by YIZHONGQI on 16/12/2016.
 */
public class Count_Numbers_with_Unique_Digits {

    /*
    Given n = 2, return 91.
    (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
     */

    // 排列组合
    public class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if( n == 0 )
                return 1;
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 10;
            for( int i = 2; i < n + 1; i++){
                int ans = 9;
                for( int j = 0; j <= i - 2; j++)
                    ans *= ( 9 - j);

                dp[i] = dp[i-1] + ans;
            }
            return dp[n];

        }
    }
}
