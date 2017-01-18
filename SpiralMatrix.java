package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return null;
        if(m == 1){
            for(int i = 0; i < matrix[0].length;i++)
                res.add(matrix[0][i]);
            return res;
        }
        int n = matrix[0].length;
        int[][] visit = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                visit[i][j]=0;

        //初始化visit数组
        for(int i = 0, j = 0; i <= (m-1)/2 && j <= (n-1)/2; i++, j++){
            for(int row_top = j; row_top < n-j; row_top++)
                if(visit[i][row_top] == 0){
                    res.add(matrix[i][row_top]);
                    visit[i][row_top] = 1;
                }

            for(int col_right = i+1; col_right < m-1-i; col_right++)
                if(visit[col_right][n-j-1] == 0){
                    res.add(matrix[col_right][n-j-1]);
                    visit[col_right][n-j-1] = 1;
                }

            for(int row_buttom = n-1-j; row_buttom > j; row_buttom--)
                if(visit[m-i-1][row_buttom] == 0){
                    res.add(matrix[m-i-1][row_buttom]);
                    visit[m-i-1][row_buttom] = 1;
                }

            for(int col_left = m-1-i; col_left > i; col_left--)
                if(visit[col_left][j] == 0){
                    res.add(matrix[col_left][j]);
                    visit[col_left][j] = 1;
                }

        }
        return res;
    }

    public static List<Integer> spiralOrderWithDir(int[][] matrix){
        int dir = 0; // east
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;

        int row = 0;
        int col = 0;
        int row_l = 0;
        int row_h = matrix.length;
        int col_l = 0;
        int col_h = matrix[0].length;

        while(row_l < row_h && col_l < col_h) {
            if(dir == 0){
                int k = col;
                while(k < col_h){
                    res.add(matrix[row][k]);
                    k++;
                }
                col = k - 1;
                row_l++;
                row++;
            }
            else if(dir == 1){
                int k = row;
                while( k < row_h){
                    res.add(matrix[k][col]);
                    k++;
                }
                row = k - 1;
                col_h--;
                col--;

            }
            else if (dir == 2) {
                int k = col;
                while(k >= col_l){
                    res.add(matrix[row][k]);
                    k--;
                }
                col = k + 1;
                row_h--;
                row--;
            }
            else if (dir == 3) {
                int k = row;
                while( k >= row_l){
                    res.add(matrix[k][col]);
                    k--;
                }
                row = k + 1;
                col_l++;
                col++;
            }

            dir++;
            dir = dir % 4;
        }
        return res;
    }

}
