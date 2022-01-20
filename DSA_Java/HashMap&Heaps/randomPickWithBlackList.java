//Leetcode 710 - https://leetcode.com/problems/random-pick-with-blacklist/
import java.util.* ;

class randomPickWithBlackList {
    HashMap<Integer, Integer> map = new HashMap<>() ;
    Random r ;
    int top ;
    HashSet<Integer> set ;
    
    public randomPickWithBlackList(int n, int[] blacklist) {
        map = new HashMap<>() ;
        r = new Random() ;
        top = n - blacklist.length ;
        
        set = new HashSet<>() ;
        for(int i = 0; i < blacklist.length; i++){
            set.add(blacklist[i]) ;
        }
        n -- ;
        
        for(int i = 0; i < blacklist.length; i++){
            if(blacklist[i] < top){
                while(set.contains(n) == true){
                    n -- ;
                }
                map.put(blacklist[i], n) ;
                n -- ;
            }
        }
        
    }
    
    public int pick() {
        int randomIdx = r.nextInt(top) ;
        if(map.containsKey(randomIdx) == true){
            return map.get(randomIdx) ;
        }
        return randomIdx ;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */