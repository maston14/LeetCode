package LeetCode;

/**
 * Created by YIZHONGQI on 26/01/2017.
 */
public class Surrounded_Regions_130 {

    // 就是先把边界上的 'O' 和与其相邻的 'O' 都转成 '1', 把剩下的 'O' 就是被包围的, 都转成 'X', 然后把 '1' 再转回来
    public class Solution {
        public void solve(char[][] board) {
            if( board == null )
                return;
            int row = board.length;
            if( row == 0 )
                return;
            int col = board[0].length;
            if( col == 0 )
                return;

            // check first col and last col
            for( int i = 0; i < row; i++ ) {
                boundaryZero( board, i, 0 );
                if( col > 1 ) {
                    boundaryZero( board, i, col -1 );
                }
            }

            // check first row and last row
            for( int i = 1; i < col - 1; i++ ) {
                boundaryZero( board, 0, i );
                if( row > 1 ) {
                    boundaryZero( board, row - 1, i );
                }
            }

            // turn remaining 'O' into 'X'
            for( int i = 0; i < row; i++ ) {
                for( int j = 0; j < col; j++ ) {
                    if( board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }

            // turn the '1' back to 'O'
            for( int i = 0; i < row; i++ ) {
                for( int j = 0; j < col; j++ ) {
                    if( board[i][j] == '1') {
                        board[i][j] = 'O';
                    }
                }
            }

        }

        public void boundaryZero( char[][] board, int i, int j ){
            if( board[i][j] == 'O') {
                board[i][j] = '1';
                if( i > 1 ) {
                    boundaryZero( board, i - 1, j );
                }
                if( i < board.length - 1 ) {
                    boundaryZero( board, i + 1, j );
                }
                if( j > 1 ) {
                    boundaryZero( board, i, j - 1 );
                }
                if( j < board[0].length - 1 ) {
                    boundaryZero( board, i, j + 1 );
                }
            }
        }
    }
}
