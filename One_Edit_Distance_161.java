package LeetCode;

/**
 * Created by ZHONGQI on 2/8/17.
 */
public class One_Edit_Distance_161 {

    public class Solution {
        public boolean isOneEditDistance(String s, String t) {
            for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    // s has the same length as t, so the only possibility is replacing one char in s and t
                    if (s.length() == t.length())
                        return s.substring(i + 1).equals(t.substring(i + 1));

                        // t is longer than s, so the only possibility is deleting one char from t
                    else if (s.length() < t.length())
                        return s.substring(i).equals(t.substring(i + 1));
                    else
                        // s is longer than t, so the only possibility is deleting one char from s
                        return t.substring(i).equals(s.substring(i + 1));
                }
            }
            //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
            return Math.abs(s.length() - t.length()) == 1;
        }
    }
}
