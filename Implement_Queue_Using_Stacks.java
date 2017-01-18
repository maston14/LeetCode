package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by YIZHONGQI on 15/11/2016.
 */
public class Implement_Queue_Using_Stacks {

    // use two stacks
    class MyQueue {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> aux = new ArrayDeque<>();
        int head;
        // Push element x to the back of queue.
        public void push(int x) {
            if(stack.size() == 0)
                head = x;
            stack.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            while(stack.size() > 1){
                aux.push(stack.pop());
            }
            stack.pop();
            if(aux.size() > 0)
                head = aux.peek();
            while(aux.size()>0)
                stack.push(aux.pop());
        }

        // Get the front element.
        public int peek() {
            return head;
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return stack.size() == 0;
        }
    }
}
