//Leetcode 1488 - https://leetcode.com/problems/avoid-flood-in-the-city/
import java.util.* ;

class avoidFloodInTheCity {
    HashMap<Integer, Integer> map ;
    TreeSet<Integer> set ;
    int[] ans ;
    public int[] avoidFlood(int[] rains) {
        map = new HashMap<>() ;
        set = new TreeSet<>() ;
        ans = new int[rains.length] ;
        
        int n = rains.length ;
        for(int i = 0; i < rains.length; i++){
            if(rains[i] == 0){
                set.add(i) ;
                ans[i] = 1 ;
                
            }else{
                Integer idx = map.get(rains[i]) ;
                if(idx == null){
                    map.put(rains[i], i) ;
                    
                }else{
                    Integer higherIdx = set.higher(idx) ;
                    if(higherIdx == null){
                        return new int[0] ;
                    }
                    ans[higherIdx] = rains[i] ;
                    set.remove(higherIdx) ;
                    
                    map.put(rains[i], i) ;
                }
                ans[i] = -1 ;
                
            }
        }
        return ans ;
    }
}
