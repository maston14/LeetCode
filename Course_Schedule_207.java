package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by YIZHONGQI on 27/01/2017.
 */
public class Course_Schedule_207 {


    // Topological sort
    public class Solution_BFS {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjList = new ArrayList<>( numCourses );
            int[] indegree = new int[numCourses];

            for( int i = 0; i < numCourses; i++ ) {
                adjList.add( new ArrayList<Integer>() );
            }

            // 转化为邻接表并统计indegree
            for( int i = 0; i < prerequisites.length; i++ ) {
                adjList.get( prerequisites[i][0] ).add( prerequisites[i][1] );
                indegree[prerequisites[i][1]]++;
            }

            int count = 0;
            Deque<Integer> queue = new LinkedList<>();

            // indegree为 0 的入队列
            for( int i = 0; i < indegree.length; i++ ) {
                if( indegree[i] == 0 )
                    queue.offer(i);
            }

            // 把入度为0的出队列, 把他相应的出边对应的indegree都剪掉, 如果又有indegree为0的再入队列
            while( queue.size() > 0 ) {
                int cur = queue.poll();
                count++;
                for( int i : adjList.get( cur ) ) {
                    if( --indegree[i] == 0 ) {
                        queue.offer( i );
                    }
                }
            }

            return count == numCourses;
        }
    }
}
