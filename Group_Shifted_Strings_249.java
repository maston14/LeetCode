package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YIZHONGQI on 22/01/2017.
 */
public class Group_Shifted_Strings_249 {

    // 就是把每个string映射到map中
    public class Solution {
        public List<List<String>> groupStrings( String[] strings ) {
            List<List<String>> ans = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for ( String s : strings ) {
                StringBuilder pattern = new StringBuilder();
                // 取每个string的第一个字符, 然后计算后面每个字符减去这个字符, 然后这个差值再加上 'a'
                // 如果这样以以后小于 'a', 加上26
                char head = s.charAt( 0 );
                for ( int i = 0; i < s.length(); i++ ) {
                    char c = (char) ( 'a' + s.charAt( i ) - head );
                    if ( c < 'a' ) {
                        c += 26;
                    }
                    pattern.append( c );
                }
                String key = pattern.toString();
                if ( !map.containsKey( key ) ) {
                    List<String> list = new ArrayList<String>();
                    map.put( key, list );
                }
                map.get( key ).add( s );
            }
            for ( String key : map.keySet() ) {
                List<String> list = map.get( key );
                ans.add( list );
            }
            return ans;
        }
    }
}
