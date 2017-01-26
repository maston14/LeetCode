package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by YIZHONGQI on 14/11/2016.
 */
public class Generate_Parentheses {


    // better code
    public List<String> generateParenthesis_better( int n ) {
        List<String> result = new LinkedList<String>();
        if ( n > 0 ) generate( "", n, n, result );
        return result;
    }

    private void generate( String prefix, int left, int right, List<String> result ) {
        if ( left == 0 && right == 0 ) result.add( prefix );
        // Has left Parenthesis
        if ( left > 0 ) generate( prefix + '(', left - 1, right, result );
        // has more right Parenthesis
        if ( left < right ) generate( prefix + ')', left, right - 1, result );
    }


    //*********************************************************
    // origin
    public List<String> generateParenthesis( int n ) {
        List<String> ans = new ArrayList<>();
        if ( n == 0 ) {
            ans.add( "" );
            return ans;
        }
        //Deque<Character> stack = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        list.add( "(" );
        helper( ans, list, n - 1, 1, n );
        return ans;
    }

    public void helper( List<String> ans, List<String> list, int left, int right, int n ) {
        if ( list.size() == 2 * n ) {
            StringBuilder sb = new StringBuilder();
            for ( String s : list )
                sb.append( s );
            ans.add( sb.toString() );
            return;
        }

        if ( left > 0 ) {
            list.add( "(" );
            helper( ans, list, left - 1, right + 1, n );
            list.remove( list.size() - 1 );
        }
        if ( right > 0 ) {
            list.add( ")" );
            helper( ans, list, left, right - 1, n );
            list.remove( list.size() - 1 );
        }
    }
}
