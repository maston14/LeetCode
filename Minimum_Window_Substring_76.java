package LeetCode;

/**
 * Created by YIZHONGQI on 28/01/2017.
 */
public class Minimum_Window_Substring_76 {

    public class Solution {
        public String minWindow(String s, String t) {
            int[] map = new int[256];
            int head = 0;
            int minDis = Integer.MAX_VALUE;
            // 在map中, 只有在 t 中出现的字符的值才会为正, 其他都为 0
            for( int i = 0; i < t.length(); i++ ) {
                map[t.charAt( i )]++;
            }
            // counter就是 t 的字符的个数
            int start = 0, end = 0, counter = t.length();

            while( end < s.length() ) {
                /* 看 end 对应的字符在map中的值是否为 0 , 然后对 map[ char(end) ]--
                        1. > 0 : 证明 end 对应的字符在t中是存在的, counter--
                        2. <= 0 : 证明 end 对应的字符不在 t 中, 那么只是把 map 对应的 --, 不用管counter
                 */
                if( map[s.charAt( end++ )]-- > 0 ) {
                    counter--;
                }
                // 当 counter == 0 了, 说明 start 和 end 之间已经包含了所有的 t 的字符
                while( counter == 0 ) {
                    // 先比较一下当前的最小值
                    if( end - start < minDis ) {
                        minDis = end - start;
                        head = start;
                    }
                    /* 当跑到某个 end 的时候 counter == 0, 此时可能 start 还包含了多余的字符
                     此时去看 start 对应的字符的 map 的值, 因为 start 对应的字符在之前都访问过了
                     肯定已经被  map[s.charAt( )]-- 过了, 所以会有两种情况:
                        1. == 0 如果 start 对应的是 t 中的字符, 那么此时因为下一个迭代是 start++, 所以counter也要++了
                            因为这个在t中的字符出来了
                        2. < 0 这个表示这个字符是多余的, 可以除掉之后形成新的最短substring, 此时不动 counter
                     */
                    if( map[s.charAt( start++ )]++ == 0 ) counter++;
                }
            }

            return minDis == Integer.MAX_VALUE ? "" : s.substring( head, head + minDis );
        }
    }
}
