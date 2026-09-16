package problems;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private final Map<Integer, Integer> values = new HashMap<>();
    private final Map<Integer, Integer> counts = new HashMap<>();
    // count -> keys with that count, in least-recently-used-first order
    private final Map<Integer, LinkedHashSet<Integer>> buckets = new HashMap<>();
    private final int capacity;
    private int minCount = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }
        touch(key);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (values.containsKey(key)) {
            values.put(key, value);
            touch(key);
            return;
        }
        if (values.size() == capacity) {
            evict();
        }
        values.put(key, value);
        counts.put(key, 1);
        buckets.computeIfAbsent(1, c -> new LinkedHashSet<>()).add(key);
        minCount = 1;
    }

    private void touch(int key) {
        int count = counts.get(key);
        LinkedHashSet<Integer> bucket = buckets.get(count);
        bucket.remove(key);
        if (bucket.isEmpty()) {
            buckets.remove(count);
            if (minCount == count) {
                minCount = count + 1;
            }
        }
        counts.put(key, count + 1);
        // re-adding at the tail keeps the bucket ordered least-recently-used first
        buckets.computeIfAbsent(count + 1, c -> new LinkedHashSet<>()).add(key);
    }

    private void evict() {
        LinkedHashSet<Integer> bucket = buckets.get(minCount);
        int key = bucket.iterator().next();
        bucket.remove(key);
        if (bucket.isEmpty()) {
            buckets.remove(minCount);
        }
        values.remove(key);
        counts.remove(key);
    }

    public void print() {
        values.forEach((k, v) -> System.out.println("{" + k + ": " + v + ", count: " + counts.get(k) + "}"));
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);

        //[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
        lfuCache.put(2, 1);
        lfuCache.put(3, 2);
        lfuCache.print();
        System.out.println("get 3 : " + lfuCache.get(3));
        lfuCache.print();
        System.out.println("get 2 : " + lfuCache.get(2));
        lfuCache.print();
        lfuCache.put(4, 3);
        System.out.println("After putting 4,3");
        lfuCache.print();
        System.out.println("get 2 : " + lfuCache.get(2));
        lfuCache.print();
        System.out.println("get 3 : " + lfuCache.get(3));
        lfuCache.print();
        System.out.println("get 4 : " + lfuCache.get(4));
        lfuCache.print();
    }
}
