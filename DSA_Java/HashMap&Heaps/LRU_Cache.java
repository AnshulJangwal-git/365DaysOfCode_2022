//Leetcode 146 - https://leetcode.com/problems/lru-cache/
import java.util.* ;

class LRUCache {
    class Node{
        int key, value ;
        Node prev, next ;
    }
    
    private void addNode(Node node){
        Node nbr = head.next ;
        node.next = nbr ;
        node.prev = head ;
        
        nbr.prev = node ;
        head.next = node ;
    }  
    
    private void removeNode(Node node){
        Node prevNbr = node.prev;
        Node nextNbr = node.next ;
        
        prevNbr.next = nextNbr ;
        nextNbr.prev = prevNbr ;
        
        node.next = node.prev = null ;
    }
    
    private void moveToFront(Node node){
        removeNode(node) ;
        addNode(node) ;
    }
    
    HashMap<Integer, Node> cache ;
    int cap ;
    Node head, tail ;
    
    public LRUCache(int capacity) {
        cache = new HashMap<>() ;
        cap = capacity ;
        
        head = new Node() ;
        tail = new Node() ;
        
        head.next = tail ;
        tail.prev = head ;
    }
    
    
    
    public int get(int key) {
        Node node = cache.get(key) ;
        
        if(node == null){
            return -1 ;
        }else{
            moveToFront(node) ;
            return node.value ;
        }
    }
    
    
    public void put(int key, int value) {
        Node node = cache.get(key) ;
        
        if(node == null){ //does not exist..
            Node newNode = new Node() ;
            newNode.key = key ;
            newNode.value = value ;
            
            if(cache.size() == cap){
                Node lru = tail.prev ;
                cache.remove(lru.key) ;
                removeNode(lru) ;
            }
            cache.put(key, newNode) ;
            addNode(newNode) ;
        }else{
            node.value = value ;
            moveToFront(node) ;
            
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */