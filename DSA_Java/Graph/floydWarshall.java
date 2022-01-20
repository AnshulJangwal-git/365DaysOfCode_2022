//Ques Link - https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1/
import java.util.* ;

class floydWarshall
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length ;
        int[][] cost = new int[n][n] ;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == -1){
                    cost[i][j] = Integer.MAX_VALUE ;
                    
                }else{
                    cost[i][j] = matrix[i][j] ;
                }
            }
        }
        
        //selecting intermediate..
        for(int k = 0; k < n; k++){
            //selecting src
            for(int u = 0; u < n; u++){
                //selecting dest
                for(int v = 0; v < n; v++){
                    
                    if(u != v && u != k && v != k &&
                        cost[u][k] != Integer.MAX_VALUE &&
                        cost[k][v] != Integer.MAX_VALUE){
                            
                            if(cost[u][k] + cost[k][v] < cost[u][v]){
                                cost[u][v] = cost[u][k] + cost[k][v] ;
                                
                            }
                        }
                }
            }
        }
        //copy to original matirx ..
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(cost[i][j] == Integer.MAX_VALUE){
                    matrix[i][j] = -1 ;
                    
                }else{
                    matrix[i][j] = cost[i][j] ;
                    
                }
            }
        }
        
        
    }
}

