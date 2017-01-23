package LeetCode;

import java.util.HashMap;
import java.util.Map;

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

        for( int i = 0; i < ch_a.length; i++ ) {
            while( map.containsKey( ch_a[i] ) && map.get( ch_a[i] ) + cooldown >= sb.length() ) {
                sb.append("*");
            }
            sb.append( ch_a[i] );
            map.put( ch_a[i], sb.length() - 1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Task_Schedule t = new Task_Schedule();
        System.out.println( t.task_Schedule("ABAABB", 2));
    }
}
