package LeetCode;

/**
 * Created by YIZHONGQI on 02/12/2016.
 */
public class Valid_Palindrome_125 {

    // 最直接的做法,regex去掉非字母,reverse一下,比一比是不是一样


    // 直接比,不用先去除标点,空格,two pointer
    public class Solution_origin {
        public boolean isPalindrome(String s) {
            if(s == null || s.equals("") ) return true;
            int i = 0;
            int j = s.length() - 1;
            char[] ch_a = s.toLowerCase().toCharArray();
            while(i < j){
                while( i < j &&(ch_a[i] < '0' || ch_a[i] > '9' )&& (ch_a[i] < 'a' || ch_a[i] > 'z'))
                    i++;
                while( i < j && (ch_a[j] < '0' || ch_a[j] > '9') && (ch_a[j] < 'a' || ch_a[j] > 'z'))
                    j--;
                if(ch_a[i] != ch_a[j])
                    return false;
                i++;
                j--;
            }
            return true;
        }
    }


    // regex去除非字母
    public class Solution_regex {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            s = s.replaceAll("[^0-9a-z]", "");
            char[] c = s.toCharArray();
            int lo = 0, hi = s.length()-1;

            while( lo < hi ){
                if( c[lo] != c[hi] ) return false;
                lo++;
                hi--;
            }
            return true;
        }
    }
}
