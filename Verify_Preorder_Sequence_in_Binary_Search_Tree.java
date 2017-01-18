package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 13/11/2016.
 */
public class Verify_Preorder_Sequence_in_Binary_Search_Tree {

    // 不断从root去看其左右子树,左子树所有都比root小,右子树所有都比root大


    // 用一个stack, low是当前最小的数,
    // 对于preorder变成的数列, 从root起, 第一处变大的地方,是该树的最小值
    // 每次碰到一个变大的, 就把之前栈里比他小的全pop出来
    // 当碰到第一个比root大的值,栈就被pop空了,最小值就变成了root,此时进入了必须要进入右子树了,也就是说值都要比root大了
    // 如果出现一个小的,就false
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Deque<Integer> path = new ArrayDeque<>();
        for (int p : preorder) {
            if (p < low)
                return false;

            while (path.size() > 0 && p > path.peek())
                low = path.pop();

            path.push(p);
        }
        return true;
    }


    // slow version, worst O(n^2)
    public boolean verifyPreorder_Slow(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        return verify(preorder, 0, preorder.length - 1);
    }

    private boolean verify(int[] a, int start, int end) {
        if(start >= end) return true;
        int pivot = a[start];
        int bigger = -1;
        for(int i = start + 1; i <= end; i++) {
            if(bigger == -1 && a[i] > pivot) bigger = i;
            if(bigger != -1 && a[i] < pivot) return false;
        }
        if(bigger == -1) {
            return verify(a, start + 1, end);
        } else {
            return verify(a, start + 1, bigger - 1) && verify(a, bigger, end);
        }
    }
}
