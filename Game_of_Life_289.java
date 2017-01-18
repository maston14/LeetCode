package LeetCode;

/**
 * Created by YIZHONGQI on 18/01/2017.
 */
public class Game_of_Life_289 {

    public class Solution {
        public void gameOfLife(int[][] board) {
            // 2 means 1 -> 0
            // 3 means 0 -> 1
            if( board == null || board.length == 0 || board[0].length == 0 )
                return;

            int xlen = board.length;
            int ylen = board[0].length;
            int live_neigh = 0;

            for( int i = 0; i < xlen; i++ ) {

                for( int j = 0; j < ylen; j++ ) {
                    live_neigh = 0;
                    // go through all neighbors
                    for( int k = i - 1; k <= i + 1; k++ ) {
                        if( k < 0 || k >= xlen )
                            continue;
                        for( int t = j - 1; t <= j + 1; t++ ) {
                            if( t < 0 || t >= ylen || ( k == i && t == j ) )
                                continue;
                            if( board[k][t] == 1 || board[k][t] == 2 )
                                live_neigh++;

                        }
                    }
                    //System.out.println( "[" + i + "]" + "[" + j + "] has live neighbors: " + live_neigh);
                    if( board[i][j] == 1 ) {
                        if( live_neigh < 2 || live_neigh > 3 ) {
                            board[i][j] = 2;
                        }
                    }else if( live_neigh == 3) {
                        board[i][j] = 3;
                    }
                }
            }
            for( int i = 0; i < xlen; i++ ) {
                for( int j = 0; j < ylen; j++ ) {
                    if( board[i][j] == 2 )
                        board[i][j] = 0;
                    else if( board[i][j] == 3 )
                        board[i][j] = 1;
                }
            }
        }
    }
}
