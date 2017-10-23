package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YIZHONGQI on 18/12/2016.
 */
public class Copy_List_with_Random_Pointer_138 {

    // 3pass, O(1) Space
    public class Solution {
        public RandomListNode copyRandomList( RandomListNode head ) {
            RandomListNode iter = head, next = null;

            // First round: make copy of each node,
            // and link them together side-by-side in a single list.
            while ( iter != null ) {
                next = iter.next;
                RandomListNode newNode = new RandomListNode( iter.label );
                iter.next = newNode;
                newNode.next = next;

                iter = next;
            }

            // Second round: assign random pointers for the copy nodes.
            iter = head;
            while ( iter != null ) {
                if ( iter.random != null ) {
                    iter.next.random = iter.random.next;
                }
                iter = iter.next.next;
            }

            // Third round: restore the original list, and extract the copy list.
            RandomListNode dummy = new RandomListNode( 0 );
            dummy.next = head;
            iter = head;
            RandomListNode copy = dummy;

            while ( iter != null ) {

                // extract the copy
                copy.next = iter.next;

                // restore the original list
                iter.next = copy.next.next;

                iter = iter.next;
                copy = copy.next;
            }

            return dummy.next;
        }
    }


    // two pass, 更加简洁
    public class Solution_twoPass {
        public RandomListNode copyRandomList( RandomListNode head ) {
            if ( head == null ) return null;

            Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

            // loop 1. copy all the nodes
            RandomListNode node = head;
            while ( node != null ) {
                map.put( node, new RandomListNode( node.label ) );
                node = node.next;
            }

            // loop 2. assign next and random pointers
            node = head;
            while ( node != null ) {
                map.get( node ).next = map.get( node.next );
                map.get( node ).random = map.get( node.random );
                node = node.next;
            }

            return map.get( head );
        }
    }


    // origin, 就是维护一个hashtable就好
    public class Solution_Origin {
        public RandomListNode copyRandomList( RandomListNode head ) {
            if ( head == null )
                return null;

            Map<RandomListNode, RandomListNode> map = new HashMap<>();

            RandomListNode copyHead = new RandomListNode( head.label );
            map.put( head, copyHead );

            RandomListNode p2list = head;
            RandomListNode p2copy = copyHead;
            while ( p2list != null ) {
                if ( p2list.next == null )
                    p2copy.next = null;
                else {
                    if ( !map.containsKey( p2list.next ) ) {
                        RandomListNode tempNext = new RandomListNode( p2list.next.label );
                        map.put( p2list.next, tempNext );
                    }
                    p2copy.next = map.get( p2list.next );
                }

                if ( p2list.random == null )
                    p2copy.random = null;
                else {
                    if ( !map.containsKey( p2list.random ) ) {
                        RandomListNode tempRandom = new RandomListNode( p2list.random.label );
                        map.put( p2list.random, tempRandom );
                    }
                    p2copy.random = map.get( p2list.random );
                }
                p2list = p2list.next;
                p2copy = p2copy.next;
            }
            return copyHead;
        }
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode( int x ) {
            this.label = x;
        }
    }

    ;
}
