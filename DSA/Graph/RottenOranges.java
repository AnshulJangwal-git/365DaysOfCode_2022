// package DSA.Graph;
import java.util.* ;
import java.io.* ;
//Ques link - https://leetcode.com/problems/rotting-oranges/

public class RottenOranges {
    static class Pair{
        int row ;
        int col ;
        
        Pair(int row, int col){
            this.row = row ;
            this.col = col ;
        }
    }
    
    public int orangesRotting(int[][] arr) {
        ArrayDeque<Pair> que = new ArrayDeque<>() ;
        int countFreshOranges = 0 ;
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 2){
                    que.addLast(new Pair(i, j)) ;
                    
                }else if(arr[i][j] == 1){
                    countFreshOranges += 1 ;
                    
                }
            }
        }
        if(countFreshOranges == 0){
            return 0 ;
        }
        int time = -1 ;
    
        int[][] dirs = { //direction Array..
            {-1, 0}, 
            {0, 1},
            {1, 0},
            {0, -1}
        } ;
        
        while(que.size() > 0){
            int size = que.size() ;
            // time ++ ;
            
            while(size --> 0){
                Pair rem = que.removeFirst() ;
                for(int i = 0; i < dirs.length; i++){
                    int r = rem.row + dirs[i][0] ;
                    int c = rem.col + dirs[i][1] ;
                    
                    if(r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && arr[r][c] == 1){
                        que.addLast(new Pair(r, c)) ;
                        arr[r][c] = 2 ;
                        countFreshOranges -- ;
                    }
                }
            }
            
            time ++ ;
        }
        
        if(countFreshOranges == 0){
            return time ;
            
        }else{
            return -1 ;
            
        }
    }
}


