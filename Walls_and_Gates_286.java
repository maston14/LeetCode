package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YIZHONGQI on 27/01/2017.
 */
public class Walls_and_Gates_286 {

    public class Solution_DFS {
        public void wallsAndGates(int[][] rooms) {
            if( rooms == null || rooms.length == 0 || rooms[0].length == 0 )
                return;

            for( int i = 0; i < rooms.length; i++ ) {
                for( int j = 0; j < rooms[0].length; j ++ ) {
                    // DFS 从gate出发
                    if( rooms[i][j] == 0 ) {
                        dfs( rooms, i, j, 0 );
                    }
                }
            }
        }

        public void dfs( int[][] rooms, int i, int j, int distance ) {
            // 如果 i,j 超过了边界, 返回; 或者如果到这个门的 distance 比当前已有的距离大, 也返回
            if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < distance)
                return;

            rooms[i][j] = distance;

            dfs(rooms, i - 1, j, distance + 1);
            dfs(rooms, i + 1, j, distance + 1);
            dfs(rooms, i, j - 1, distance + 1);
            dfs(rooms, i, j + 1, distance + 1);
        }
    }


    public class Solution_BFS {
        public void wallsAndGates(int[][] rooms) {
            if( rooms == null || rooms.length == 0 || rooms[0].length == 0 )
                return;

            Deque<int[]> queue = new LinkedList<>();

            int row = rooms.length;
            int col = rooms[0].length;

            // 先把所有的 gate 入 queue
            for( int i = 0; i < row; i++ ) {
                for( int j = 0; j < col; j ++ ) {
                    if( rooms[i][j] == 0 ) {
                        queue.offer( new int[]{ i, j } );
                    }
                }
            }

            while( queue.size() > 0 ) {
                // 每次把 queue 的头取出来, 把与其相邻的还未访问的空间, +1; 因为这些点必定是通过这个头到门的距离最短
                // 每次都 +1 后把这些点再放回到队列中
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                if( i - 1 >= 0 && rooms[i - 1][j] == Integer.MAX_VALUE ) {
                    rooms[i - 1][j] = rooms[i][j] + 1;
                    queue.offer( new int[]{ i - 1, j } );
                }
                if( i + 1 < row && rooms[i + 1][j] == Integer.MAX_VALUE ) {
                    rooms[i + 1][j] = rooms[i][j] + 1;
                    queue.offer( new int[]{ i + 1, j } );
                }
                if( j - 1 >= 0 && rooms[i][j - 1] == Integer.MAX_VALUE ) {
                    rooms[i][j - 1] = rooms[i][j] + 1;
                    queue.offer( new int[]{ i, j - 1 } );
                }
                if( j + 1 < col && rooms[i][j + 1] == Integer.MAX_VALUE ) {
                    rooms[i][j + 1] = rooms[i][j] + 1;
                    queue.offer( new int[]{ i, j + 1 } );
                }
            }

        }

    }

}
