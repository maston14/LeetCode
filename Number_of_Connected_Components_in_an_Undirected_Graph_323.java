package LeetCode;

/**
 * Created by YIZHONGQI on 26/01/2017.
 */
public class Number_of_Connected_Components_in_an_Undirected_Graph_323 {

    // Union-Find
    public class Solution {
        public int countComponents(int n, int[][] edges) {
            int[] nums = new int[n];
            // 初始化有 n 个不相连的component
            int ans = n;

            for( int i = 0; i < n; i++ ) {
                nums[i] = i;
            }

            for( int i = 0; i < edges.length; i++ ) {
                // union, 每做一次union, 就把 ans--
                int p = find( nums, edges[i][0] );
                int q = find( nums, edges[i][1] );
                if( p != q ) {
                    nums[p] = q;
                    ans--;
                }
            }

            return ans;
        }


        public int find( int[] nums, int a ) {
            while( a != nums[a] ) a = nums[a];
            return a;
        }
    }
}
