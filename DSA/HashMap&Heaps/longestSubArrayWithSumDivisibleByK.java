//https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1#

// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class longestSubArrayWithSumDivisibleByK{
    int longSubarrWthSumDivByK(int arr[], int n, int k)
    {
        // Complete the function
        HashMap<Integer, Integer> map = new HashMap<>() ;
        int sum = 0 ;
        int ans = 0 ;
        
        map.put(0, -1) ;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i] ;
            int rem = sum % k ;
            
            if(rem < 0){
                rem += k ;
            }
            
            if(map.containsKey(rem) == true){
                int len = i - map.get(rem) ;
                if(len > ans){
                    ans = len ;
                }
            }else{
                map.put(rem, i) ;
            }
        }
        return ans ;
    }
 
}



  
