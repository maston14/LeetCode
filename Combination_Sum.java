package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by YIZHONGQI on 06/11/2016.
 */
public class Combination_Sum {

    public static void main( String[] args ) {

    }


    public List<List<Integer>> combinationSum( int[] candidates, int target ) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper( res, list, candidates, target, 0 );
        return res;
    }

    private void helper( List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start ) {

        if ( target == 0 ) {
            res.add( new ArrayList<Integer>( list ) );
        } else if ( target > 0 ) {
            for ( int i = start; i < candidates.length; i++ ) {
                if ( candidates[i] <= target ) {
                    list.add( candidates[i] );
                    helper( res, list, candidates, target - candidates[i], i );
                    list.remove( list.size() - 1 ); // 回溯
                }
            }
        }
    }

    // iterative版本, 用stack模拟递归
    public List<List<Integer>> combinationSum_Iterative( int[] candidates, int target ) {
        Arrays.sort( candidates );
        int i = 0, size = candidates.length, sum = 0;
        Stack<Integer> combi = new Stack<>(), indices = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        while ( i < size ) {
            if ( sum + candidates[i] >= target ) {
                if ( sum + candidates[i] == target ) {
                    combi.push( candidates[i] );
                    result.add( new ArrayList<>( combi ) );
                    combi.pop();
                }
                // indices stack and combination stack should have the same size all the time
                if ( !indices.empty() ) {
                    // 如果 sum + candidates[i] > target, 那么candidates[i]后面的肯定也不行
                    // 所以这时要把stack顶给弹出来,然后i++
                    // 这时要考虑如果顶上的是candidates的最后一个元素,这时不能结束,应该把栈顶是最后一个元素的全弹出来
                    sum -= combi.pop();
                    // indice主要是用来回溯的
                    i = indices.pop();
                    while ( i == size - 1 && !indices.empty() ) {
                        i = indices.pop();
                        sum -= combi.pop();

                    }
                }
                i++;
            } else {
                combi.push( candidates[i] );
                sum += candidates[i];
                indices.push( i );
            }
        }
        return result;
    }


}
