package LeetCode;

/**
 * Created by YIZHONGQI on 27/01/2017.
 */
public class Best_Time_to_Buy_and_Sell_Stock2_122 {

    // greedy
    public class Solution {
        public int maxProfit(int[] prices) {
            if( prices == null || prices.length == 0 ) {
                return 0;
            }
            int ans = 0;
            for( int i = 1; i < prices.length; i++ ) {
                if( prices[i-1] < prices[i] ) {
                    ans += prices[i] - prices[i-1];
                }
            }
            return ans;
        }
    }
}
