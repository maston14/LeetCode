package LeetCode;

/**
 * Created by YIZHONGQI on 21/11/2016.
 */
public class Plus_One {

    /*
    因为是+1, 只有当9999999...时才可能会新增一位
     */
    public class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 1;
            for(int i = digits.length - 1; i >= 0; i--){
                int temp = digits[i] + carry;
                digits[i] = temp % 10;
                carry = temp / 10;
            }
            if(carry == 1){
                int[] ans = new int[digits.length+1];
                ans[0] = 1;
                return ans;
            }
            return digits;
        }
    }

}
