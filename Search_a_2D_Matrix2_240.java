package LeetCode;

/**
 * Created by ZHONGQI on 2/16/17.
 */
public class Search_a_2D_Matrix2_240 {


    // 从右上角开始搜, 每次排除 a row or a col
    public class Solution_RightUpStart {
        public boolean searchMatrix(int[][] matrix, int target) {
            if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ) {
                return false;
            }

            int i = 0, j = matrix[0].length - 1;

            while( i < matrix.length && j >= 0 ) {
                if( matrix[i][j] == target ) {
                    return true;
                }else if( matrix[i][j] < target ) {
                    i++;
                }else if( matrix[i][j] > target ) {
                    j--;
                }
            }
            return false;
        }
    }
}
