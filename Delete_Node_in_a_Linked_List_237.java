package LeetCode;

public class Delete_Node_in_a_Linked_List_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode temp = node.next;
        node.next = temp.next;
        temp.next = null;
    }
}
