import java.util.* ;
// https://practice.geeksforgeeks.org/problems/subarrays-with-sum-k/1/#

class subArraysWithKsum
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        int count = 0 ;
        HashMap<Integer, Integer> map = new HashMap<>() ;
        map.put(0, 1) ;
        
        int sum = 0 ;
        
        for(int i = 0; i < Arr.length; i++){
            sum += Arr[i] ;
            int rsum = sum - k ;
            
            if(map.containsKey(rsum)){
                count += map.getOrDefault(rsum, 0) ;
                
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1) ;
        }
        return count ;
    }
}