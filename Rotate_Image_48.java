package LeetCode;

/**
 * Created by YIZHONGQI on 02/02/2017.
 */
public class Rotate_Image_48 {

    // 就是先转置一下, 然后左右对称交换
    public class Solution {
        public void rotate(int[][] matrix) {
            if( matrix == null || matrix.length == 0 ) {
                return;
            }
            int n = matrix.length;

            transpose( matrix );

            for( int i = 0; i < n; i++ ){
                for( int j = 0; j < n / 2; j++ ) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = t;
                }
            }

        }
        // 矩阵转置
        public void transpose( int[][] matrix ) {
            int n = matrix.length;

            for( int i = 0; i < n; i++ ) {
                for( int j = i + 1; j < n; j++ ) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }
    }


    // 最sb的方法, 新开一个数组, 写过去就好
    public class Solution_Stupid {
        public void rotate(int[][] matrix) {
            if( matrix == null || matrix.length == 0 ) {
                return;
            }

            int n = matrix.length;
            int[][] temp = new int[n][n];

            for( int i = 0; i < n; i++ ) {
                for( int j = 0; j < n; j++ ) {
                    temp[j][n - 1 - i] = matrix[i][j];
                }
            }

            for( int i = 0; i < n; i++ ) {
                for( int j = 0; j < n; j++ ) {
                    matrix[i][j] = temp[i][j];
                }
            }
        }
    }
}
