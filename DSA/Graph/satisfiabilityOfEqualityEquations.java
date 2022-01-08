//Leetcode 990 - https://leetcode.com/problems/satisfiability-of-equality-equations/
import java.util.* ;
class satisfiabilityOfEqualityEquations {
    static int[] parent ;
    static int[] rank ;
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26] ;
        rank = new int[26] ;
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        
        for(String eqn : equations){
            if(eqn.charAt(1) == '='){
                union(eqn.charAt(0) - 'a', eqn.charAt(3) - 'a') ;
            }
        }
        
        for(String eqn : equations){
            if(eqn.charAt(1) == '!'){
                int lx = find(eqn.charAt(0) - 'a') ;
                int ly = find(eqn.charAt(3) - 'a') ;
                
                if(lx == ly){
                    return false ;
                }
            }
        }
        return true ;
    }
    
    public static void union(int x, int y){
        int lx = find(x) ; //leader of x 
        int ly = find(y) ; //leader of y
        
        //union by rank in DSU
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx ;
                
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly ;
                
            }else{
                parent[lx] = ly ;
                rank[ly] ++ ;
                
            }
        }
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x ;
        }
        
        int ans = find(parent[x]) ;
        parent[x] = ans ; //path compression in DSU
        
        return ans ;
    }
    
}


// import java.io.*;
// import java.util.*;

// public class Main {

//   public static void main(String[] args) throws Exception {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     int n = Integer.parseInt(br.readLine());

//     String[] arr = new String[n];
//     for (int i = 0; i < n; i++) {
//       arr[i] = br.readLine();
//     }

//     System.out.println(equationsPossible(arr));
//   }

//   public static boolean equationsPossible(String[] equations) {
//     int[] parent = new int[26] ;
//     int[] rank = new int[26] ;
    
//     for(int i = 0; i < parent.length; i++){
//         parent[i] = i ;
//         rank[i] = 1 ;
//     }
    
//     for(String eq : equations){
//         if(eq.charAt(1) == '='){
//             union(eq.charAt(0) - 'a', eq.charAt(3) - 'a', parent, rank) ;
//         }
//     }
    
//     for(String eq : equations){
//         if(eq.charAt(1) == '!'){
//             int lx = find(eq.charAt(0) - 'a', parent) ;
//             int ly = find(eq.charAt(3) - 'a', parent) ;
            
//             if(lx == ly){
//                 return false ;
//             }
//         }
//     }
//     return true ;
//   }
  
//   public static void union(int x, int y, int[] parent, int[] rank){
//       int lx = find(x, parent) ;
//       int ly = find(y, parent) ;
      
//       if(lx != ly){
//           if(rank[lx] > rank[ly]){
//               parent[ly] = lx ;
              
//           }else if(rank[ly] > rank[lx]){
//               parent[lx] = ly ;
              
//           }else{
//               parent[lx] = ly ;
//               rank[ly] ++ ;
              
//           }
//       }
//   }
  
//   public static int find(int x, int parent[]){
//     if(parent[x] == x){
//         return x ;
//     }
    
//     int ans = find(parent[x], parent) ;
//     parent[x] = ans ; //path compression in DSU
//     return ans ;
//   }
  
// }



