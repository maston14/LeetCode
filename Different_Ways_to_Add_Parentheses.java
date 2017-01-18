package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 20/11/2016.
 */
public class Different_Ways_to_Add_Parentheses {


    public class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> res = new ArrayList<>();
            if(input == null || input.length() == 0) return res;

            if(input.indexOf("+") == -1 && input.indexOf("-") == -1 && input.indexOf("*") == -1){
                res.add(Integer.valueOf(input));
                return res;

            }else{
                char[] ch_a = input.toCharArray();
                for(int i = 0; i < ch_a.length; i++){
                    if(ch_a[i] >= '0' && ch_a[i] <= '9')
                        continue;
                    List<Integer> left = diffWaysToCompute(input.substring(0,i));
                    List<Integer> right = diffWaysToCompute(input.substring(i+1,ch_a.length));
                    for(int l : left)
                        for(int r : right){
                            if(ch_a[i] == '+')
                                res.add(l+r);
                            if(ch_a[i] == '-')
                                res.add(l-r);
                            if(ch_a[i] == '*')
                                res.add(l*r);
                        }
                }
            }
            return res;
        }
    }

}
