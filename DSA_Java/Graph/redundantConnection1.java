//Ques Link - https://leetcode.com/problems/redundant-connection/
import java.util.* ;

class redundantConnection1 {
    //     public int[] findRedundantConnection(int[][] edges) {
            
    //     }
        public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1] ;
        int[] rank = new int[edges.length + 1] ;
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        
        for (int edge[] : edges) {
          int x = edge[0] ;
          int y = edge[1] ;
          
          boolean isUnion = union(x, y, parent, rank) ;
          if(isUnion == true){
            continue ;
          }else{
              return edge ;
          }
        }
        
        return new int[2] ;
      }
        
        boolean union(int x, int y, int[] parent, int rank[]) {
         int lx = find(parent, x) ;
          int ly = find(parent, y) ;
    
          if (lx != ly) {
            if (rank[lx] > rank[ly]) {
              parent[ly] = lx ;
    
            } else if (rank[ly] > rank[lx]) {
              parent[lx] = ly ;
    
            } else {
              parent[lx] = ly ;
              rank[ly] ++ ;
            }
            return true ;
          }
        return false ;
      }
        
     static int find(int[] parent, int x) {
        if (parent[x] == x) {
          return x ;
        }
    
        int ans = find(parent, parent[x]) ;
        parent[x] = ans ;
        return ans ;
      }
    }