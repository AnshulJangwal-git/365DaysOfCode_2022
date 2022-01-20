//Leetcode 914 - https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
import java.util.* ;

class XofAKindInADeck {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>() ;
        for(int val : deck){
            map.put(val, map.getOrDefault(val, 0) + 1) ;
        }
        int ans = 0 ;
        for(int key : map.keySet()){
            ans = gcd(ans, map.get(key)) ;
        }
        
        return ans >= 2 ? true : false ;
    }
    
    public int gcd(int a, int b){
        if(b == 0){
            return a ;
        }
        
        return gcd(b, a % b) ;
    }
    
}
