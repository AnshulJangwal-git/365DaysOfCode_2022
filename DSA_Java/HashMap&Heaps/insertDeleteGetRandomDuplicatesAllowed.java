//Leetcode 381 - https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
import java.util.* ;
class insertDeleteGetRandomDuplicatesAllowed {
    HashMap<Integer, HashSet<Integer>> map ;
    List<Integer> list ;
    Random r ;
    
    public insertDeleteGetRandomDuplicatesAllowed() {
        map = new HashMap<>() ;
        list = new ArrayList<>() ;
        r = new Random() ;
        
    }
    
    public boolean insert(int val) {
        HashSet<Integer> set ;
        boolean flag ;
        
        if(map.containsKey(val) == true){
            flag = false ;
            set = map.get(val) ;
            
        }else{
            set = new HashSet<>() ;
            flag = true ;
            
        }
        
        set.add(list.size()) ;
        list.add(val) ;
        map.put(val, set) ;
        
        return flag ;
    }
    
    public boolean remove(int val) {
        HashSet<Integer> set ;
        
        if(map.containsKey(val) == false){
            return false ;
            
        }else{
            set = map.get(val) ;            
        }
        
        int remIdx = -1 ;
        for(int i : set){
            remIdx = i ;
            break ;
        }
        
        set.remove(remIdx) ;
        map.put(val, set) ;
        
        if(map.get(val).size() == 0){
            map.remove(val) ;
        }
        
        if(remIdx == list.size() - 1){
            list.remove(list.size() - 1) ;
            
        }else{
            list.set(remIdx, list.get(list.size() - 1)) ;
            list.remove(list.size() - 1) ;
            
            int newVal = list.get(remIdx) ;
            HashSet<Integer> temp = map.get(newVal) ;
            temp.remove(list.size()) ;
            temp.add(remIdx) ;
            map.put(newVal, temp) ;
        }
        return true ;
    }
    
    
    public int getRandom() {
        int randomIdx = r.nextInt(list.size()) ;
        return list.get(randomIdx) ;
    }
    
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
