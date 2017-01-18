package LeetCode;

import java.util.HashMap;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Flip_Game2 {

    HashMap<String, Boolean> winMap = new HashMap<String, Boolean>();
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        if (winMap.containsKey(s)) {
            return winMap.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i+2);
                if (!canWin(t)) {
                    winMap.put(s, true);
                    return true;
                }
            }
        }
        winMap.put(s, false);
        return false;
    }

}
