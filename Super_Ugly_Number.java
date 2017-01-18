package LeetCode;

/**
 * Created by YIZHONGQI on 13/11/2016.
 */
public class Super_Ugly_Number {

    // 跟uglyNumber2一样, 维持k个序列
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] superUgly = new int[n];
        superUgly[0] = 1;
        int k = primes.length;
        int[] index = new int[k];
        int[] candidate = new int[k];
        for(int i = 0; i < k; i++)
            candidate[i] = primes[i];
        for(int i = 1; i < n; i++){
            int min = candidate[0];
            // 找出k个中最小的
            for(int j = 1; j < k; j++){
                if(candidate[j] < min){
                    min = candidate[j];
                }
            }
            superUgly[i] = min;
            for(int j = 0; j < k; j++){
                if(candidate[j] == min){
                    index[j]++;
                    candidate[j] = primes[j]*superUgly[index[j]];
                }
            }
        }
        return superUgly[n-1];
    }

}
