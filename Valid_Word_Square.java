package LeetCode;

import java.util.List;

/**
 * Created by YIZHONGQI on 21/12/2016.
 */
public class Valid_Word_Square {

    // 每次把一列给取出来比较, readable and fast
    public class Solution_Readable {
        public boolean validWordSquare( List<String> words ) {
            if ( words.size() == 0 ) return true;

            for ( int i = 0; i < words.size(); i++ ) {
                String s = words.get( i );
                if ( !s.equals( getVerticalString( i, words ) ) ) {
                    return false;
                }
            }

            return true;
        }

        String getVerticalString( int col, List<String> words ) {
            StringBuilder sb = new StringBuilder();

            for ( int i = 0; i < words.size(); i++ ) {
                String word = words.get( i );
                if ( col < word.length() ) {
                    sb.append( word.charAt( col ) );
                }

            }

            return sb.toString();
        }
    }

    // short but slow
    public class Solution {
        public boolean validWordSquare( List<String> words ) {
            if ( words == null || words.size() == 0 ) {
                return true;
            }
            int n = words.size();
            for ( int i = 0; i < n; i++ ) {
                for ( int j = 0; j < words.get( i ).length(); j++ ) {
                    // words.get(j).length() <= i 是为了保证 words.get(j).charAt(i)存在
                    if ( j >= n || words.get( j ).length() <= i || words.get( j ).charAt( i ) != words.get( i ).charAt( j ) )
                        return false;
                }
            }
            return true;
        }
    }

    // Origin,有点繁琐
    public class Solution_Origin {
        public boolean validWordSquare( List<String> words ) {
            int rows = words.size();

            int i = 0;
            while ( i < rows ) {
                int row_len = words.get( i ).length();
                // 是否对称
                if ( row_len > rows )
                    return false;

                int j = i + 1;
                while ( j < rows ) {

                    int moving_row_len = words.get( j ).length();
                    // 空字符的情况
                    if ( j >= row_len && i >= moving_row_len )
                        break;
                    else if ( j >= row_len || i >= moving_row_len )
                        return false;
                    // 比较对应位置的字符是否相等
                    if ( words.get( i ).charAt( j ) != words.get( j ).charAt( i ) )
                        return false;
                    j++;
                }
                i++;
            }
            return true;
        }
    }
}
