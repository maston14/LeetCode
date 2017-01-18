package LeetCode;

import java.util.HashMap;

/**
 * Created by YIZHONGQI on 16/12/2016.
 */
public class LRU_Cache {

    public class LRUCache {

        class Node{
            int key;
            int val;
            Node pre;
            Node next;

            public Node(int key, int value){
                this.key = key;
                this.val = value;
            }
        }

        // 维护一个链表和一个map, map用来快速判断是否hit, 链表用来存访问的时间顺序, 链表的head就是最老的cache, 每次满了就从头开始删
        int capacity;
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        Node head=null;
        Node end=null;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                Node n = map.get(key);
                remove(n);
                setHead(n);
                return n.val;
            }else
                return -1;
        }

        public void set(int key, int value) {
            if(map.containsKey(key)){
                Node n = map.get(key);
                remove(n);
                n.val = value;
                setHead(n);
            }else{
                Node newNode = new Node(key,value);
                if(map.size() >= capacity){
                    map.remove(end.key);
                    remove(end);
                }
                setHead(newNode);
                map.put(key,newNode);
            }
        }

        public void remove(Node n){
            if(n.pre != null){
                n.pre.next = n.next;
            }else{
                head = n.next;
            }

            if(n.next != null){
                n.next.pre = n.pre;
            }else{
                end = n.pre;
            }
        }

        public void setHead(Node n) {
            n.next = head;
            n.pre = null;

            if(head != null){
                head.pre = n;
            }
            head = n;

            if(end == null){
                end = head;
            }
        }
    }
}
