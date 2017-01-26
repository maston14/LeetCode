package LeetCode;

import java.util.*;

/**
 * Created by YIZHONGQI on 12/11/2016.
 */
public class Merge_Intervals {


    // 对start和end开两个数组,分别排序
    public List<Interval> merge( List<Interval> intervals ) {
        int len = intervals.size();
        int[] starts = new int[len];
        int[] ends = new int[len];
        for ( int i = 0; i < len; i++ ) {
            starts[i] = intervals.get( i ).start;
            ends[i] = intervals.get( i ).end;
        }
        Arrays.sort( starts );
        Arrays.sort( ends );

        List<Interval> res = new ArrayList<>();
        for ( int i = 0, j = 0; i < len; i++ ) {
            if ( i == len - 1 || starts[i + 1] > ends[i] ) {
                Interval it = new Interval( starts[j], ends[i] );
                res.add( it );
                j = i + 1;
            }
        }
        return res;
    }


    // origin, 先排序,再一个个比,很慢
    public List<Interval> merge_Slow( List<Interval> intervals ) {
        Collections.sort( intervals, new Comparator<Interval>() {
            public int compare( Interval a, Interval b ) {
                return a.start - b.start;
            }
        } );
        int i = 0;
        while ( i < intervals.size() - 1 ) {
            Interval it = intervals.get( i );
            while ( i + 1 < intervals.size() && it.end >= intervals.get( i + 1 ).start ) {
                if ( it.end < intervals.get( i + 1 ).end )
                    it.end = intervals.get( i + 1 ).end;
                intervals.remove( i + 1 );

            }
            i++;
        }
        return intervals;
    }

}
