package LeetCode;

/**
 * Created by ZHONGQI on 2/8/17.
 */
public class Regular_Expression_Matching_10 {

    /*
    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.

    '*' 一定要和前面的字母组合着用

     */

    /*
    1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    3, If p.charAt(j) == '*':
    here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as a*a

                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */

    public class Solution_2D_DP {
        public boolean isMatch(String s, String p) {

            if (s == null || p == null) {
                return false;
            }
            // 2d dp's size is s + 1, p + 1
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

            dp[0][0] = true;

            // 0th row 代表着 s 为空字符的时候的情况
            for (int i = 1; i < p.length() + 1; i++) {
                // 只有碰到 x* 的时候并把 x* 算成 empty
                if (p.charAt( i - 1 ) == '*' && dp[0][i - 2]) {
                    dp[0][i] = true;
                }
            }
            for (int i = 1 ; i < s.length() + 1; i++) {
                for (int j = 1; j < p.length() + 1; j++) {
                    // case 1: '.' && case 2: equal char - have the same behavior
                    if( p.charAt( j - 1 ) == s.charAt( i - 1) || p.charAt( j - 1 ) == '.' ) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    // case 3: '*'
                    if( p.charAt( j - 1 ) == '*' ) {
                        // case 3.1: p.charAt( j - 2 ) != s.charAt( i - 1 ), 这样 * 只能算作 empty
                        if( p.charAt( j - 2 ) != s.charAt( i - 1 ) && p.charAt( j - 2 ) != '.' ) {
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            /* case 3.2: 关于dp[i - 1][j], 这个是把 * 看做一个 x, 那么还可能有多个, 于是就相当于去还是这个位置,
                                相当于变成 x*x, 然后 最后那个 x 被怼掉, 去看 i - 1 的 和到 x* 的匹配
                            */
                            dp[i][j] = dp[i][j - 2] ||  dp[i - 1][j];
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
