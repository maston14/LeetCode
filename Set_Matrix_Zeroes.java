package LeetCode;

/**
 * Created by YIZHONGQI on 20/12/2016.
 */
public class Set_Matrix_Zeroes {

    // O(1), 用原来matrix的第一行和第一列作为记录
    public class Solution {
        public void setZeroes( int[][] matrix ) {
            if ( matrix == null || matrix.length == 0 || matrix[0].length == 0 )
                return;
            int l_row = matrix.length;
            int l_col = matrix[0].length;

            // 用来记录第一行第一列是否应该置0
            boolean first_row = false;
            boolean first_col = false;


            for ( int i = 0; i < l_row; i++ ) {
                for ( int j = 0; j < l_col; j++ )
                    if ( matrix[i][j] == 0 ) {
                        if ( i == 0 ) first_row = true;
                        if ( j == 0 ) first_col = true;
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
            }

            for ( int i = 1; i < l_row; i++ ) {
                for ( int j = 1; j < l_col; j++ ) {
                    if ( matrix[i][0] == 0 || matrix[0][j] == 0 )
                        matrix[i][j] = 0;
                }
            }
            if ( first_row )
                for ( int i = 0; i < l_col; i++ )
                    matrix[0][i] = 0;
            if ( first_col )
                for ( int i = 0; i < l_row; i++ )
                    matrix[i][0] = 0;
        }
    }


    // O(m+n) Space
    public class Solution_Origin {
        public void setZeroes( int[][] matrix ) {
            if ( matrix == null || matrix.length == 0 || matrix[0].length == 0 )
                return;
            int l_row = matrix.length;
            int l_col = matrix[0].length;

            int[] row = new int[l_row];
            int[] col = new int[l_col];

            for ( int i = 0; i < l_row; i++ )
                for ( int j = 0; j < l_col; j++ )
                    if ( matrix[i][j] == 0 ) {
                        row[i] = 1;
                        col[j] = 1;
                    }
            for ( int i = 0; i < l_row; i++ ) {
                if ( row[i] == 1 ) {
                    for ( int j = 0; j < l_col; j++ )
                        matrix[i][j] = 0;
                }
            }

            for ( int i = 0; i < l_col; i++ ) {
                if ( col[i] == 1 ) {
                    for ( int j = 0; j < l_row; j++ )
                        matrix[j][i] = 0;
                }
            }
        }
    }
}
