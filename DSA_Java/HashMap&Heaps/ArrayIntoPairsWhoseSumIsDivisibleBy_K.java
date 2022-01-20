//Ques Link - https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
import java.util.* ;

public class ArrayIntoPairsWhoseSumIsDivisibleBy_K {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> rfmap = new HashMap<>() ;
        for(int val : arr){
            int rem = val % k ;
            rem = rem < 0 ? rem + k : rem ; //converting negative values to positive
            
            // int of = rfmap.getOrDefault(rem, 0) ;
            rfmap.put(rem, rfmap.getOrDefault(rem, 0) + 1) ;
        }
        
        for(int val : arr){
            int rem = val % k ;
            rem = rem < 0 ? rem + k : rem ;
            
            if(rem == 0 || 2 * rem == k){
                int fq = rfmap.get(rem) ;
                if(fq % 2 != 0){
                    return false ;
                }
                
            }else{
                int of = rfmap.get(rem) ;
                int nf = rfmap.getOrDefault(k - rem, 0) ;
                if(of != nf){
                    return false ;
                }
                
            }
        }
        return true ;
    }
}
