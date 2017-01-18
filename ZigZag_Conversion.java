package LeetCode;

/**
 * Created by YIZHONGQI on 18/11/2016.
 */
public class ZigZag_Conversion {


    // 就是个找规律的题
    public String convert(String s, int numRows) {
        if(s.equals("") || s == null) return "";
        if(numRows == 0 || numRows == 1) return s;
        char[] ch_array = s.toCharArray();
        int len = ch_array.length;
        StringBuilder ans = new StringBuilder();
        int add = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++){
            int index = i;
            if(index == 0 || index == numRows - 1){
                while(index < len){
                    ans.append(ch_array[index]);
                    index += add;
                }
            }else{
                boolean flag =true;
                while(index < len){
                    ans.append(ch_array[index]);
                    if(flag){
                        index += 2 * (numRows - 1 - i);
                    }else
                        index += 2 * i;
                    flag = !flag;
                }
            }
        }
        return ans.toString();
    }

}
