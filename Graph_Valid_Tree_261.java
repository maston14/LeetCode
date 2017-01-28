package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by YIZHONGQI on 26/01/2017.
 */
public class Graph_Valid_Tree_261 {

    /*
    edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
    输入的变是这样的多行的二维矩阵, 每一行就是一条边
     */

    public class Solution_UnionFind {
        // 树状的union-find
        public boolean validTree(int n, int[][] edges) {
            int nums[] = new int[n];
            for( int i = 0; i < n; i++ ) {
                nums[i] = i;
            }

            for( int i = 0; i < edges.length; i++ ) {
                // check 两个点是否属于同一个集合
                int x = find( nums, edges[i][0] );
                int y = find( nums, edges[i][1] );

                // 如果属于同一个集合, 那么再加上这条边, 就形成了回路, return false
                if( x == y )
                    return false;
                // 更新 union-find
                nums[x] = y;
            }

            return edges.length == n - 1;
        }
        int find(int nums[], int i) {
            if ( nums[i] == i )
                return i;
            return find( nums, nums[i] );
        }
    }

    public class Solution_DFS {
        public boolean validTree(int n, int[][] edges) {
            List<List<Integer>> adjList = new ArrayList<>( n );
            for( int i = 0; i < n; i++ ) {
                adjList.add( new ArrayList<Integer>() );
            }

            for( int i = 0; i < edges.length; i++ ) {
                int u = edges[i][0], v = edges[i][1];
                adjList.get( u ).add( v );
                adjList.get( v ).add( u );
            }

            boolean[] visited = new boolean[n];

            // 是否有cycle
            if( hasCycle( adjList, 0, visited, -1 ) ){
                return false;
            }

            // 是否全联通
            for( boolean b : visited ){
                if( !b ) {
                    return false;
                }
            }

            return true;

        }

        // parent 是用来过滤掉的
        // 因为如果有在 i 点的邻接表中有 j , 那么当递归进入 j 时, j 的 parent 是 i 且 j 的邻接表必有, 此时的 i 应该被过滤掉
        public boolean hasCycle( List<List<Integer>> adjList, int start, boolean[] visited, int parent ) {
            visited[start] = true;
            List<Integer> cur = adjList.get( start );
            for( int i : cur ) {
                if( ( visited[i] && parent != i ) || ( !visited[i] && hasCycle( adjList, i, visited, start ) ) ) {
                    return true;
                }
            }
            return false;
        }

        // 判断环的BFS, 算法导论的方法, 把节点染色 0,1,2
        public boolean hasCycle_BFS( List<List<Integer>> adjList, int[] color, boolean[] visited ) {
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer( 0 );
            color[0] = 1;

            while( queue.size() > 0 ) {
                int cur = queue.poll();
                visited[cur] = true;
                List<Integer> list = adjList.get( cur );
                // 对该节点的所有相邻的点处理
                for( int i : list ) {
                    // 如果没访问过, color == 0, 就放进队列, 并把颜色染成 1
                    if( color[i] == 0 ) {
                        queue.offer( i );
                        color[i] = 1;
                    }else if( color[i] == 1 ) {
                        // 如果这个节点的颜色已经是 1 了, 证明这个节点在队列中, 那么就形成了环
                        return true;
                    }
                }
                color[cur] = 2;
            }

            return false;
        }

    }
}
