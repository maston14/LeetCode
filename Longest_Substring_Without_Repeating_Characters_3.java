package LeetCode;

/**
 * Created by YIZHONGQI on 20/01/2017.
 */
public class Longest_Substring_Without_Repeating_Characters_3 {

    public class Solution {
        public int lengthOfLongestSubstring( String s ) {
            int[] count = new int[256];
            char[] ch_a = s.toCharArray();
            // 保持一个 st, ed 的窗口
            int st = 0, ed = 0, ans = 0;

            for (; ed < ch_a.length; ed++ ) {
                // ed向后滑动, 每次进来就把对应的字符在窗口中的个数++
                count[ch_a[ed]]++;

                // 若大于 1 了, 就是有重复的了, 那么先求出之前的最大值, 然后开始 st 向右滑动
                if ( count[ch_a[ed]] > 1 ) {
                    ans = Math.max( ans, ed - st );

                    while ( count[ch_a[ed]] > 1 ) {
                        count[ch_a[st++]]--;
                    }
                }
            }
            // 最后还有比较一下这个, 是因为要处理最长的substring以最后一个字符结尾的情况
            return Math.max( ans, ed - st );
        }
    }
}
