//Ques Link - https://practice.geeksforgeeks.org/problems/check-arithmetic-progression1842/1/#
import java.util.* ;
class checkArithmeticSequence
{
    boolean checkIsAP(int arr[] ,int n)
    {
        if(arr.length <= 1){
            return true ;
        }
         HashSet<Integer> set = new HashSet<>() ;
        
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        
        for(int val : arr){
            max = Math.max(max, val) ;
            min = Math.min(min, val) ;
            
            set.add(val) ;
        }
        
        for(int i = 0; i < arr.length; i++){
            int d = (max - min) / (arr.length - 1) ;
            int ai = min + i * d ;
            
            if(set.contains(ai) == false){
                return false ;
            }
        }
        return true ;
    }
}
