package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 14/11/2016.
 */
public class Restore_IP_Address {

    // 加一些剪枝
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if(s.length() > 12)
            return ans;
        helper(ans, list, s, 0);

        return ans;
    }
    public void helper(List<String> ans, List<String> list, String s, int start){
        int len = s.length();

        if( len - start < (4 - list.size()))
            return;

        if(list.size() == 3 && len - start > 3)
            return;

        if(list.size() == 4 && start == len){
            StringBuilder sb = new StringBuilder();
            for(String t : list)
                sb.append(t + ".");
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
            return;
        }
        for(int i = start+1; i <= len && i <= start+3; i++){
            if(list.size() == 3)
                i = len;
            String candidate = s.substring(start,i);
            if(candidate.startsWith("0") && i - start >1)
                continue;
            int v = Integer.valueOf(candidate);
            if( v >= 0 && v <= 255 && list.size() < 4){
                list.add(candidate);
                helper(ans, list, s, i);
                list.remove(list.size() - 1);
            }

        }
    }



    // 纯backtracking, 无剪枝,慢
    public List<String> restoreIpAddresses_slow(String s) {
        List<String> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if(s.length() > 12)
            return ans;
        helper_slow(ans, list, s, 0);

        return ans;
    }
    public void helper_slow(List<String> ans, List<String> list, String s, int start){
        if(list.size() == 4 && start == s.length()){
            StringBuilder sb = new StringBuilder();
            for(String t : list)
                sb.append(t + ".");
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
            return;
        }
        for(int i = start+1; i <= s.length() && i <= start+3; i++){
            String candidate = s.substring(start,i);
            if(candidate.startsWith("0") && i - start >1)
                continue;
            int v = Integer.valueOf(candidate);
            if( v >= 0 && v <= 255){
                list.add(candidate);
                helper_slow(ans, list, s, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
