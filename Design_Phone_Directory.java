package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by YIZHONGQI on 11/12/2016.
 */
public class Design_Phone_Directory {


    public class PhoneDirectory {

        Set<Integer> dir;
        Queue<Integer> avail;

        /**
         * Initialize your data structure here
         *
         * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
         */
        public PhoneDirectory( int maxNumbers ) {
            dir = new HashSet<>( maxNumbers );
            avail = new LinkedList<>();

            for ( int i = 0; i < maxNumbers; i++ )
                avail.offer( i );
        }

        /**
         * Provide a number which is not assigned to anyone.
         *
         * @return - Return an available number. Return -1 if none is available.
         */
        public int get() {
            if ( avail.size() > 0 ) {
                int i = avail.poll();
                dir.add( i );
                return i;
            } else
                return -1;
        }

        /**
         * Check if a number is available or not.
         */
        public boolean check( int number ) {
            return !dir.contains( number );
        }

        /**
         * Recycle or release a number.
         */
        public void release( int number ) {
            if ( dir.remove( number ) )
                avail.offer( number );
        }
    }
}
