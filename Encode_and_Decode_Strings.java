package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 20/11/2016.
 */
public class Encode_and_Decode_Strings {


    public class Codec {

        // 把length+"/"加在每个字符串的前面

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for(String s : strs)
                sb.append(s.length()).append("/").append(s);
            return sb.toString();
        }

        // 用length来跳过每个字符串,这样就不管字符串中间有什么了
        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> ans = new ArrayList<>();
            int i = 0;
            while( i < s.length()){
                int slash = s.indexOf("/",i);
                int len = Integer.valueOf(s.substring(i,slash));
                ans.add(s.substring(slash+1, slash+len+1));
                i = slash + len + 1;
            }
            return ans;
        }
    }

}
