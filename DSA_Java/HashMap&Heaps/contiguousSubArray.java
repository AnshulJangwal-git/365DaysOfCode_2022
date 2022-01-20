import java.util.* ;
//Leetcode525 - https://leetcode.com/problems/contiguous-array/
class Solution {
    public int findMaxLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>() ;
        map.put(0, -1) ;
        
        int sum = 0 ;
        int max = 0 ;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                sum += -1 ;
                
            }else if(arr[i] == 1){
                sum += 1 ;
            }
            
            if(map.containsKey(sum) == true){
                int len = i - map.get(sum) ;
                if(max < len){
                    max = len ;
                }
            }else{
                map.put(sum, i) ;
            }
        }
        return max ;
    }
}