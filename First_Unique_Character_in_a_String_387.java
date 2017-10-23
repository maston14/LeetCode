package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class First_Unique_Character_in_a_String_387 {

    // naive two pass; maintain a freq map
    // for this case, assume all lowercase. Then maintaining an array will be faster than map
    public int firstUniqChar_1(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for ( Character ch : s.toCharArray() ) {
            if ( !freq.containsKey( ch ) ) {
                freq.put(ch, 1);
            } else {
                freq.put(ch, freq.get(ch) + 1);
            }
        }
        for( int i = 0; i < s.length(); i++ ) {
            if ( freq.get(s.charAt(i)) == 1 ) {
                return i;
            }
        }
        return -1;
    }

    // use indexof, faster than 1
    public int firstUniqChar_2(String s) {
        for( int i = 0; i < s.length(); i++ ) {
            if ( i == s.lastIndexOf(s.charAt(i)) && i == s.indexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
