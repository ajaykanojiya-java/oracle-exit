package leetcode;

import java.util.HashMap;
import java.util.Map;
/*
* Design and implement a data structure for the LRU cache that supports LRUCache(capacity), get(key), put(key,value)
* There will be 4 operations
* Operation 1: Remove a key-value pair from the least recently used end, of the cache
* Operation 2: Add a key-value pair to the most recently used end, of the cache.
* Operation 3: Move a key-value pair to the most recent end of the cache, if used/access recently
* Operation 4: Access a value using its key
* */
public class LRUCacheImplementation {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);
        cache.put(1,11);
        cache.put(2,22);
        cache.put(3,33);
        cache.printCacheValues();
        cache.get(1);
        cache.printCacheValues();
        cache.put(4,44);
        cache.printCacheValues();
    }

    static class LRUCache{
        int CAPACITY;
        DoublyLinkedListNode head = new DoublyLinkedListNode(-1);
        DoublyLinkedListNode tail = new DoublyLinkedListNode(-1);
        Map<Integer,DoublyLinkedListNode> map = new HashMap<Integer,DoublyLinkedListNode>();

        LRUCache(int capacity){
            CAPACITY = capacity;
        }

        public int get(int key){
            //if key is not found return -1
            if(map.get(key)==null)
                return -1;
            DoublyLinkedListNode node = map.get(key);
            //node is being used, so move this node to most recently used end.
            //so remove node from the list and add it to most recently used end.
            removeNode(node);
            addToTail(node);
            return node.value;
        }

        public void put(int key, int value){
            DoublyLinkedListNode node = new DoublyLinkedListNode(value);
            if(map.isEmpty()){
                node.prev = head;
                node.next = tail;
                head.next = node;
                tail.prev = node;
                map.put(key,node);
            }else if(map.size()<CAPACITY){ //add node to the tail of the list as cache is not full
                addToTail(node);
                map.put(key,node);
            } else{
                //cache is full so make a room for a new node, so remove node from least recently used end
                removeNode(head.next);
                //add node to most recently used end.
                addToTail(node);
                map.put(key,node);
            }
        }
        //add node at tail.
        public void addToTail(DoublyLinkedListNode node){
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
        }

        //remove node while adjusting the pointer
        public void removeNode(DoublyLinkedListNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void printCacheValues(){
            DoublyLinkedListNode node = head.next;
            while(node.next!=null){
                System.out.println(node.value+" ");
                node = node.next;
            }
            System.out.println("---------");
        }
    }


    /*private static DoublyLinkedListNode[] prepareList(){

        DoublyLinkedListNode node1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode node4 = new DoublyLinkedListNode(4);
        DoublyLinkedListNode node5 = new DoublyLinkedListNode(5);

        DoublyLinkedListNode head = node1;
        DoublyLinkedListNode trail = node5;

        node1.prev = null; node1.next = node2;
        node2.prev = node1; node2.next = node3;
        node3.prev = node2; node3.next = node4;
        node4.prev = node3; node4.next = node5;
        node5.prev = node4; node5.next = null;
        return new DoublyLinkedListNode[]{head,trail};
    }*/

}
