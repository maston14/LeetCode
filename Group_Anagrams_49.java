package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YIZHONGQI on 27/01/2017.
 */
public class Group_Anagrams_49 {

    // 因为只有小写字母, 用一个26位的数组作为key(要加分隔符转换成string)
    public class Solution {
        public List<List<String>> groupAnagrams( String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();

            for( String s : strs ) {
                int[] count = new int[26];

                for( int i = 0; i < s.length(); i++ ){
                    count[s.charAt( i ) - 'a']++;
                }

                String key = convert(count);

                if( !map.containsKey( key ) ) {
                    map.put( key, new ArrayList<String>() );
                }
                map.get( key ).add(s);
            }
            for( String key : map.keySet() ) {
                ans.add( map.get( key ) );
            }
            return ans;

        }
        // 把数组转化成string
        public String convert( int[] nums ) {
            if( nums.length != 26 ) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for( int i : nums ) {
                sb.append( i + ",");
            }
            return sb.toString();
        }
    }
}
