import java.util.ArrayDeque;

public class LRU_Cache {
    private int capacity;
    private ArrayDeque<Integer> cache;

    public LRU_Cache(int capacity) {
        this.cache = new ArrayDeque<>(this.capacity);
    }

    public void lruPage(int[] arr, int capacity) {
        int hits = 0;
        int misses = 0;

        for (int page : arr) {
            if (cache.contains(page)) {
                // Page is already in the cache (HIT)
                System.out.println("HIT");
                hits++;
                cache.remove(page); // Remove the page from its current position
            } else {
                // Page is not in the cache (MISS)
                System.out.println("MISS");
                misses++;
                if (cache.size() >= capacity) {
                    // Remove the least recently used page from the cache
                    cache.removeLast();
                }
            }

            // Add the current page to the front of the cache
            cache.addFirst(page);
        }

        System.out.println("Total Hits: " + hits);
        System.out.println("Total Misses: " + misses);
    }

    public boolean isHit(int key) {
        return cache.contains(key);
    }
}
