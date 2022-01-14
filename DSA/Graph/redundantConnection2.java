//Leetcode 685 - https://leetcode.com/problems/redundant-connection-ii/
import java.util.* ;
public class redundantConnection2 {
    int[] parent ;
    int rank[] ;
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int indegree[] = new int[edges.length + 1] ;
        Arrays.fill(indegree, -1) ;
        
        int bl1 = -1 ;
        int bl2 = -1 ;
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0] ;
            int v = edges[i][1] ;
            
            if(indegree[v] == -1){
                indegree[v] = i ;
                
            }else{
                bl1 = i ;
                bl2 = indegree[v] ;
            }
        }
        
        parent = new int[edges.length + 1] ;
        rank = new int[edges.length + 1] ;
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        
        for(int i = 0; i < edges.length; i++){
            if(i == bl1){
                continue ;
            }
            
            int u = edges[i][0] ;
            int v = edges[i][1] ;
            
            boolean flag = union(u, v) ;
            if(flag == true){ // same leader cycle present..
                if(bl1 == -1){ // case2
                    return edges[i] ;
                    
                }else{
                    return edges[bl2] ;  //case 3(2 parent + cycle present)
                    
                }
            }
        }
        return edges[bl1] ; // case 1()
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x ;
        }
        int ans = find(parent[x]) ;
        parent[x] = ans ; 
        return ans ;
    }
    
    public boolean union(int x, int y){
        int lx = find(x) ;
        int ly = find(y) ;
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx ;
                
            }else if(rank[ly] > rank[lx]){
                parent[lx] = ly ;
                
            }else{
                parent[lx] = ly ;
                rank[ly] ++ ;
                
            }
            return false ;
        }
        
        return true ;
    }
}

















