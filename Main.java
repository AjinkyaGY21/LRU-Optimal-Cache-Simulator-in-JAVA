public class Main{
    public static void main(String[] args) {

        // Testing LRU cache
        LRU_Cache lruCache = new LRU_Cache(3);
        int[] pg = {10,30,60,40,20,10,30,50,70,90,60,20,10,30,60,50};
        int fn = 4;
        lruCache.lruPage(pg, fn);

        System.out.println();

        // Testing Optimal cache
        Optimal_Cache optimalCache = new Optimal_Cache();
        int[] seq = {10,30,60,40,20,10,30,50,70,90,60,20,10,30,60,50};
        int pn = seq.length;
        int fr = 3;
        optimalCache.optimalPage(seq, pn, fr);

    }
}
