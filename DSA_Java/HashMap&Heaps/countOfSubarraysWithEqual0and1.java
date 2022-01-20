//GFG -  https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1#

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
// class Driverclass
//  {
// 	public static void main (String[] args) {
	   
// 	   Scanner in = new Scanner(System.in);
// 	   int t= in.nextInt();
// 	   while(t-->0){
	       
// 	       int n = in.nextInt();
// 	       int [] arr= new int[n];
// 	       for(int i=0;i<n;i++) {
// 	           arr[i] = in.nextInt();
// 	       }
// 	       System.out.println(new countOfSubarraysWithEqual0and1().countSubarrWithEqualZeroAndOne(arr, n));
// 	   }
// 	 }
// }

// } Driver Code Ends


//User function Template for Java

class countOfSubarraysWithEqual0and1
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        int count = 0 ;
        HashMap<Integer, Integer> map = new HashMap<>() ;
        int sum = 0 ;
        
        map.put(0, 1) ; //map.put(sum, freq)
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                sum += -1 ;
            }else if(arr[i] == 1){
                sum += 1 ;
            }
            
            if(map.containsKey(sum) == true){
                count += map.get(sum) ;
                map.put(sum, map.getOrDefault(sum, 0) + 1) ;
                
            }else{
                map.put(sum, 1) ;
            }
        }
        return count ;
    }
}


