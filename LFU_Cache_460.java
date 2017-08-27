package LeetCode;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created by ZHONGQI on 2/22/17.
 */
public class LFU_Cache_460 {

    /*
    3个HashMap
        cache存 kv 对
        freq存每个 k 的访问次数
        freq2keys存每个访问次数都有哪些key
            其中用了 LinkedHashSet, 是个set, 同时能记录顺序
            头上是最old的, 尾部是 new
     */
    public class LFUCache {

        HashMap<Integer, Integer> cache;
        HashMap<Integer, Integer> freq;
        HashMap<Integer, LinkedHashSet<Integer>> freq2keys;
        int capacity;
        // 保存当前的最低频率
        int min_freq = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            freq = new HashMap<>();
            freq2keys = new HashMap<>();
            freq2keys.put(1, new LinkedHashSet<>());
        }

        public int get(int key) {
            if( !cache.containsKey( key ) ) {
                return -1;
            } else {
                int cur_freq = freq.get( key );
                // 有 key 访问命中, 更新其 freq
                freq.put( key, cur_freq + 1 );
                // 把原来的 freq2keys 中 cur_freq 中的 key删掉
                freq2keys.get( cur_freq ).remove( key );
                // 此时要看是不是 cur_freq 对应的频率是不是min 且 删掉 key 了之后就空了, 此时需要更新 min_freq
                if( cur_freq == min_freq && freq2keys.get( cur_freq ).size() == 0 ) {
                    min_freq++;
                }
                // 把 key 放入新的 freq2kys 的 LinkedHashSet 的尾部
                if( !freq2keys.containsKey( cur_freq + 1 ) ) {
                    freq2keys.put( cur_freq + 1, new LinkedHashSet<>() );
                }
                freq2keys.get( cur_freq + 1 ).add( key );

                return cache.get( key );
            }
        }

        public void put(int key, int value) {
            if( capacity <= 0 ) {
                return;
            }
            // 碰到已有的 key, 更新一下
            if( cache.containsKey( key ) ) {
                cache.put( key, value );
                // 算一次访问
                get( key );
                return;
            }
            // 如果满了, 挑频率最低的, 拿到其 LinkedHashSet, 然后把头上的删掉
            if( cache.size() >= capacity ) {
                int key_abandon = freq2keys.get( min_freq ).iterator().next();
                freq2keys.get( min_freq ).remove( key_abandon );
                cache.remove( key_abandon );
                freq.remove( key_abandon );
            }
            cache.put( key, value );
            freq.put( key, 1 );
            min_freq = 1;
            freq2keys.get( min_freq ).add( key );
        }
    }
}
