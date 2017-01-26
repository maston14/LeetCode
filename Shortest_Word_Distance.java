package LeetCode;

/**
 * Created by YIZHONGQI on 03/11/2016.
 */
public class Shortest_Word_Distance {
    public int shortestDistance( String[] words, String word1, String word2 ) {
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        for ( int i = 0; i < words.length; i++ ) {
            if ( words[i].equals( word1 ) ) {
                p1 = i;
                if ( p2 >= 0 )
                    min = Math.min( min, p1 - p2 );
            }
            if ( words[i].equals( word2 ) ) {
                p2 = i;
                if ( p1 >= 0 )
                    min = Math.min( min, p2 - p1 );
            }
        }
        return min;
    }
}
