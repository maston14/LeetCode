package LeetCode;

/**
 * Created by YIZHONGQI on 20/11/2016.
 */
public class Word_Search {


    // better
    public class Solution {
        public boolean exist(char[][] board, String word) {
            int[][] visit = new int[board.length][board[0].length];
            char[] ch_a = word.toCharArray();
            for(int i = 0; i < board.length; i++)
                for(int j =0; j < board[0].length; j++)
                    if(board[i][j] == ch_a[0] && dfs(board, visit, ch_a, 0, i, j))
                        return true;
            return false;
        }

        public boolean dfs(char[][] board, int[][] visit, char[] word, int pos, int x, int y){
            if(pos == word.length)
                return true;

            int lenx = board.length;
            int leny = board[0].length;

            if( x < 0 || x >= lenx || y < 0 || y >= leny ||board[x][y] != word[pos] || visit[x][y] == 1)
                return false;

            visit[x][y] = 1;

            if( dfs(board, visit, word, pos+1,x-1,y) || dfs(board, visit, word, pos+1,x+1,y)||
                    dfs(board, visit, word, pos+1,x,y-1) || dfs(board, visit, word, pos+1,x,y+1) )
                return true;

            visit[x][y] = 0;

            return false;
        }
    }



    // origin 写的有点繁琐
    public class Solution_lengthy {
        public boolean exist(char[][] board, String word) {
            int[][] visit = new int[board.length][board[0].length];
            char[] ch_a = word.toCharArray();
            for(int i = 0; i < board.length; i++)
                for(int j =0; j < board[0].length; j++)
                    if(dfs(board, visit, ch_a, 0,i,j))
                        return true;
            return false;
        }

        public boolean dfs(char[][] board, int[][] visit, char[] word, int pos, int x, int y){
            if(pos == word.length-1 && board[x][y] == word[pos])
                return true;
            int lenx = board.length;
            int leny = board[0].length;
            if(board[x][y] == word[pos]){

                visit[x][y] = 1;
                if( valid(x-1,y,lenx,leny) && visit[x-1][y] == 0){
                    if(dfs(board, visit, word, pos+1,x-1,y))
                        return true;
                }
                if( valid(x+1,y,lenx,leny) && visit[x+1][y] == 0){
                    if(dfs(board, visit, word, pos+1,x+1,y))
                        return true;
                }
                if( valid(x,y-1,lenx,leny) && visit[x][y-1] == 0){

                    if(dfs(board, visit, word, pos+1,x,y-1))
                        return true;
                }
                if( valid(x,y+1,lenx,leny) && visit[x][y+1] == 0){
                    if(dfs(board, visit, word, pos+1,x,y+1))
                        return true;
                }
                visit[x][y] = 0;
            }
            return false;
        }

        public boolean valid(int x, int y, int lenx, int leny){
            if(x < 0 || x >= lenx || y < 0 || y >= leny)
                return false;
            return true;
        }
    }
}
