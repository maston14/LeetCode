package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class Remove_K_Digits {

/*
Observation 1: our highest prioirty is to move the number that is at index 0, with index 1 being 0
For example, if we have 3004567 and we want to remove 1 digit, we defintely want to remove 3, so that we can
get rid of the following 2 zeros, ending up with 4567, which will always give us the biggest decrease

Observation 2: if there is no case of observation 1, then we want to remove the biggest number in the first ascenging sequence.
For example, if we have 234543, we want to remove the 5 first, since after 5 the number starts going down.

Observatino 3: if we have to remove more than 1 digit, every digit removal can use the same strategy, i.e we can use greedy algorithm here, aka not dp.
*/

    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0) return "0";
        List<Character> list = new ArrayList<>();
        for(char c : num.toCharArray())
            list.add(c);
        System.out.println(list);
        for(int i = 0; i < k; i++){
            int len = list.size();

            //observation 1
            if( len >=2 && list.get(1) == '0'){
                list.remove(0);
                while(!list.isEmpty() && list.get(0) == '0')
                    list.remove(0);
                continue;
            }

            //if no observation 1, use observation 2
            for(int j = 0; j < len; j++){
                if(j < len - 1 &&list.get(j) > list.get(j+1)){
                    list.remove(j);
                    break;
                }
                if( j == len - 1)
                    list.remove(len - 1);
            }
        }
        if(list.size() == 0) return "0";
        StringBuilder result = new StringBuilder();
        for(Character c : list){
            result.append(c);
        }
        return result.toString();

    }

}
