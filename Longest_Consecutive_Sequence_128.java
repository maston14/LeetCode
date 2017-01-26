package LeetCode;

import java.util.*;

/**
 * Created by YIZHONGQI on 18/12/2016.
 */
public class Longest_Consecutive_Sequence_128 {

    // 用map记录边界及其对应的长度, O(n)
    public class Solution_Map {
        public int longestConsecutive(int[] nums) {
            if( nums == null || nums.length == 0 ) {
                return 0;
            }
            int ans = 1;
            // 一个map, key是number, val是以key为边界(左或者右)的连续序列的长度
            Map<Integer, Integer> map = new HashMap<>();

            for( int num : nums ) {
                if( !map.containsKey( num ) ) {
                /*
                每次出现一个新 number 的时候, 去看其左右相邻的数
                left 就是以 num - 1 结尾的连续序列的长度
                right 就是以 num + 1 起始的连续序列的长度
                */
                    int left = map.containsKey( num - 1 ) ? map.get( num - 1 ) : 0;
                    int right = map.containsKey( num + 1 ) ? map.get( num + 1 ) : 0;

                    // sum就是把自己和左右都连起来的新的连续序列的长度
                    int sum = left + right + 1;
                    map.put( num, sum );

                    ans = Math.max( ans, sum );

                    // 更新边界的值
                    map.put( num - left, sum );
                    map.put( num + right, sum );
                } else {
                    continue;
                }
            }
            return ans;
        }
    }


    // 把 array 放进 set 中 - O(n)
    public class Solution_Set {
        public int longestConsecutive(int[] nums) {
            if( nums == null || nums.length == 0 ) {
                return 0;
            }
            Set<Integer> set = new HashSet<>();

            for( int num : nums ) {
                set.add( num );
            }

            int max = 1;

            for( int num : nums ) {
                if( set.remove( num ) ) {
                    int val = num;
                    int sum = 1;
                    while( set.remove( val - 1 ) ) val--;
                    sum += num - val;

                    val = num;
                    while( set.remove( val + 1 ) ) val++;
                    sum += val - num;

                    max = Math.max( max, sum );
                }
            }
            return max;
        }
    }

    // 排序的写法, naive, O(nlogn)
    public class Solution_Sort {
        public int longestConsecutive( int[] nums ) {
            if( nums == null || nums.length == 0 ) {
                return 0;
            }
            Arrays.sort( nums );
            int max = 1;
            int count = 1;
            for ( int i = 0; i < nums.length - 1; i++ ) {
                if ( nums[i] == nums[i + 1] - 1 )
                    count++;
                else if ( nums[i] == nums[i + 1] ) {
                    continue;
                } else {
                    max = Math.max( max, count );
                    count = 1;
                }
            }
            max = Math.max( max, count );
            return max;
        }
    }
}
