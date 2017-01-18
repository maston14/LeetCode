package LeetCode;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class KMP_strStr {

    public int strStr(String haystack, String needle) {

        // 边界处理
        if(haystack.length() == 0 && needle.length() == 0)
            return 0;
        else if(haystack.length() == 0)
            return -1;
        else if(needle.length() == 0)
            return 0;
        // 预处理
        int[] next = getNext(needle);
        int index = -1;

        char[] target = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int L = target.length;
        int pL = pattern.length;

        // 比较过程
        for(int i = 0, p = 0; i < L; i++){
            while( p > 0 && target[i] != pattern[p])
                p = next[p-1]; // 如果target[i] != pattern[p]， 那么target[i]就跟p-1处的最长前缀的下一个字符比较

            if(target[i] == pattern[p])
                p++;
            if( p == pL)
                return i-p+1;
        }
        return -1;
    }

    // 求next数组
    public int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        char[] ch_array = pattern.toCharArray();

        next[0] = 0;
        for(int i = 1, k = 0; i < ch_array.length; i++){
            while( k > 0 && ch_array[i] != ch_array[k])
                k = next[k-1]; // 关键步骤，如果ch_array[i] != ch_array[k]，那么就要和上一个最长相等前后缀的前缀比
            if(ch_array[i] == ch_array[k])
                k++;
            next[i] = k;
        }

        return next;
    }

}
