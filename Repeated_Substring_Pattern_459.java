package LeetCode;

/**
 * Created by YIZHONGQI on 13/01/2017.
 */
public class Repeated_Substring_Pattern_459 {


    // 从 2 to str.length(), 每个长度都试试,一个个往后比
    public class Solution_Origin {
        public boolean repeatedSubstringPattern(String str) {
            char[] ch_a = str.toCharArray();
            int len = ch_a.length;
            if( len < 2 )
                return false;

            for( int i = 2; i <= ch_a.length; i++ ){

                boolean flag = true;
                if( len % i == 0 ){
                    int gap = len / i;

                    for( int j = gap; j <= len - gap; j += gap ) {
                        if( !str.substring( 0, gap ).equals( str.substring( j, j + gap ) ) )
                            flag = false;
                    }
                    if( flag ) return true;
                }
            }
            return false;
        }
    }
}
