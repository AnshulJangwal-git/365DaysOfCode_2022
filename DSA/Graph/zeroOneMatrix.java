import java.util.* ;
//Leetcode 542 - https://leetcode.com/problems/01-matrix/
public class zeroOneMatrix {
    public int[][] updateMatrix(int[][] arr) {
        ArrayDeque<Pair> queue = new ArrayDeque<>() ;
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0){
                    queue.addLast(new Pair(i, j)) ;
                    
                }else{
                    arr[i][j] = -1 ;
                }
            }
        }
        
        while(queue.size() > 0){
            Pair rem = queue.removeFirst() ;
            
            for(int i = 0; i < dirs.length; i++){
                int rdash = rem.row + dirs[i][0] ;
                int cdash = rem.col + dirs[i][1] ;
                
                if(rdash >= 0 && cdash >= 0 && rdash < arr.length && cdash < arr[0].length && arr[rdash][cdash] < 0){
                    arr[rdash][cdash] = arr[rem.row][rem.col] + 1 ;
                    queue.addLast(new Pair(rdash, cdash)) ;
                }
            }
        }
        return arr ;
    }
    
    static class Pair{
        int row ;
        int col ;
        
        Pair(int row, int col){
            this.row = row ;
            this.col = col ;
        }
    }
    
    int[][] dirs = {
        
        {0, -1} ,
        {-1, 0} ,
        {0, 1} ,
        {1, 0}
    } ;
}
