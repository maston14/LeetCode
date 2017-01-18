package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by YIZHONGQI on 17/11/2016.
 */
public class Moving_Average_from_Data_Stream {


    // 用数组,不用list
    public class MovingAverage2 {

        private int [] window;
        private int n, insert;
        private long sum;

        /** Initialize your data structure here. */
        public MovingAverage2(int size) {
            window = new int[size];
            insert = 0;
            sum = 0;
        }

        public double next(int val) {
            if (n < window.length)  n++;
            sum -= window[insert];
            sum += val;
            window[insert] = val;
            insert = (insert + 1) % window.length;

            return (double)sum / n;
        }
    }


    public class MovingAverage {

        List<Integer> window;
        int size;
        int sum;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            sum = 0;
            window = new LinkedList<>();
        }

        public double next(int val) {
            window.add(val);
            int w = window.size();
            if(w <= size){
                sum += val;
            }else if( w > size){
                int temp = window.remove(0);
                sum -= temp;
                sum += val;
            }
            return (double)sum/window.size();
        }
    }
}
