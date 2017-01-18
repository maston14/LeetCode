package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class Letter_Combinations_of_Phone_Number {


    // backtracking
    public class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> ans = new LinkedList<String>();
            if(digits == null || digits.equals(""))
                return ans;
            String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            helper(ans, digits.toCharArray(), mapping, 0, new StringBuilder());
            return ans;

        }

        public void helper(List<String> ans, char[] digits, String[] mapping, int index, StringBuilder sb){
            if(index == digits.length){
                ans.add(sb.toString());
            }else{
                int i = Character.getNumericValue(digits[index]);
                for(char c : mapping[i].toCharArray()){
                    sb.append(c);
                    helper(ans, digits, mapping, index + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

    }

    // iterative
    public List<String> letterCombinations_iterative(String digits) {
        List<String> ans = new LinkedList<String>();
        if(digits == null || digits.equals("")) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ans.add("");
        for(int i = 0; i < digits.length(); i++){
            // 获取一位输入的数字
            int x = Character.getNumericValue( digits.charAt( i ) );
            // 从ans中拿出一个, 和该数字对应的每个char链接一下再放回去
            // 从长度判断什么时候停止
            while( ans.get( 0 ).length() == i ){
                String t = ans.remove( 0 );
                for( char s : mapping[x].toCharArray( ) )
                    ans.add( t + s );
            }
        }
        return ans;
    }

}
