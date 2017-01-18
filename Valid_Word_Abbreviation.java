package LeetCode;

/**
 * Created by YIZHONGQI on 21/12/2016.
 */
public class Valid_Word_Abbreviation {


    public class Solution_Origin {
        public boolean validWordAbbreviation(String word, String abbr) {

            int count = 0;
            int num = 0;
            for( char c : abbr.toCharArray() ) {
                if ( c >= 'a' && c <= 'z' ) {
                    count++;
                    count += num;
                    num = 0;

                    if( count > word.length() || c != word.charAt(count - 1) )
                        return false;
                } else{
                    if( num == 0 && c == '0')
                        return false;
                    num = num * 10 + c - '0';
                }
            }
            count += num;

            return count == word.length();
        }
    }
}
