import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpl<K,V> extends LinkedHashMap<K,V> {
    private int capacity;
    public LRUCacheImpl (int capacity){
        super(capacity, 0.75f, true); // true = access order
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> map){
        return size() > capacity;
    }

    public static void print(LRUCacheImpl<Integer,Integer> cache){
        System.out.println("Cache: "+cache.toString());
    }

    public static void main(String[] args) {
        LRUCacheImpl<Integer,Integer> cache = new LRUCacheImpl<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);      // returns 1
        cache.put(3, 3);   // evicts key 2
        cache.get(2);      // returns null or -1 if using getOrDefault
        cache.put(4, 4);   // evicts key 1
        cache.get(1);      // returns null or -1
        print(cache);

    }
}
