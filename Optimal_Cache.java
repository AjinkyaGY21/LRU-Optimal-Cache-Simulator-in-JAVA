import java.util.HashSet;

public class Optimal_Cache {
    public void optimalPage(int[] arr, int n, int capacity) {
        HashSet<Integer> cache = new HashSet<>(capacity);
        int hits = 0, misses = 0;
        
        for (int i = 0; i < n; i++) {
            if (cache.contains(arr[i])) {
                System.out.println("HIT");
                hits++;
            } else {
                System.out.println("MISS");
                misses++;
                if (cache.size() < capacity) {
                    cache.add(arr[i]);
                } else {
                    int optimalRemoveIndex = findOptimalRemoveIndex(cache, arr, i, n);
                    cache.remove(arr[optimalRemoveIndex]);
                    cache.add(arr[i]);
                }
            }
        }
        
        System.out.println("Total Hits: " + hits);
        System.out.println("Total Misses: " + misses);
    }
    
    private int findOptimalRemoveIndex(HashSet<Integer> cache, int[] arr, int currIndex, int n) {
        int farthest = currIndex;
        int indexToRemove = -1;
        for (int item : cache) {
            int nextOccurrence = findNextOccurrence(arr, item, currIndex + 1, n);
            if (nextOccurrence == -1) return item;
            if (nextOccurrence > farthest) {
                farthest = nextOccurrence;
                indexToRemove = item;
            }
        }
        return indexToRemove;
    }
    
    private int findNextOccurrence(int[] arr, int item, int start, int end) {
        for (int i = start; i < end; i++) {
            if (arr[i] == item) return i;
        }
        return -1;
    }
}
