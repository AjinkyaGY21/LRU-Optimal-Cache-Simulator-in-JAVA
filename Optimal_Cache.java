import java.util.ArrayList;

public class Optimal_Cache {
    //we need to know the access sequence first for optimal policy
    public void optimalPage(int[] pg, int pn, int fn) {
        ArrayList<Integer> frames = new ArrayList<>(fn);
        int hits = 0;
        int misses = 0;

        for (int i = 0; i < pn; i++) {
            int page = pg[i];
            if (frames.contains(page)){
                System.out.println("Access "+ page +" : HIT");
                hits++;
            }else {
                if (frames.size() < fn) {
                    frames.add(page);
                } else {
                    int index = getOptimalIndex(pg, i, frames);
                    frames.set(index, page);
                }
                System.out.println("Access "+ page +" : MISS");
                misses++;
            }
        }
        System.out.println();
        System.out.println("Total Hits: " + hits);
        System.out.println("Total Misses: " + misses);
    }

    private static int getOptimalIndex(int[] pg, int start, ArrayList<Integer> frames) {
        int index = -1;
        int farthest = -1;

        for (int i = 0; i < frames.size(); i++) {
            int frame = frames.get(i);
            int nextOccurrence = getNextOccurrence(pg, start, frame);
            if (nextOccurrence == -1) {
                return i;
            }
            if (nextOccurrence > farthest) {
                farthest = nextOccurrence;
                index = i;
            }
        }

        return index;
    }

    private static int getNextOccurrence(int[] pg, int start, int frame) {
        for (int i = start + 1; i < pg.length; i++) {
            if (pg[i] == frame) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
