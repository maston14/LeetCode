package LeetCode;

/**
 * Created by YIZHONGQI on 12/01/2017.
 */
public class Hamming_Distance_461 {

    // 先XOR
    public class Solution_XORFirst {
        public int hammingDistance(int x, int y) {
            int dis = 0;
            int one = x ^ y;
            for( int i = 0; i < 32; i++ ) {
                dis += 1 & ( one >> i );
            }
            return dis;
        }
    }


    public class Solution {
        public int hammingDistance(int x, int y) {
            int dis = 0;
            for( int i = 0; i < 32; i++ ) {
                if( ( ( 1 & ( x >> i ) )^( 1 & ( y >> i ) ) ) == 1 )
                    dis++;
            }
            return dis;
        }
    }
}
