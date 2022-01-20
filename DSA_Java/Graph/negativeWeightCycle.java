import java.util.* ;
import java.lang.* ;
import java.io.* ;

class negativeWeightCycle
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int[] path = new int[n] ;
        Arrays.fill(path, Integer.MAX_VALUE) ;
        path[0] = 0 ;
        
        for(int i = 0; i < n - 1; i++){
            for(int edge[] : edges){
                int u = edge[0] ;
                int v = edge[1] ;
                int wt = edge[2] ;
                
                if(path[u] != Integer.MAX_VALUE && path[u] + wt < path[v]){
                    path[v] = path[u] + wt ;
                }
            }
        }
        
        for(int j = 0; j < edges.length; j++){
            int u = edges[j][0] ;
            int v = edges[j][1] ;
            int wt = edges[j][2] ;
            
            if(path[u] == Integer.MAX_VALUE){
                continue ;
            }
            
            if(path[u] + wt < path[v]){
                return 1 ;
            }
        }
        return 0 ;
    }
}