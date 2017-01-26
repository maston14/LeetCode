package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YIZHONGQI on 03/11/2016.
 */
public class Shortest_Word_Distance_II {
    Map<String, List<Integer>> map;

    public Shortest_Word_Distance_II( String[] words ) {
        map = new HashMap<>();
        for ( int i = 0; i < words.length; i++ ) {
            if ( !map.containsKey( words[i] ) ) {
                List<Integer> list = new ArrayList<>();
                map.put( words[i], list );
            }
            map.get( words[i] ).add( i );
        }

    }

    public int shortest( String word1, String word2 ) {
        List<Integer> list1 = map.get( word1 );
        List<Integer> list2 = map.get( word2 );

        int head1 = list1.get( 0 );
        int tail1 = list1.get( list1.size() - 1 );
        int head2 = list2.get( 0 );
        int tail2 = list2.get( list2.size() - 1 );

        if ( tail1 < head2 )
            return head2 - tail1;
        else if ( tail2 < head1 )
            return head1 - tail2;
        else {
            int min = Integer.MAX_VALUE;
            int i1 = 0;
            int i2 = 0;
            while ( i1 < list1.size() && i2 < list2.size() ) {
                int diff = Math.abs( list1.get( i1 ) - list2.get( i2 ) );
                if ( diff < min ) {
                    min = diff;
                }
                // 2个指针,不用一个个比,去掉不必要的比较
                if ( list1.get( i1 ) < list2.get( i2 ) ) {
                    i1++;
                } else if ( i2 < list2.size() ) { //如果get(i2)时,之前的get(i1)都比其小,那么只需使i1迫近i2,当超过其时,再更新i2
                    i2++;
                }
            }
            return min;
        }
    }
}
