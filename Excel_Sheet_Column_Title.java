package LeetCode;

/**
 * Created by YIZHONGQI on 21/12/2016.
 */
public class Excel_Sheet_Column_Title {

    /*
    A   1     AA    26+ 1     BA  2×26+ 1     ...     ZA  26×26+ 1     AAA  1×26²+1×26+ 1
    B   2     AB    26+ 2     BB  2×26+ 2     ...     ZB  26×26+ 2     AAB  1×26²+1×26+ 2
    .   .     ..    .....     ..  .......     ...     ..  ........     ...  .............
    .   .     ..    .....     ..  .......     ...     ..  ........     ...  .............
    .   .     ..    .....     ..  .......     ...     ..  ........     ...  .............
    Z  26     AZ    26+26     BZ  2×26+26     ...     ZZ  26×26+26     AAZ  1×26²+1×26+26

    和进制不太一样, 因为进位时时AA而不是A0
    所以不能直接 n%26, 要先减一
     */

    public class Solution {
        public String convertToTitle(int n) {
            StringBuilder sb = new StringBuilder();
            while( n > 0 ){
                // 先减1,再求余, 解决余数为0的问题
                n--;
                sb.append((char)('A' + n % 26));
                n /= 26;
            }

            return sb.reverse().toString();
        }
    }
}
