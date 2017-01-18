package LeetCode;

import java.util.LinkedList;

/**
 * Created by YIZHONGQI on 06/11/2016.
 */
public class Number_of_Islands {


    // dfs
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)return 0;
        int[][] visit = new int[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == '1' && visit[i][j] == 0){
                    count++;
                    dfs(grid, visit, i, j);

                }
        return count;
    }
    public void dfs(char[][] grid, int[][] visit, int x, int y){
        if(x < grid.length && y < grid[0].length && grid[x][y] == '1' && visit[x][y] == 0){
            visit[x][y] = 1;
            if( x - 1 >= 0)
                dfs(grid, visit, x-1, y);
            if( x + 1 < grid.length)
                dfs(grid, visit, x+1, y);
            if( y - 1 >= 0)
                dfs(grid, visit, x, y-1);
            if( y + 1 < grid[0].length)
                dfs(grid, visit, x, y+1);
        }
    }


    //bfs
    public int numIslands_bfs(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfsFill(grid,i,j);
                    count++;
                }
            }
        return count;
    }
    private void bfsFill(char[][] grid,int x, int y){
        grid[x][y]='0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int code = x*m+y; // 用这个方法来代替存一个坐标pair
        queue.offer(code);
        while(!queue.isEmpty())
        {
            code = queue.poll();
            int i = code/m;
            int j = code%m;
            if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
            {
                queue.offer((i-1)*m+j);
                grid[i-1][j]='0';
            }
            if(i<n-1 && grid[i+1][j]=='1')  //down
            {
                queue.offer((i+1)*m+j);
                grid[i+1][j]='0';
            }
            if(j>0 && grid[i][j-1]=='1')  //left
            {
                queue.offer(i*m+j-1);
                grid[i][j-1]='0';
            }
            if(j<m-1 && grid[i][j+1]=='1')  //right
            {
                queue.offer(i*m+j+1);
                grid[i][j+1]='0';
            }
        }
    }

}
