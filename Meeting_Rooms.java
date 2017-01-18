package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by YIZHONGQI on 12/11/2016.
 */
public class Meeting_Rooms {


    // 分别取出start和end,放两个数组,排序
    public boolean _SortStartandEnd(Interval[] intervals) {
        int len=intervals.length;
        if(len==0){
            return true;
        }
        int[]begin=new int[len];
        int[]stop=new int[len];
        for(int i=0;i<len;i++){
            begin[i]=intervals[i].start;
            stop[i]=intervals[i].end;
        }
        Arrays.sort(begin);
        Arrays.sort(stop);
        int endT=0;
        for(int i=1;i<len;i++){
            if(begin[i]<stop[i-1]){
                return false;
            }
        }
        return true;
    }


    // 对start做排序
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        for(int i = 1; i < intervals.length; i++)
            if(intervals[i].start < intervals[i-1].end)
                return false;
        return true;
    }

}
