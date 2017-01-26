package LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by YIZHONGQI on 21/11/2016.
 */
public class Find_Median_from_Data_Stream {


    // more concise version
    class MedianFinder_Concise {
        // max queue is always larger or equal to min queue
        PriorityQueue<Integer> min = new PriorityQueue();
        PriorityQueue<Integer> max = new PriorityQueue( Collections.reverseOrder() );

        // Adds a number into the data structure.
        public void addNum( int num ) {
            max.offer( num );
            min.offer( max.poll() );
            if ( max.size() < min.size() ) {
                max.offer( min.poll() );
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if ( max.size() == min.size() ) return ( max.peek() + min.peek() ) / 2.0;
            else return max.peek();
        }
    }

    ;


    // 维护一个minHeap和一个maxHeap, 保证minHeap的顶比maxHeap的顶大,同时两个Heap的size相差不能超过1
    public class MedianFinder {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                new Comparator<Integer>() {
                    public int compare( Integer a, Integer b ) {
                        return b.compareTo( a );
                    }
                } );

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Adds a number into the data structure.
        public void addNum( int num ) {
            if ( minHeap.size() == 0 )
                minHeap.offer( num );
            else {
                if ( minHeap.size() == maxHeap.size() ) {
                    if ( num > minHeap.peek() ) {
                        minHeap.offer( num );
                    } else
                        maxHeap.offer( num );
                } else if ( minHeap.size() < maxHeap.size() ) {
                    if ( num > minHeap.peek() )
                        minHeap.offer( num );
                    else {
                        maxHeap.offer( num );
                        minHeap.offer( maxHeap.poll() );
                    }
                } else {
                    if ( num > minHeap.peek() ) {
                        maxHeap.offer( minHeap.poll() );
                        minHeap.offer( num );
                    } else
                        maxHeap.offer( num );
                }
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if ( minHeap.size() == maxHeap.size() )
                return (double) ( minHeap.peek() + maxHeap.peek() ) / 2;
            else if ( minHeap.size() > maxHeap.size() )
                return (double) minHeap.peek();
            else
                return (double) maxHeap.peek();
        }
    }

    ;
}
