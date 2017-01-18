package LeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by YIZHONGQI on 30/11/2016.
 */
public class Third_Maximum_Number {



    // set + priorityQueue
    public class Solution {
        public int thirdMax(int[] nums) {
            Set<Integer> set = new HashSet<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(3);
            for(int n : nums){
                if(!set.contains(n)){
                    if(pq.size() < 3){
                        pq.offer(n);
                        set.add(n);
                    }else{
                        if(n > pq.peek()){
                            int kickout = pq.poll();
                            set.remove(kickout);
                            pq.offer(n);
                            set.add(n);
                        }
                    }
                }
            }
            if(pq.size() == 2)
                pq.poll();
            return pq.peek();
        }
    }
}
