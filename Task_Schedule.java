package LeetCode;

import java.util.*;

/**
 * Created by YIZHONGQI on 19/01/2017.
 */
public class Task_Schedule {
    /*
    give some Tasks like AABACA, and a cooldown time, same task has to be at least cooldown time wide
     */

    // solution 1: 用一个hashmap存 task -> last pos
    // 这里是默认不能改变任务的顺序
    public String task_Schedule( String tasks, int cooldown ) {
        char[] ch_a = tasks.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < ch_a.length; i++ ) {
            while ( map.containsKey( ch_a[i] ) && map.get( ch_a[i] ) + cooldown >= sb.length() ) {
                sb.append( "*" );
            }
            sb.append( ch_a[i] );
            map.put( ch_a[i], sb.length() - 1 );
        }

        return sb.toString();
    }

    public static void main( String[] args ) {
        Task_Schedule t = new Task_Schedule();
        System.out.println( t.task_Schedule( "ABAABB", 2 ) );
    }


    //4，无序的，统计频率的做法，输出最后字符串

    /**
     * Find the task that appears for the most time
     * Use a map to count the number of the times the task appears  then get the maximum count
     * the result is decided by the maximum count and the number of tasks with maximum count
     * <p>
     * two conditions:
     * 1.  5 4 _ _ _ 5 4 _ _ _ 5 4 _ _ _ 5 4  the rest tasks cannot fill the empty slots
     * 5 4 3 2 _ 5 4 3 2 _ 5 4 _ _ _ 5 4
     * the answer is (maxCount - 1) * (interval + 1) + CountOfMax
     * 1. 5 4 _ _ _ 5 4 _ _ _ 5 4 _ _ _ 5 4  the rest tasks cannot fill the empty slots
     * 5 4 3 2 1 6 5 4 3 2 1 6 5 4 6 _ _ 5 4
     * the answer is the length of the nums
     * the task which does not have max count first fills the empty slots and then just insert any valid place
     */

    //output a sequence of tasks that takes least time:O(maxFrequency*klogk) time,O(n) space,n is number of unique tasks
    private static String taskSchedule4( String str, int k ) {
        StringBuilder rearranged = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for ( char c : str.toCharArray() ) {
            if ( !map.containsKey( c ) ) {
                map.put( c, 0 );
            }
            map.put( c, map.get( c ) + 1 );
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>( new Comparator<Map.Entry<Character, Integer>>() {
            public int compare( Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2 ) {
                return entry2.getValue() - entry1.getValue();
            }
        } );
        maxHeap.addAll( map.entrySet() );//O(nlogn) time, O(n) space
        ArrayList<Map.Entry<Character, Integer>> temp = new ArrayList<>();//O(k) space

        while ( !maxHeap.isEmpty() ) {//O(max frequency) time
            int i = 0;
            temp.clear();
            while ( i <= k && !maxHeap.isEmpty() ) {//O(k) time
                Map.Entry<Character, Integer> curr = maxHeap.poll();
                rearranged.append( curr.getKey() );
                curr.setValue( curr.getValue() - 1 );
                temp.add( curr );
                i++;
            }

            //add this code if we wanna add _ to show that we need to wait for cooldown, eg.AABB, 2 -> AB_AB
            while ( i <= k ) {//i <= k, not i < k !!!
                rearranged.append( "_" );
                i++;//remember to add i++ !!!
            }

            for ( Map.Entry<Character, Integer> e : temp ) {//O(klogk) time
                if ( e.getValue() > 0 ) {
                    maxHeap.offer( e );
                }
            }
        }

        //add this code if we add "_" to the string, we need to delete all the "_" at the tail, eg.A__A__ -> A__A
        for ( int i = rearranged.length() - 1; i >= 0 && rearranged.charAt( i ) == '_'; i-- ) {
            rearranged.deleteCharAt( i );
        }

        return rearranged.toString();
    }

    //5，//if cooldown is very small, but there are lots of tasks, how to reduce space? O(cooldown) space
    private static int taskSchedule2( int[] tasks, int cooldown ) {
        if ( tasks == null || tasks.length == 0 ) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();//store tasks that are waiting for cooldown?
        HashMap<Integer, Integer> map = new HashMap<>();//store indices, where cooldown stops, of tasks in window
        int slots = 0;
        for ( int task : tasks ) {
            if ( map.containsKey( task ) && map.get( task ) > slots ) {
                //add this code if our output is a string, eg.AA, 2 -> A__A
                //int waitingTime = map.get(task) - slots;
                //for (int i = 0; i < waitingTime; i++) {
                //    sb.append("_");
                //}
                slots = map.get( task );//if we need to wait for the cooldown of the same task, just update the slots
            }
            if ( queue.size() == cooldown + 1 ) {
                map.remove( queue.poll() );//we should do this after updating the slots, cuz we store indices of cooldown
            }//stops, we don't know whether we have any idol period between these two same tasks yet, so update it first
            map.put( task, slots + cooldown + 1 );//update the time slot to the time when curr task can be done again
            queue.offer( task );
            slots++;//update the used 1 slot of curr task
        }
        return slots;
    }
}
