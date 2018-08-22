// 146. LRU Cache

// LinkedHashMap Takes Care of Everything

// 3rd param specifies ordering mode, access order
// overriding removeEldest takes care

import java.util.LinkedHashMap;
public class LRUCache {
        private LinkedHashMap<Integer, Integer> map;
        private final int CAPACITY;
        public LRUCache(int capacity) {
            CAPACITY = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > CAPACITY;
                }
            };
        }
        public int get(int key) {
            return map.getOrDefault(key, -1);
        }
        public void set(int key, int value) {
            map.put(key, value);
        }
}

// Noraml HashMap + Doubly LinkedList
/*

Can be solved with a hashtable keeps track of the keys
and its values in the double linkedlist. 

Double linkedlist is node can remove itself without other reference. Takes constant time to add and remove nodes from head or tail.

*/

class LRUCache {
    private int capacity = 0;
    Map<Integer, Node> map = null;
    Node head = null;
    Node tail = null;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        moveToFront(map.get(key));
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(map.containsKey(key)) {
            map.get(key).val = value;
            moveToFront(map.get(key));
        } else {
            freeSpace();
            Node n = new Node(key, value);
            map.put(key, n);
            addToFront(n);
        }
    }
    
    private void freeSpace(){
        if(map.size() == capacity){
            Node toRemove = head.next;
            map.remove(toRemove.key);
            Node next = toRemove.next;
            head.next = next;
            next.prev = head;   
        }
    }
    
    private void moveToFront(Node newNode){
        Node prev = newNode.prev;
        Node next = newNode.next;
        prev.next = next;
        next.prev = prev;
        addToFront(newNode);
    }
    
    private void addToFront(Node newNode){
        Node prev = tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        tail.prev = newNode;
        newNode.next = tail;
        
    }
    
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        public Node() {}
    }
}