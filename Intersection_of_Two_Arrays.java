package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Intersection_of_Two_Arrays {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums2.length==0){
            int empty[] = {};
            return empty;
        }

        HashMap<Integer, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();
        for(int t : nums1){
            if(m1.containsKey(t)){
                m1.put(t, m1.get(t)+1);
            }else {
                m1.put(t,1);
            }
        }
        for(int t : nums2){
            if(m2.containsKey(t)){
                m2.put(t, m2.get(t)+1);
            }else {
                m2.put(t,1);
            }
        }

        ArrayList<Integer> resList = new ArrayList<>();

        for(int t : m1.keySet()){
            if(m2.containsKey(t)){
                int n1 = m1.get(t);
                int n2 = m2.get(t);
                int l = n1<n2?n1:n2;
                for(int i=0;i<l;i++)
                    resList.add(t);
            }
        }

        int[] res = new int[resList.size()];
        int count=0;
        for(int t : resList){
            res[count]=t;
            count++;
        }

        return res;
    }

}
