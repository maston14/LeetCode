package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

import static LeetCode.Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List.*;
/**
 * Created by YIZHONGQI on 24/01/2017.
 */
public class Convert_Sorted_Circular_Doubly_Linked_List_to_Balanced_Binary_Search_Tree {

    public static TreeNode listToTree_WithoutBreakTheCircularList( TreeNode head ) {
        if( head == null ){
            return head;
        }
        if(  head == head.left ) {
            head.left = null;
            head.right = null;
            return head;
        }
        TreeNode slow = head, fast = head;

        // find where to cut the list
        while( fast.right != head && fast.right.right != head ) {
            slow = slow.right;
            fast = fast.right.right;
        }

        // find the new end for the left list and new head for the right list
        // 这里注意只有 1个 或者 2个 元素的list的情况
        TreeNode left_end = slow == head ? slow : slow.left;
        TreeNode right_start = slow.right;

        TreeNode prev_end = head.left;

        // complete the left list
        left_end.right = head;
        head.left = left_end;

        // complete the right list
        right_start.left = prev_end;
        prev_end.right = right_start;

        if( slow != head )
            slow.left = listToTree_WithoutBreakTheCircularList( head );
        else
            slow.left = null;

        slow.right = listToTree_WithoutBreakTheCircularList( right_start );

        return slow;

    }

    public static TreeNode listToTree_BreakTheCircularList( TreeNode head ) {
        if( head == null ) {
            return null;
        }
        TreeNode tail = head.left;
        head.left = null;
        tail.right = null;

        return helper( head, null );
    }

    public static TreeNode helper( TreeNode head, TreeNode tail ) {
        if( head == null || head == tail ) {
            return null;
        }
        TreeNode slow = head, fast = head;

        while( fast != tail && fast.right != tail){
            slow = slow.right;
            fast = fast.right.right;
        }

        slow.left = helper( head, slow );

        slow.right = helper( slow.right, tail );

        return slow;
    }

    public static void main( String[] args ) {

        // first build the tree shown in the problem document
        // http://cslibrary.stanford.edu/109/
        TreeNode root = new TreeNode( 4 );
        treeInsert( root, 2 );
        treeInsert( root, 1 );
        treeInsert( root, 3 );
        treeInsert( root, 5 );
        treeInsert( root, 6 );
        treeInsert( root, 7 );
        treeInsert( root, 10 );

        System.out.println( "tree:" );
        printTree( root );   // 1 2 3 4 5 10
        System.out.println();

        System.out.println( "list:" );
        TreeNode head = treeToList_Iterative( root );
        printList( head );   // 1 2 3 4 5 10  yay!
        System.out.println();

        System.out.println( "Restored tree:" );
        //TreeNode newTree = listToTree_WithoutBreakTheCircularList( head );
        TreeNode newTree = listToTree_BreakTheCircularList( head );
        printTree( newTree );   // 1 2 3 4 5 10
        System.out.println();

        System.out.println( "Level print: " );
        levelPrint( newTree );
    }


    public static void levelPrint( TreeNode root ) {
        if( root == null ) {
            return;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer( root );
        while ( !queue.isEmpty() ) {
            int numOfLevel = queue.size();
            while( numOfLevel > 0 && !queue.isEmpty() ) {
                TreeNode cur = queue.poll();
                numOfLevel--;
                System.out.print( cur.val + " ");
                if( cur.left != null )
                    queue.offer( cur.left );
                if( cur.right != null )
                    queue.offer( cur.right );
            }
            System.out.println();
        }
    }
}
