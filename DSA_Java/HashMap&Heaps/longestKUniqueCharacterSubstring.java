//Ques Link(GFG) - https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1#
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

// class longestKUniqueCharacterSubstring {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
//         int t = sc.nextInt();
//         while (t-- > 0) {
//             String s = sc.next();
//             int k = sc.nextInt();
//             Solution obj = new Solution();
//             System.out.println(obj.longestkSubstr(s, k));
//         }
//     }
// }// } Driver Code Ends


// User function Template for Java

class longestKUniqueCharacterSubstring {
    
    public static int longestkSubstr(String str, int k){
		// write your code here
		HashMap<Character, Integer> map = new HashMap<>() ;
		int ans = 0 ;
		int i = -1 ;
		int j = -1 ;
		
// 		HashMap<Character, Integer> map = new HashMap<>() ;
		
		while(true){
		    boolean f1 = false ;
		    boolean f2 = false ;
		    //Acquire..
		    while(i < str.length() - 1){
		        f1 = true ;
		        i ++ ;
		        char ch = str.charAt(i) ;
		        map.put(ch, map.getOrDefault(ch, 0) + 1) ;
		        
		        if(map.size() == k){
		            int len = i - j ;
		            if(len > ans){
		                ans = len ;
		            }
		            
		        }else if(map.size() > k){
		            break ;
		            
		        }else{
		            continue ;
		        }
		    }
		    
		    while(j < i){
		        f2 = true ;
		        j ++ ;
		        char ch = str.charAt(j) ;
		        if(map.get(ch) == 1){
		            map.remove(ch) ;
		            
		        }else{
		            map.put(ch, map.getOrDefault(ch, 0) - 1) ;
		            
		        }
		        
		        if(map.size() > k){
		            continue ;
		            
		        }else if(map.size() == k){
		            int len = i - j ;
		            if(len > ans){
		                ans = len ;
		            }
		            break ;
		        }
		    }
		    
		    if(f1 == false && f2 == false){
		        break ;
		    }
		    
		}
        
		return ans == 0 ? -1 : ans;
	}
}