package LeetCode;

/**
 * Created by YIZHONGQI on 30/11/2016.
 */
public class Median_of_Two_Sorted_Arrays_4 {


    // 类似merge sort
    public class Solution {
        public double findMedianSortedArrays( int[] nums1, int[] nums2 ) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int mid = ( len1 + len2 + 1 ) / 2;
            int[] merge = new int[mid + 1];

            int k = 0, i = 0, j = 0;
            for (; k < merge.length && ( i < len1 && j < len2 ); ) {
                merge[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            }

            if ( i == len1 ) {
                while ( k < merge.length && j < len2 )
                    merge[k++] = nums2[j++];
            }
            if ( j == len2 ) {
                while ( k < merge.length && i < len1 )
                    merge[k++] = nums1[i++];
            }
            double res = merge[mid - 1];
            if ( ( len1 + len2 ) % 2 == 0 ) {
                res += (double) merge[mid];
                res /= 2.0;
            }
            return res;
        }
    }
}
