package LeetCode;

import java.util.*;

/**
 * Created by YIZHONGQI on 04/11/2016.
 */
public class Rearrange_String_k_Distance_Apart {

    //use array
    //count存每个character的频率
    //valid存每个character下一个最靠左可以出现的位置
    public String rearrangeString(String str, int k) {
        int[] valid = new int[26];
        int[] count = new int[26];
        for(char c : str.toCharArray() )
            count[ c -'a' ]++;

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            int nextCh = findNextValid(count,valid,i);
            if(nextCh == -1) return "";
            count[nextCh]--;
            valid[nextCh] = valid[nextCh] + k;
            ans.append((char)('a' + nextCh));
        }
        return ans.toString();
    }

    public int findNextValid(int[] count, int[] valid, int index){
        int max = Integer.MIN_VALUE;
        int nextCh = -1;
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0 && index >= valid[i] && count[i] > max){
                max = count[i];
                nextCh = i;
            }
        }
        return nextCh;
    }

    //******************************************************************************************************************
    // use 1 PriorityQueue to do the greedy on frequency
    // & 1 queue called wait to keep the k distance
    //******************************************************************************************************************
    public String rearrangeString_pq(String str, int k) {
        StringBuilder ans = new StringBuilder();

        char[] ch_a = str.toCharArray();
        // get the character frequency
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : ch_a){
            if(!freq.containsKey(c)){
                freq.put(c,0);
            }
            freq.put(c,freq.get(c) + 1);
        }

        // construct the priorityQueue with comparator
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                new Comparator<Map.Entry<Character, Integer>>(){
                    public int compare(Map.Entry<Character, Integer> m1, Map.Entry<Character, Integer> m2){
                        int v1 = m1.getValue();
                        int v2 = m2.getValue();
                        if(v1 == v2)
                            return m1.getKey() - m2.getKey();
                        return v2 - v1;
                    }
                }
        );

        // wait queue to keep the k distance
        Queue<Map.Entry<Character, Integer>> waitQ = new LinkedList<>();
        maxHeap.addAll(freq.entrySet());

        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> current = maxHeap.poll();
            ans.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQ.offer(current);

            // after one character is inserted, it has to wait for k - 1 time before it can be inserted again
            if(waitQ.size() < k)
                continue;

            Map.Entry<Character, Integer> front = waitQ.poll();
            if(front.getValue() > 0)
                maxHeap.offer(front);
        }
        return ans.length() == str.length() ? ans.toString() : "";
    }

}
