//leetcode 895 - https://leetcode.com/problems/maximum-frequency-stack/
import java.util.* ;

class maxFreqStack {
    HashMap<Integer, LinkedList<Integer>> map ;
    HashMap<Integer, Integer> fmap ;
    int maxFreq ;
    
    public maxFreqStack() {
        map = new HashMap<>() ;
        fmap = new HashMap<>() ;
        maxFreq = 0 ;
    }
    
    public void push(int val) {
        int cfreq = fmap.getOrDefault(val, 0) ;
        cfreq ++ ;
        fmap.put(val, cfreq) ;
        
        if(map.containsKey(cfreq) == false){
            map.put(cfreq, new LinkedList<Integer>()) ;
        }
        
        map.get(cfreq).addFirst(val) ;
        maxFreq = Math.max(cfreq, maxFreq) ;
        
    }
    
    public int pop() {
        int ans = map.get(maxFreq).removeFirst() ;
        
        int cfreq = fmap.get(ans) ;
        cfreq -- ;
        fmap.put(ans, cfreq) ;
        
        if(map.get(maxFreq).size() == 0){
            maxFreq -- ;
        }
        
        return ans ;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
