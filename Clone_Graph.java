package LeetCode;

import java.util.*;

/**
 * Created by YIZHONGQI on 18/12/2016.
 */
public class Clone_Graph {

    // BFS, iterative
    public class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            if( node == null )
                return null;
            Map<Integer, UndirectedGraphNode> existed = new HashMap<>();
            Deque<UndirectedGraphNode> queue = new ArrayDeque<>();

            UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
            existed.put(clone.label, clone);

            queue.offer(node); // 进入queue的是被copy的graph nodes

            while( queue.size() > 0 ){
                UndirectedGraphNode cur = queue.poll();

                for( UndirectedGraphNode t_node : cur.neighbors ){

                    if( !existed.containsKey(t_node.label) ){
                        UndirectedGraphNode newNode = new UndirectedGraphNode(t_node.label);
                        existed.put(newNode.label, newNode);
                        // 每次把所有的neighbor都new好, 放进map, 然后相应的原始node进queue
                        queue.offer(t_node);
                    }
                    existed.get(cur.label).neighbors.add(existed.get(t_node.label));

                }

            }
            return clone;
        }

    }


    // DFS, Recursive
    // 更加简洁的
    public class Solution_DFS {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

            Map<Integer, UndirectedGraphNode> existed = new HashMap<>();
            return helper( node, existed );
        }

        public UndirectedGraphNode helper( UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> existed ){
            if( node == null )
                return null;

            if( existed.containsKey( node.label ) )
                return existed.get( node.label );

            UndirectedGraphNode udNode = new UndirectedGraphNode( node.label );
            existed.put(node.label, udNode);

            for( UndirectedGraphNode temp : node.neighbors )
                udNode.neighbors.add( helper( temp, existed ) );


            return udNode;
        }
    }


    // origin, recursive写的啰嗦
    public class Solution_Origin {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            Map<Integer, UndirectedGraphNode> existed = new HashMap<>();
            return helper(node, existed);
        }

        public UndirectedGraphNode helper( UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> existed ){
            if( node == null )
                return null;

            UndirectedGraphNode udNode = new UndirectedGraphNode(node.label);
            existed.put(node.label, udNode);

            for( UndirectedGraphNode temp : node.neighbors){
                if( !existed.containsKey(temp.label) ){
                    udNode.neighbors.add(helper(temp, existed));
                }else{
                    if( temp.label == node.label)
                        udNode.neighbors.add(udNode);
                    else
                        udNode.neighbors.add(existed.get(temp.label));

                }
            }
            return udNode;
        }
    }

    class UndirectedGraphNode {
             int label;
             List<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };
}
