package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YIZHONGQI on 23/12/2016.
 */
public class Can_I_Win_464 {

    // 用bit来做map
    public class Solution_BitMap {

        public boolean canIWin( int maxChoosableInteger, int desiredTotal ) {
            if ( desiredTotal == 0 ) {
                return true;
            }
            if ( ( 1 + maxChoosableInteger ) * maxChoosableInteger / 2 < desiredTotal ) {
                return false;
            }
            return helper( maxChoosableInteger, desiredTotal, new Boolean[1 << maxChoosableInteger], 0 );
        }

        public boolean helper( int maxChoosableInteger, int desiredTotal, Boolean[] map, int visited ) {
            if ( map[visited] != null )
                return map[visited];

            if ( desiredTotal <= 0 )
                return false;

            for ( int i = 0; i < maxChoosableInteger; i++ ) {
                int comp = 1 << i;
                if ( ( comp & visited ) == 0 ) {
                    int temp = visited;
                    visited |= comp;
                    if ( !helper( maxChoosableInteger, desiredTotal - ( i + 1 ), map, visited ) ) {
                        // 这里加入map的是原来的visited
                        map[temp] = true;
                        visited = temp;
                        return true;
                    }
                    visited = temp;
                }
            }
            map[visited] = false;
            return false;
        }
    }


    // 直接用String作为key, 比较慢, 直接用bit更好
    public class Solution_Origin {
        public boolean canIWin( int maxChoosableInteger, int desiredTotal ) {
            if ( desiredTotal <= 1 ) return true;
            if ( maxChoosableInteger * ( maxChoosableInteger + 1 ) / 2 < desiredTotal ) return false;
            return helper( desiredTotal, new int[maxChoosableInteger + 1], new HashMap<String, Boolean>() );
        }

        public boolean helper( int desiredTotal, int[] visited, Map<String, Boolean> map ) {
            String curr = Arrays.toString( visited );

            if ( map.containsKey( curr ) )
                return map.get( curr );

            if ( desiredTotal <= 0 )
                return false;

            for ( int i = 1; i < visited.length; i++ ) {
                if ( visited[i] == 0 ) {
                    visited[i] = 1;
                    // 如果对手不能赢, 那么我就赢了
                    if ( !helper( desiredTotal - i, visited, map ) ) {
                        map.put( curr, true );
                        // 这里记得也要回溯, 不然return true的时候不回溯
                        visited[i] = 0;
                        return true;
                    }
                    visited[i] = 0;
                }
            }
            map.put( curr, false );
            return false;
        }
    }
}
