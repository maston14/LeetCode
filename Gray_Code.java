package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 06/11/2016.
 */
public class Gray_Code {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int count = 1 << n;

        for(int i = 0; i < count; i++){
            res.add((i) ^ (i >> 1)); // see wiki gray code
        }
        return res;
    }
}
