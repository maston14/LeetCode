package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZHONGQI on 2/16/17.
 */
public class Find_All_Anagrams_in_a_String_438 {

    /*
    Input is only lowercase letter

    Input:
    s: "cbaebabacd" p: "abc"

    Output:
    [0, 6]

    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".
     */

    public class Solution_Origin {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();

            if( s.length() < p.length() ) {
                return ans;
            }

            int[] map = new int[26];
            int[] window = new int[26];

            for( char ch : p.toCharArray() ) {
                map[ch - 'a']++;
            }

            char[] ch_a = s.toCharArray();
            int p_len = p.length();

            for( int i = 0; i < ch_a.length - p_len + 1; i++ ) {
                if( i == 0 ) {
                    for( int j = i; j < i + p_len; j++ ) {
                        window[ch_a[j] - 'a']++;
                    }
                }else {
                    window[ch_a[i - 1] - 'a']--;
                    window[ch_a[i + p_len - 1] - 'a']++;
                }
                if( equals( map, window ) ) {
                    ans.add( i );
                }
            }

            return ans;
        }

        public boolean equals( int[] a, int[] b ) {
            if( a.length != b.length ) {
                return false;
            }
            for( int i = 0; i < a.length; i++ ) {
                if( a[i] != b[i] ) {
                    return false;
                }
            }
            return true;
        }
    }
}
