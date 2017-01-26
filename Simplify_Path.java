package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 25/12/2016.
 */
/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

1. Did you consider the case where path = "/../"?
In this case, you should return "/".

2. Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */

public class Simplify_Path {

    public class Solution {
        public String simplifyPath( String path ) {

            String[] items = path.split( "/+" );
            Deque<String> stack = new ArrayDeque<>();

            for ( String s : items ) {
                if ( s.equals( "" ) || s.equals( "." ) )
                    continue;
                else if ( s.equals( ".." ) ) {
                    if ( stack.size() > 0 ) {
                        stack.pop();
                    }
                } else {
                    stack.push( s );
                }
            }

            if ( stack.size() == 0 ) {
                return "/";
            } else {
                StringBuilder sb = new StringBuilder();
                while ( stack.size() > 0 ) {
                    sb.insert( 0, "/" + stack.pop() );
                }
                return sb.toString();
            }
        }
    }
}
