package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by YIZHONGQI on 14/11/2016.
 */
public class Word_Pattern2 {


    // origin
    public boolean wordPatternMatch( String pattern, String str ) {
        if ( pattern == null || str == null ) return false;
        int l1 = pattern.length();
        int l2 = str.length();
        if ( l1 == 0 && l2 == 0 ) return true;
        else if ( l1 == 0 || l2 == 0 ) return false;
        char[] p = pattern.toCharArray();

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return dfs( map, set, 0, 0, str, p );

    }


    public boolean dfs( Map<Character, String> map, Set<String> set, int p_start, int s_start, String str, char[] p ) {
        if ( p_start >= p.length ) return true;
        if ( s_start >= str.length() && p_start < p.length ) return false;

        int i = p_start; // 从pattern入手,每次一个char,遍历str选一个substring,然后剩下的str去选下一个char

        for ( int j = s_start + 1; j <= str.length(); j++ ) {
            boolean flag = false;
            if ( i == p.length - 1 )
                j = str.length();

            String match = str.substring( s_start, j );

            if ( !map.containsKey( p[i] ) ) {
                if ( !set.contains( match ) ) {
                    map.put( p[i], match );
                    flag = true;
                } else
                    continue;
            } else if ( !map.get( p[i] ).equals( match ) )
                continue;


            set.add( match );

            if ( dfs( map, set, i + 1, j, str, p ) )
                return true;

            set.remove( match );
            if ( flag )
                map.remove( p[i] );
        }

        return false;
    }

}
