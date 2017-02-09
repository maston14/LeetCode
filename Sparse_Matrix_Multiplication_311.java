package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZHONGQI on 2/8/17.
 */
public class Sparse_Matrix_Multiplication_311 {

    // much faster, idea is the same 就是找到 A 中每行不为 0 的, 然后去乘
    public class Solution {
        public int[][] multiply(int[][] A, int[][] B) {
            int rowA = A.length, colA = A[0].length, colB = B[0].length;
            int[][] C = new int[rowA][colB];

            for(int i = 0; i < rowA; i++) {
                for(int k = 0; k < colA; k++) {
                    if (A[i][k] != 0) {
                        for (int j = 0; j < colB; j++) {
                            if (B[k][j] != 0)
                                // upadte Cij every cell instead of the whole row * col
                                C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
            return C;
        }
    }


    // A * B, 把 A 的每一行存一个map, 存<pos, non-zero>; B 的每一列存一个map
    public class Solution_Origin {
        public int[][] multiply(int[][] A, int[][] B) {
            int[][] ans = new int[A.length][B[0].length];

            List<Map<Integer,Integer>> rows = new ArrayList<>(A.length);
            List<Map<Integer,Integer>> cols = new ArrayList<>(B[0].length);

            for( int i = 0; i < A.length; i++ ) {
                rows.add( new HashMap<>() );
                for( int j = 0; j < A[0].length; j++ ) {
                    if( A[i][j] != 0 ) {
                        rows.get( i ).put( j, A[i][j] );
                    }
                }
            }

            for( int j = 0; j < B[0].length; j++ ) {
                cols.add( new HashMap<>() );
                for( int i = 0; i < B.length; i++ ) {
                    if( B[i][j] != 0 ) {
                        cols.get( j ).put( i, B[i][j] );
                    }
                }
            }

            for( int i = 0; i < ans.length; i++ ) {
                for( int j = 0; j < ans[0].length; j++ ){
                    Map<Integer,Integer> row = rows.get( i );
                    Map<Integer,Integer> col = cols.get( j );
                    int temp = 0;
                    for( Integer index : row.keySet() ) {
                        if( col.containsKey( index ) ) {
                            temp += row.get( index ) * col.get( index );
                        }
                    }
                    ans[i][j] = temp;
                }
            }
            return ans;
        }
    }
}
