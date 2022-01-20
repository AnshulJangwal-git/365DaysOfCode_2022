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

// Alternative SOlution...

// class Solution {
//     int[][] dirs = {
//         {-1, 0} ,
//         {0, -1} ,
//         {0, 1} ,
//         {1, 0}
//     } ;
    
//     public int[][] updateMatrix(int[][] mat) {
//         ArrayDeque<Pair> queue = new ArrayDeque<>() ;
//         for(int i = 0; i < mat.length; i++){
//             for(int j = 0; j < mat[0].length; j++){
//                 if(mat[i][j] == 0){
//                     queue.add(new Pair(i, j)) ;
                    
//                 }else{
//                     mat[i][j] = -1 ; //mark all 1's unvisited..
                    
//                 }
//             }
//         }
//         int level = 0 ;
//         while(queue.size() > 0){
//             int size = queue.size() ;
//             level ++ ;
            
//             while(size-->0){
//                 Pair rem = queue.removeFirst() ;
                
//                 for(int i = 0; i < dirs.length; i++){
//                     int rdash = rem.row + dirs[i][0] ;
//                     int cdash = rem.col + dirs[i][1] ;
                    
//                     if(rdash >= 0 && cdash >= 0 && rdash < mat.length && cdash < mat[0].length && mat[rdash][cdash] == -1){
//                         queue.add(new Pair(rdash, cdash)) ;
//                         mat[rdash][cdash] = level ;
//                     }
//                 }
//             }
//         }
//         return mat ;
//     }
//     static class Pair{
//         int row ;
//         int col ;
        
//         Pair(int row, int col){
//             this.row = row ;
//             this.col = col ;
//         }
//     }    
// }
