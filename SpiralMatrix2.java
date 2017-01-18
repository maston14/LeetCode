package LeetCode;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class SpiralMatrix2 {


    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int count = 1;
        int dir=0;

        int row=0;
        int col=0;

        int row_l=0;
        int row_h=n;
        int col_l=0;
        int col_h=n;

        while(row_l < row_h && col_l < col_h){
            if(dir == 0){
                int k = col;
                while( k < col_h){
                    res[row][k]=count;
                    k++;
                    count++;
                }
                col = k - 1;
                row_l++;
                row++;
            }
            else if(dir == 1){
                int k = row;
                while( k < row_h){
                    res[k][col]=count;
                    k++;
                    count++;
                }
                row = k - 1;
                col_h--;
                col--;
            }
            else if(dir == 2){
                int k = col;
                while( k >= col_l){
                    res[row][k]=count;
                    k--;
                    count++;
                }
                col= k + 1;
                row_h--;
                row--;
            }
            else if(dir == 3){
                int k = row;
                while( k >= row_l){
                    res[k][col]=count;
                    k--;
                    count++;
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
