package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YIZHONGQI on 07/11/2016.
 */
public class Binary_Watch {

    public List<String> readBinaryWatch(int num) {
        int[] clock = new int[10];
        List<String> res = new ArrayList<>();
        dfs(res, clock, num, 0);
        return res;
    }

    public void dfs(List<String> res, int[] clock, int num, int pos){
        if(num == 0){
            int hour = 0;
            for(int i = 3; i >= 0; i--){
                hour += clock[i] *(1 << (3 - i));
            }
            if( hour > 11)
                return;
            int minute = 0;
            for(int i = 9; i >= 4; i--){
                minute += clock[i] *(1 << (9 - i));
            }
            if(minute > 59)
                return;
            StringBuilder sb = new StringBuilder();
            sb.append(hour+":");
            if(minute < 10)
                sb.append(0);
            sb.append(minute);
            /*
            for(int i : clock)
                System.out.print(i + " ");
            System.out.println(" ");System.out.println(" ");
            */
            res.add(sb.toString());

        }else if(num > 0){
            for(int i = pos; i < 10; i++){
                clock[i] = 1;

                dfs(res,clock,num-1,i+1);
                clock[i] = 0;
            }
        }
    }

}
