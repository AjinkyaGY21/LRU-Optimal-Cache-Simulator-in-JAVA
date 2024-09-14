public class Main {
    public static void main(String[] args) {
        // Testing LRU Cache
        System.out.println("LRU Cache:");
        LRU_Cache lruCache = new LRU_Cache(3);
        int[] pg = {10, 30, 60, 40, 20, 10, 30, 50, 70, 90, 60, 20, 10, 30, 60, 50};
        lruCache.lruPage(pg);
        
        System.out.println("\nOptimal Cache:");
        // Testing Optimal Cache
        Optimal_Cache optimalCache = new Optimal_Cache();
        int pn = pg.length;
        optimalCache.optimalPage(pg, pn, 3);
    }
}
