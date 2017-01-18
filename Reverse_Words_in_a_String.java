package LeetCode;

/**
 * Created by YIZHONGQI on 14/12/2016.
 */
public class Reverse_Words_in_a_String {

    public class Solution {
        public String reverseWords(String s) {

            // remove leading whitespace
            // remove multiple whitespaces
            s = s.trim().replaceAll("\\s+"," ");
            String[] s_a = s.split(" ");

            // 或者可以直接 spilt("\\s+")

            StringBuilder sb = new StringBuilder();
            for(int i = s_a.length - 1; i >= 0 ; i--){
                sb.append(s_a[i]);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }
}
