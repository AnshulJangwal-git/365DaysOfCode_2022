import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class bellmanFord {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        
        String[] st = br.readLine().split(" ") ;
        int vtces = Integer.parseInt(st[0]) ;
        int edges = Integer.parseInt(st[1]) ;
        
        int[][] arr = new int[edges][3] ;
        
        for(int i = 0; i < edges; i++){
            st = br.readLine().split(" ") ;
            
            arr[i][0] = Integer.parseInt(st[0]) - 1 ;
            arr[i][1] = Integer.parseInt(st[1]) - 1 ;
            arr[i][2] = Integer.parseInt(st[2]) ;
        }
        
        int[] path = new int[vtces] ;
        Arrays.fill(path, Integer.MAX_VALUE) ;
        path[0] = 0 ;
        
        for(int i = 0; i < vtces - 1; i++){
            for(int j = 0; j < edges; j++){
                int u = arr[j][0] ;
                int v = arr[j][1] ;
                int wt = arr[j][2] ;
                
                if(path[u] == Integer.MAX_VALUE){
                    continue ;
                }
                
                if(path[u] + wt < path[v]){
                    path[v] = path[u] + wt ;
                }
                
            }
        }
        
        for(int i = 1; i < vtces; i++){
            if(path[i] != Integer.MAX_VALUE){
                System.out.print(path[i] + " ") ;
                
            }else{
                System.out.print("1000000000 ") ;
            }
        }
    }
    
    
}
















