import java.util.HashMap;

class Node {
    int key;
    Node prev, next;
    
    Node(int key) {
        this.key = key;
    }
}

public class LRU_Cache {
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head, tail;
    private int hits, misses;
    
    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.hits = 0;
        this.misses = 0;
        this.head = null;
        this.tail = null;
    }
    
    public void lruPage(int[] arr) {
        for (int page : arr) {
            if (cache.containsKey(page)) {
                // Page is already in cache - HIT
                System.out.println("HIT");
                hits++;
                moveToHead(cache.get(page));
            } else {
                // Page is not in cache - MISS
                System.out.println("MISS");
                misses++;
                Node newNode = new Node(page);
                addToCache(newNode);
            }
        }
        System.out.println("Total Hits: " + hits);
        System.out.println("Total Misses: " + misses);
    }
    
    private void moveToHead(Node node) {
        if (node == head) return;
        removeNode(node);
        addNodeToHead(node);
    }
    
    private void addToCache(Node newNode) {
        if (cache.size() >= capacity) {
            // Remove least recently used node
            cache.remove(tail.key);
            removeNode(tail);
        }
        addNodeToHead(newNode);
        cache.put(newNode.key, newNode);
    }
    
    private void removeNode(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        if (node == head) head = node.next;
        if (node == tail) tail = node.prev;
    }
    
    private void addNodeToHead(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = node;
    }
}
