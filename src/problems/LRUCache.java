package problems;

import java.util.LinkedHashMap;

class LRUCache {

    private static LinkedHashMap<Integer, Entry> map;
    private final int capacity;

    public LRUCache(int capacity) {
        if (capacity < 1 || capacity > 3000) {
            throw new IllegalArgumentException("Capacity must be between 1 and 3000");
        }
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int valueToReturn = map.get(key).value;
            moveToFirst(key);
            return valueToReturn;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Entry existing = map.remove(key);
            existing.value = value;
            map.putFirst(key, existing);
        } else {
            if (capacity == map.size()) {
                int lruKey = map.lastEntry().getKey();
                map.remove(lruKey);
            }
            map.putFirst(key, new Entry(key, value));
        }
    }

    private class Entry {
        Integer key;
        Integer value;

        public Entry(int key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }


    public void print() {
        map.forEach((k, v) -> System.out.println("{" + k + ": " + (v != null ? v.value : null) + "}"));
    }

    public void printValues() {
        map.values().forEach(entry -> System.out.println("{" + entry.key + ": " + entry.value + "}"));
    }

    private void moveToFirst(int key) {
        Entry entryToMoveToFirst = map.remove(key);
        map.putFirst(key, entryToMoveToFirst);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        //[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
        lruCache.put(2, 1);
        lruCache.put(3, 2);
        lruCache.printValues();
        System.out.println("get 3 : " + lruCache.get(3));
        lruCache.printValues();
        System.out.println("get 2 : " + lruCache.get(2));
        lruCache.printValues();
        lruCache.put(4, 3);
        System.out.println("After putting 4,3");
        lruCache.printValues();
        System.out.println("get 2 : " + lruCache.get(2));
        lruCache.printValues();
        System.out.println("get 3 : " + lruCache.get(3));
        lruCache.printValues();
        System.out.println("get 4 : " + lruCache.get(4));
        lruCache.printValues();

    }

}
