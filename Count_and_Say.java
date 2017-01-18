package LeetCode;

/**
 * Created by YIZHONGQI on 18/11/2016.
 */
public class Count_and_Say {

    public class Solution {
        public String countAndSay(int n) {
            if(n<=0) {
                return "";
            }

            StringBuilder prev = null;
            StringBuilder cur = new StringBuilder("1");

            for(int i = 1; i < n; i++ ) {
                prev = cur;
                cur = new StringBuilder();
                int count = 0;
                char[] target = prev.toString().toCharArray();

                for( int j = 0; j < target.length; j++ ){
                    count = 1;
                    char now = target[j];
                    while( ( j < target.length - 1 ) && target[ j + 1 ] == now ){
                        count++;
                        j++;
                    }
                    cur.append(count);
                    cur.append(now);
                }
            }
            return cur.toString();
        }
    }


    // origin
    public String countAndSay(int n) {
        if(n<=0) {
            return "";
        }

        String nowStr="1";
        for(int current=1; current < n; current++) {
            nowStr = getSay(nowStr);
        }
        return nowStr;
    }

    String getSay(String pre) {

        int count = 0;

        StringBuilder ans = new StringBuilder();
        char[] ch_a = pre.toCharArray();

        for(int i = 0; i < ch_a.length; i++){
            // 把一样的数一下
            count = 1;
            char cur = ch_a[i];
            while( i + 1 < ch_a.length && cur == ch_a[ i + 1 ]){
                count++;
                i++;
            }
            ans.append(count);
            ans.append(cur);

        }
        return ans.toString();
    }

}
