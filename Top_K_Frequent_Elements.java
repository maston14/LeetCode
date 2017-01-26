package LeetCode;

import java.util.*;

/**
 * Created by YIZHONGQI on 01/11/2016.
 */
public class Top_K_Frequent_Elements {
    public static void main( String[] args ) {

        int[] ia = {1, 10, 5, 3, 4, 7, 6, 9, 8};
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
        for ( int x : ia ) {
            pq1.offer( x );
        }

        System.out.println( pq1.peek() );
    }

    // bucket sort
    public List<Integer> topKFrequent_BKSORT( int[] nums, int k ) {
        List<Integer> ans = new ArrayList<>();

        // nums.length个bucket,bucket[i]后面的list里是freq为i+1的number
        List<Integer>[] bucket = new List[nums.length];

        Map<Integer, Integer> freq = new HashMap<>();

        for ( int i : nums ) {
            if ( !freq.containsKey( i ) ) {
                freq.put( i, 1 );
            } else
                freq.put( i, freq.get( i ) + 1 );
        }

        for ( int i : freq.keySet() ) {
            int f = freq.get( i );
            if ( bucket[f - 1] == null )
                bucket[f - 1] = new ArrayList<>();
            bucket[f - 1].add( i );
        }

        for ( int i = nums.length - 1; i >= 0 && ans.size() < k; i-- ) {
            if ( bucket[i] != null ) {
                ans.addAll( bucket[i] );
            }
        }

        return ans.subList( 0, k );
    }


    // PriorityQueue
    public List<Integer> topKFrequent( int[] nums, int k ) {
        List<Integer> ans = new ArrayList<>();

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare( Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b ) {
                        return b.getValue().compareTo( a.getValue() );
                    }
                }
        );
        Map<Integer, Integer> freq = new HashMap<>();

        for ( int i : nums ) {
            if ( !freq.containsKey( i ) ) {
                freq.put( i, 1 );
            } else
                freq.put( i, freq.get( i ) + 1 );
        }

        for ( Map.Entry<Integer, Integer> entry : freq.entrySet() )
            pq.offer( entry );

        for ( int i = 0; i < k; i++ ) {
            ans.add( pq.poll().getKey() );
        }

        return ans;
    }

}
