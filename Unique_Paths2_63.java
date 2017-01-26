package LeetCode;

/**
 * Created by YIZHONGQI on 13/01/2017.
 */
public class Unique_Paths2_63 {

    // 跟2维数组差不多,就是每次算一行,
    public class Solution_SingleArray {
        public int uniquePathsWithObstacles( int[][] obstacleGrid ) {
            int width = obstacleGrid[0].length;
            int[] dp = new int[width];
            dp[0] = 1;
            for ( int[] row : obstacleGrid ) {
                for ( int j = 0; j < width; j++ ) {
                    if ( row[j] == 1 )
                        dp[j] = 0;
                    else if ( j > 0 )
                        dp[j] += dp[j - 1];
                }
            }
            return dp[width - 1];
        }
    }


    public class Solution {
        public int uniquePathsWithObstacles( int[][] obstacleGrid ) {
            int x = obstacleGrid.length;
            int y = obstacleGrid[0].length;
            int[][] dp = new int[x][y];

            if ( obstacleGrid[0][0] == 1 )
                return 0;
            else
                dp[0][0] = 1;

            for ( int i = 0; i < x; i++ ) {
                for ( int j = 0; j < y; j++ ) {
                    if ( obstacleGrid[i][j] == 1 || ( i == 0 && j == 0 ) )
                        continue;
                    else if ( i == 0 ) {
                        if ( obstacleGrid[i][j - 1] != 1 )
                            dp[i][j] = dp[i][j - 1];
                    } else if ( j == 0 ) {
                        if ( obstacleGrid[i - 1][j] != 1 )
                            dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] += obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1];
                        dp[i][j] += obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j];
                    }
                }
            }


            return dp[x - 1][y - 1];
        }
    }
}
