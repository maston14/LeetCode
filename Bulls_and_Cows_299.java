package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YIZHONGQI on 22/12/2016.
 */
public class Bulls_and_Cows_299 {

    // one pass, much shorter
    public class Solution {
        public String getHint( String secret, String guess ) {
            int bulls = 0;
            int cows = 0;
            int[] numbers = new int[10];
            for ( int i = 0; i < secret.length(); i++ ) {
                if ( secret.charAt( i ) == guess.charAt( i ) )
                    bulls++;
                else {
                    // 记录secret中没有被匹配到的字符, 如果这个字符的计数原本小于0, 说明guess中有这个数
                    // 那么就cow++, 然后计数也要++
                    if ( numbers[secret.charAt( i ) - '0']++ < 0 )
                        cows++;
                    // 记录guess中没有被匹配到的字符
                    if ( numbers[guess.charAt( i ) - '0']-- > 0 )
                        cows++;
                }
            }
            return bulls + "A" + cows + "B";
        }
    }

    // two pass, 先算bull, 再算cow
    public class Solution_Origin {
        public String getHint( String secret, String guess ) {

            int bull = 0;
            int cow = 0;
            Map<Character, Integer> pool = new HashMap<>();

            for ( char c : secret.toCharArray() ) {
                if ( !pool.containsKey( c ) )
                    pool.put( c, 1 );
                else
                    pool.put( c, pool.get( c ) + 1 );
            }
            for ( int i = 0; i < secret.length(); i++ ) {
                char g = guess.charAt( i );
                if ( secret.charAt( i ) == g ) {
                    bull++;
                    pool.put( g, pool.get( g ) - 1 );
                }
            }
            for ( int i = 0; i < secret.length(); i++ ) {
                char g = guess.charAt( i );
                if ( pool.containsKey( g ) && secret.charAt( i ) != g ) {
                    if ( pool.get( g ) > 0 ) {
                        cow++;
                        pool.put( g, pool.get( g ) - 1 );
                    }
                }
            }

            return bull + "A" + cow + "B";
        }
    }
}
