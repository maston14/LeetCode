package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by ZHONGQI on 2/21/17.
 */
public class Sort_Characters_By_Frequency_451 {


    // 就是用个 hashMap 统计词频, 然后搞个 maxHeap 就好了
    public class Solution {
        public String frequencySort(String s) {
            StringBuilder sb = new StringBuilder();
            Map<Character,Integer> map = new HashMap<>();
            PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                    new Comparator<Map.Entry<Character, Integer>>() {
                        public int compare( Map.Entry<Character, Integer> m1, Map.Entry<Character, Integer> m2 ) {
                            int v1 = m1.getValue();
                            int v2 = m2.getValue();
                            if ( v1 == v2 )
                                return m2.getKey() - m1.getKey();
                            return v2 - v1;
                        }
                    }
            );

            for( char ch : s.toCharArray() ) {
                if( !map.containsKey( ch ) ) {
                    map.put( ch, 0 );
                }
                map.put( ch, map.get( ch ) + 1 );
            }

            maxHeap.addAll( map.entrySet() );

            while( !maxHeap.isEmpty() ) {
                Map.Entry<Character, Integer> cur = maxHeap.poll();
                char ch = cur.getKey();
                for( int i = 0; i < cur.getValue(); i++ ) {
                    sb.append( ch );
                }
            }

            return sb.toString();
        }
    }
}
