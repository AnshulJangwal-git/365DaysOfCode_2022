//Leetcode 954 - https://leetcode.com/problems/array-of-doubled-pairs/
import java.util.* ;

class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        if(arr.length == 0){
            return true ;
        }
        
        Integer[] sort = new Integer[arr.length] ;
        for(int i = 0; i < arr.length; i++){
            sort[i] = arr[i] ;
        }
        
        Arrays.sort(sort, (a, b) -> {
            return Math.abs(a) - Math.abs(b) ;
        }) ;
        
        HashMap<Integer, Integer> map = new HashMap<>() ;
        //freq Map
        for(Integer val : sort){
            map.put(val, map.getOrDefault(val, 0) + 1) ;
        }
        
        for(Integer val : sort){
            if(map.getOrDefault(val, 0) == 0){
                continue ;
            }
            
            if(map.getOrDefault(2 * val, 0) == 0){
                return false ;
            }
            
            map.put(val, map.get(val) - 1) ;
            map.put(2 * val, map.get(2 * val) - 1) ;
            
        }
        return true ;
    }
}