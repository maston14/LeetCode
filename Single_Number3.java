package LeetCode;

/**
 * Created by YIZHONGQI on 08/11/2016.
 */
public class Single_Number3 {

    public int[] singleNumber(int[] nums) {
        int num1 = 0;
        int num2 = 0;
        int xor = 0;
        for(int i : nums){
            xor ^= i;
        }
        int unique = xor & ~(xor - 1);

        for(int i : nums){
            if((i & unique) ==0){
                num1 ^= i;
            }else{
                num2 ^= i;
            }
        }
        return new int[]{num1,num2};

    }

}
