//Ques Link - https://leetcode.com/problems/rabbits-in-forest/submissions/
import java.util.* ;
class rabbitsInTheForest {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>() ;
        for(int val : answers){
            map.put(val , map.getOrDefault(val, 0) + 1) ;
        }
        
        int ans = 0 ;
        for(int key : map.keySet()){
            double gs = (double)(key + 1) ;
            double reportedRabbits = (double)map.get(key) ;
            
            int ng = (int)Math.ceil(reportedRabbits / gs) ;
            
            ans += (int)gs * ng ;
        }
        return ans ;
    }
    
}
