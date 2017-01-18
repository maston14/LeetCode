package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YIZHONGQI on 29/11/2016.
 */
public class Distinct_Subsequences {

    // dp, 一个二维矩阵,dp[t.length()][s.length]
    // 对于矩阵dp[i][j], 即t到了i位置,s到了j位置,这时去看j-1位置上,i-1匹配了几个
    public class Solution {
        public int numDistinct(String s, String t) {
            if(s == null || t == null)
                return 0;
            int sl = s.length();
            int tl = t.length();
            if(sl == 0 || tl == 0 || tl > sl) return 0;
            int[][] dp = new int[tl][sl];
            if(s.charAt(0) == t.charAt(0))
                dp[0][0] = 1;
            for(int i = 1; i < sl; i++){
                dp[0][i] = dp[0][i-1];
                if(s.charAt(i) == t.charAt(0))
                    dp[0][i]++;
            }

            for(int i = 1; i < tl; i++){
                for(int j = i; j < sl; j++){
                    dp[i][j] = dp[i][j-1];
                    if(s.charAt(j) == t.charAt(i))
                        dp[i][j] += dp[i-1][j-1];
                }
            }
            return dp[tl-1][sl-1];
        }

    }


    // backtraking, pass most case, 数据量大就TLE了
    public class Solution_backtraking {
        public int numDistinct(String s, String t) {
            Map<Character,List<Integer>> map = new HashMap<>();
            char[] ch_a = s.toCharArray();
            for(int i = 0; i < ch_a.length; i++){
                if(!map.containsKey(ch_a[i])){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(ch_a[i],list);
                }else{
                    List<Integer> list = map.get(ch_a[i]);
                    list.add(i);
                }
            }
            return helper(map,t,0,-1);

        }
        public int helper(Map<Character,List<Integer>> map, String t, int pos, int lastPos){
            if(pos >t.length() - 1) return 0;

            char ch = t.charAt(pos);
            int count = 0;
            if(!map.containsKey(ch))
                return 0;
            List<Integer> list = map.get(ch);
            if(pos == t.length() - 1){
                for(Integer I : list){
                    if(I > lastPos)
                        count++;
                }
            }else{
                for(Integer I : list){
                    if(I > lastPos){
                        count += helper(map,t,pos+1,I);
                    }
                }
            }
            return count;

        }
    }
}
