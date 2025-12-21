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
*
* Complexity:
* - get(key): O(1)
* - put(key, value): O(1)
* Thread-safety:
* - Not thread-safe. Concurrent access must be synchronized externally.
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

    public static class LRUCache {
        private final int capacity;
        private final Node head; // least recently used sentinel
        private final Node tail; // most recently used sentinel
        private final Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            this.map = new HashMap<>();
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            moveToTail(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node existing = map.get(key);
            if (existing != null) {
                existing.value = value;
                moveToTail(existing);
                return;
            }
            if (map.size() >= capacity) {
                Node lru = head.next;
                removeNode(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            addToTail(node);
            map.put(key, node);
        }

        private void addToTail(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        private void moveToTail(Node node) {
            removeNode(node);
            addToTail(node);
        }

        // helper for debugging
        public void printCacheValues() {
            Node cur = head.next;
            while (cur != tail) {
                System.out.print(cur.value + " ");
                cur = cur.next;
            }
            System.out.println("\n----------");
        }


        private static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int k, int v) {
                key = k;
                value = v;
            }
        }
    }

}
