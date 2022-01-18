//Ques Link -  https://practice.geeksforgeeks.org/problems/required-rooms3939/1/


// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int M = Integer.parseInt(a[1]);
            
            requiredRooms ob = new requiredRooms();
            System.out.println(ob.rooms(N, M));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class requiredRooms{
    static int rooms(int N, int M){
        int temp = gcd(N, M) ;
        
        int ans1 = N / temp ;
        int ans2 = M / temp ;
        
        return ans1 + ans2 ;
    }
    
    static int gcd(int a, int b){
        if(b == 0){
            return a ;
        }
        
        return gcd(b, a % b) ;
    }
    
}

