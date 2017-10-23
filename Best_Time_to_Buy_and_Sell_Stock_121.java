package LeetCode;

/**
 * Created by YIZHONGQI on 27/01/2017.
 */
public class Best_Time_to_Buy_and_Sell_Stock_121 {

    public class Solution_1 {
        public int maxProfit(int[] prices) {
            if( prices == null || prices.length == 0 )
                return 0;
            int ans = 0;
            int min = prices[0];
            for( int i = 1; i < prices.length; i++ ) {
                if( prices[i] > min ) {
                    ans = Math.max( ans, prices[i] - min );
                }else if( prices[i] < min ){
                    min = prices[i];
                }
            }

            return ans;
        }
    }

    public class Solution_2 {
        public int maxProfit(int[] prices) {
            if( prices == null || prices.length == 0 )
                return 0;
            int ans = 0;
            int min = Integer.MAX_VALUE;
            for( int i = 0; i < prices.length; i++ ) {
                min = Math.min( min, prices[i] );
                ans = Math.max( ans, prices[i] - min );
            }

            return ans;
        }
    }
}
