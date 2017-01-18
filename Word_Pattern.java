package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by YIZHONGQI on 13/11/2016.
 */
public class Word_Pattern {


    // 1 map + 1 set
    public boolean wordPattern_MapSet(String pattern, String str) {
        Map<Character, String> wordMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        char[] ch_a = pattern.toCharArray();

        String[] words = str.split(" ");

        int len = ch_a.length;

        if( words.length != len )
            return false;

        for(int i = 0; i < len; i++){
            Character c = ch_a[i];
            if(!wordMap.containsKey(c)){
                if(!wordSet.contains(words[i]))
                    wordMap.put(c, words[i]);
                else
                    return false;
            }else{
                if(!wordMap.get(c).equals(words[i]))
                    return false;
            }
            wordSet.add(words[i]);
        }

        return true;
    }


    // 2个map
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> wordMap = new HashMap<>();
        Map<String, Character> pattern2word = new HashMap<>();
        char[] ch_a = pattern.toCharArray();

        String[] words = str.split(" ");

        int len = ch_a.length;

        if( words.length != len )
            return false;

        for(int i = 0; i < len; i++){
            Character c = ch_a[i];
            if(!pattern2word.containsKey(words[i])){
                pattern2word.put(words[i], c);
            }else{
                if(pattern2word.get(words[i]) != c)
                    return false;
            }

            if(!wordMap.containsKey(c)){
                wordMap.put(c, words[i]);
            }else{
                if(!wordMap.get(c).equals(words[i]))
                    return false;
            }
        }

        return true;
    }

}
