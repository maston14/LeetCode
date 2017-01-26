package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 12/11/2016.
 */
public class Decode_String_394 {

    public String decodeString( String s ) {

        Deque<Integer> count = new ArrayDeque<>();
        Deque<StringBuilder> chars = new ArrayDeque<>();

        StringBuilder cur = new StringBuilder();
        int digit = 0;

        for ( char c : s.toCharArray() ) {

            if ( Character.isDigit( c ) ) {
                digit = digit * 10 + c - '0';

            } else if ( c == '[' ) {

                count.push( digit );
                digit = 0;

                chars.push( cur );
                cur = new StringBuilder();

            } else if ( c == ']' ) {

                StringBuilder tmp = cur;
                cur = chars.pop();

                for ( int i = count.pop(); i > 0; i-- )
                    cur.append( tmp );

            } else
                cur.append( c );
        }
        return cur.toString();
    }

}
