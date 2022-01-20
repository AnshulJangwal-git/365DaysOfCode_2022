//https://leetcode.com/problems/subarray-sums-divisible-by-k/
import java.util.* ;

class countOfSubarraysSumDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        if(nums.length == 0){
            return 0 ;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>() ;
        int count = 0 ;
        int sum = 0 ;
        
        map.put(0, 1) ; //map.put(rem, freq)
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i] ;
            int rem = sum % k ;
            
            if(rem < 0){
                rem += k ;
            }
            
            if(map.containsKey(rem) == true){
                count += map.get(rem) ;
                map.put(rem, map.getOrDefault(rem, 0) + 1) ;
                
            }else{
                map.put(rem, 1) ;
                
            }
        }
        
        return count ;
    }
}
