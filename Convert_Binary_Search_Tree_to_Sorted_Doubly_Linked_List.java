package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 24/01/2017.
 */

public class Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {

    static TreeNode newhead = null;
    static TreeNode prev = null;

    // 这两个solution都需要全局变量 prev head

    // solution 1: 基本就是 inorder 遍历, 转化成了 循环双向链表 Circular doubly linked list
    public static TreeNode treeToList_Recursive_CircularDoublyLinkedList( TreeNode root ) {

        helper_Recursive_CircularDoublyLinkedList( root );
        return newhead;
    }

    public static void helper_Recursive_CircularDoublyLinkedList( TreeNode cur ) {
        // base case
        if ( cur == null )
            return;
        // recursively do the left
        helper_Recursive_CircularDoublyLinkedList( cur.left );

        // 因为对left subtree 都访问过了
        cur.left = prev;

        if ( prev != null ) {
            prev.right = cur;
        } else {
            newhead = cur;
        }

        TreeNode right = cur.right;

        /* Just update the current node’s right pointer to point back to the head
           and the head’s left pointer to point to current node in each recursive call
           保证每次迭代时, 头尾相连
        */
        newhead.left = cur;
        cur.right = newhead;

        prev = cur;

        helper_Recursive_CircularDoublyLinkedList( right );
    }

    /*******************************************************************************************************************
     *******************************************************************************************************************/

    /*
    solution2: 相当于倒着的中序遍历(即 右 中 左 ),每次都是把当前节点插到 head 前面, 每次先递归右子树
    但这个方法, head 和 tail 没有连起来, doubly linked list
    */
    public static TreeNode treeToList_Recursive_DoublyLinkedList( TreeNode root ) {
        helper_Recursive_DoublyLinkedList( root );
        return newhead;
    }

    public static void helper_Recursive_DoublyLinkedList( TreeNode cur ) {
        if ( cur == null )
            return;
        // recursively go through right
        helper_Recursive_DoublyLinkedList( cur.right );

        // 把 cur 插到当前的 list 的头上
        cur.right = newhead;
        if ( newhead != null )
            System.out.println( "head val is: " + newhead.val );

        if ( newhead != null ) {
            newhead.left = cur;
        }

        newhead = cur;

        helper_Recursive_DoublyLinkedList( cur.left );
    }

    /*******************************************************************************************************************
     *******************************************************************************************************************/


    // 不需要全局变量的 iterative 和 recursive
    public static TreeNode treeToList_NO_STATIC_VAR( TreeNode cur ) {
        // base case: empty tree -> empty list
        if ( cur == null ) return ( null );

        // Recursively do the subtrees (leap of faith!)
        TreeNode aList = treeToList_NO_STATIC_VAR( cur.left );
        TreeNode bList = treeToList_NO_STATIC_VAR( cur.right );

        // Make the single root node into a list length-1
        // in preparation for the appending
        cur.left = cur;
        cur.right = cur;

        // At this point we have three lists, and it's
        // just a matter of appending them together
        // in the right order (aList, root, bList)
        aList = append( aList, cur );
        aList = append( aList, bList );

        return ( aList );
    }

    public static TreeNode append( TreeNode a, TreeNode b ) {
        // if either is null, return the other
        if ( a == null ) return ( b );
        if ( b == null ) return ( a );

        // find the last node in each using the .previous pointer
        TreeNode aLast = a.left;
        TreeNode bLast = b.left;

        // join the two together to make it connected and circular
        join( aLast, b );
        join( bLast, a );

        return ( a );
    }

    public static void join( TreeNode a, TreeNode b ) {
        a.right = b;
        b.left = a;
    }

    /*******************************************************************************************************************
     *******************************************************************************************************************/

    /*
    就是 iterative版本的中序遍历, 然后每次都保存 prev 来链接链表
     */
    public static TreeNode treeToList_Iterative( TreeNode root ) {
        if( root == null ) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while( root != null ) {
            stack.push( root );
            root = root.left;
        }
        TreeNode head = stack.pop();
        TreeNode tail = head;
        TreeNode prev = head;

        while( stack.size() > 0 ) {
            TreeNode temp = stack.pop();

            prev.right = temp;
            temp.left = prev;

            tail = prev = temp;

            temp = temp.right;
            while( temp != null) {
                stack.push( temp );
                temp = temp.left;
            }
        }

        head.left = tail;
        tail.right = head;

        return head;
    }

    // Demonstrate tree->list with the list 1..5
    public static void main( String[] args ) {

        // first build the tree shown in the problem document
        // http://cslibrary.stanford.edu/109/
        TreeNode root = new TreeNode( 4 );
        treeInsert( root, 2 );
        treeInsert( root, 1 );
        treeInsert( root, 3 );
        treeInsert( root, 5 );
        treeInsert( root, 10 );

        System.out.println( "tree:" );
        printTree( root );   // 1 2 3 4 5
        System.out.println();

        System.out.println( "list:" );
        TreeNode head = treeToList_Iterative( root );
        printList( head );   // 1 2 3 4 5   yay!

    }

    // for testing
    public static void treeInsert( TreeNode root, int newval ) {
        if ( newval <= root.val ) {
            if ( root.left != null ) treeInsert( root.left, newval );
            else root.left = new TreeNode( newval );
        } else {
            if ( root.right != null ) treeInsert( root.right, newval );
            else root.right = new TreeNode( newval );
        }
    }

    public static void printTree( TreeNode root ) {
        if ( root == null ) return;
        printTree( root.left );
        System.out.print( Integer.toString( root.val ) + " " );
        printTree( root.right );
    }


    // Do a traversal of the list and print it out
    public static void printList( TreeNode head ) {
        TreeNode current = head;

        while ( current != null ) {
            System.out.print( Integer.toString( current.val ) + " " );
            current = current.right;
            if ( current == head ) break;
        }

        if ( current == null )
            System.out.println( "last pointer to null" );

        System.out.println( "end" );
    }
}
