package LeetCode;

/**
 * Created by ZHONGQI on 2/7/17.
 */
public class The_Maze_490 {

    /*
    这个maze的球,只有再碰到wall的时候,才能停下来
     */

    public class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            if( maze == null || maze.length == 0 || maze[0].length == 0 ) {
                return false;
            }

            int[][] visited = new int[maze.length][maze[0].length];
            visited[start[0]][start[1]] = 1;

            return helper( maze, start, destination, visited, new int[]{ 1, 0 } )
                    || helper( maze, start, destination, visited, new int[]{ -1, 0 } )
                    || helper( maze, start, destination, visited, new int[]{ 0, 1 } )
                    || helper( maze, start, destination, visited, new int[]{ 0, -1 } );

        }

        public boolean helper( int[][] maze, int[] start, int[] destination, int[][] visited, int[] dir ) {

            int x = start[0];
            int y = start[1];

            int nextx = x + dir[0];
            int nexty = y + dir[1];

            if( nextx < 0 || nextx >= maze.length || nexty < 0 || nexty >= maze[0].length || maze[nextx][nexty] == 1 ) {

                if( x == destination[0] && y == destination[1] ) {
                    return true;
                }
                // 因为ball只会停在和wall链接的地方, 所以只会访问这些地方, 因此只在这些地方标visit
                if( visited[x][y] == 1 ) return false;

                visited[x][y] = 1;

                boolean ans = false;

                if( x > 0 && visited[x - 1][y] == 0 && maze[x - 1][y] == 0 ) {

                    ans = helper( maze, new int[]{ x - 1, y }, destination, visited, new int[]{ -1, 0 } );
                    if( ans ) {
                        return ans;
                    }
                }
                if( x < maze.length - 1 && visited[x + 1][y] == 0 && maze[x + 1][y] == 0 ) {

                    ans = helper( maze, new int[]{ x + 1, y }, destination, visited, new int[]{ 1, 0 });
                    if( ans ) {
                        return ans;
                    }
                }
                if( y > 0 && visited[x][y - 1] == 0 && maze[x][y - 1] == 0 ) {

                    ans = helper( maze, new int[]{ x, y - 1 }, destination, visited, new int[]{ 0, -1 } );
                    if( ans ) {
                        return ans;
                    }
                }
                if( y < maze[0].length - 1 && visited[x][y + 1] == 0 && maze[x][y + 1] == 0 ) {

                    ans = helper( maze, new int[]{ x, y + 1 }, destination, visited, new int[]{ 0, 1 } );
                    if( ans ) {
                        return ans;
                    }
                }
                return ans;
            } else {
                return helper( maze, new int[]{ nextx, nexty }, destination, visited, dir );
            }
        }
    }
}
