package LeetCode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by YIZHONGQI on 15/11/2016.
 */
public class Implement_Stack_Using_Queue {


    // 1 queue, insert take O(n)
    Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x)
    {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++)
        {
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop()
    {
        queue.poll();
    }

    // Get the top element.
    public int top()
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty()
    {
        return queue.isEmpty();
    }



    // two queue version
    Queue<Integer> current = new ArrayDeque<>();
    Queue<Integer> next = new ArrayDeque<>();
    int top;
    // Push element x onto stack.
    public void push2(int x) {
        current.offer(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop2() {
        if(current.size() == 1)
            current.poll();
        else{
            while(current.size() > 2){
                int i = current.poll();
                next.offer(i);
            }
            top = current.poll();
            next.offer(top);
            current.poll();
            Queue<Integer> t = current;
            current = next;
            next = t;
        }
    }

    // Get the top element.
    public int top2() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty2() {
        return current.size() == 0;
    }
}
