import java.util.* ;
//Leetcode 934 - https://leetcode.com/problems/shortest-bridge/
class shortestBridge {
    public class Pair{
        int row ;
        int col ;
        
        Pair(int row, int col){
            this.row = row ;
            this.col = col ;
        }
    }
    
    public int shortestBridge(int[][] A) {
    LinkedList<Pair> queue = new LinkedList<>() ;
    boolean[][] visited = new boolean[A.length][A[0].length] ;
    boolean flag = false ;
    
    for(int i = 0; i < A.length && !flag; i++){
        for(int j = 0; j < A[0].length && !flag; j++){
            if(A[i][j] == 1){
                dfs(i, j, A, queue, visited) ;
                flag = true ;
            }
        }
    }
    
    int level = 0 ;
    while(queue.size() > 0){
        int size = queue.size() ;
        
        while(size --> 0){
            Pair rem = queue.removeFirst() ;
            
            for(int i = 0; i < 4; i++){
                int rdash = rem.row + dirs[i][0] ;
                int cdash = rem.col + dirs[i][1] ;
                
                // if(rdash >= 0 && cdash >= 0 && rdash < A.length && cdash < A[0].length && visited[rdash][cdash] == false){
                    
                //     if(A[rdash][cdash] == 1){
                //         return level ;
                //     }
                    
                //     queue.addLast(new Pair(rdash, cdash)) ;
                //     visited[rdash][cdash] = true ;
                // }
                
                if(rdash < 0 || cdash < 0 || rdash >= A.length || cdash >= A[0].length || visited[rdash][cdash] == true){
                    continue ;
                }
                
                if(A[rdash][cdash] == 1){
                    return level ;
                }
                
                queue.addLast(new Pair(rdash, cdash)) ;
                visited[rdash][cdash] = true ;
            }
        }
        level ++ ;
    }
    
    return -1 ;
  }
  
  int[][] dirs = {
      {-1, 0} ,
      {0, -1} ,
      {0, 1} ,
      {1, 0}
  } ;
  
  public void dfs(int i, int j, int[][] A, LinkedList<Pair> queue, boolean[][] visited){
      visited[i][j] = true ;
      queue.addLast(new Pair(i, j)) ;
      
      for(int k = 0; k < 4; k++){
          int rdash = i + dirs[k][0] ;
          int cdash = j + dirs[k][1] ;
          
          if(rdash < 0 || cdash < 0 || rdash >= A.length || cdash >= A[0].length || visited[rdash][cdash] == true || A[rdash][cdash] == 0){
              continue ;
          }
          
          dfs(rdash, cdash, A, queue, visited) ;
      }
  }
}