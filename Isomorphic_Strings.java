package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Isomorphic_Strings {

    public static String morph( String s ) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for ( int i = 0; i < c.length; i++ ) {
            if ( !map.containsKey( c[i] ) ) {
                map.put( c[i], count );
                sb.append( (char) ( 'a' + count ) );
                count++;
            } else {
                sb.append( (char) ( 'a' + map.get( c[i] ) ) );
            }
        }
        return sb.toString();
    }


}
