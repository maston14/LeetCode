package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by YIZHONGQI on 12/11/2016.
 */
public class Meeting_Rooms2 {


    // faster way, 分别对start 和 end排序
    public int minMeetingRooms_fast(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        // 分别对start和end排序
        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int endsItr = 0;
        // 考虑这个问题, 把区间抽象成开始时间和结束时间的位置, 两者其实相互不相干, a的start是和b的end比,和a的end没什么关系
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }



    public int minMeetingRooms(Interval[] intervals) {
        // 按开始时间排序
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });

        // 按结束时间维护一个最小堆
        PriorityQueue<Interval> pq = new PriorityQueue<>(
                new Comparator<Interval>(){
                    public int compare(Interval a, Interval b){
                        return a.end - b.end;
                    }
                });
        for(Interval i : intervals){
            if(pq.size() == 0){
                pq.offer(i);
            }else{
                if(pq.peek().end <= i.start)
                    pq.poll();
                pq.offer(i);
            }
        }
        return pq.size();
    }

}
