//Leetcode - https://leetcode.com/problems/swim-in-rising-water/submissions/

import java.util.* ;

class swimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length ;
        PriorityQueue<Pair> pq = new PriorityQueue<>() ;
        pq.add(new Pair(0, 0, grid[0][0])) ;
        
        boolean visited[][] = new boolean[n][n] ;
        
        while(pq.size() > 0){
            Pair rem = pq.remove() ; //remove
            
            if(visited[rem.row][rem.col] == true){
                continue ;
            }
            
            visited[rem.row][rem.col] = true ; //mark*
            
            //work
            if(rem.row == n - 1 && rem.col == n - 1){
                return rem.time ;
            }
            
            int[][] dirs = {
                {-1, 0} ,
                {0, 1} ,
                {1, 0} ,
                {0, -1}
            } ;
            
            for(int i = 0; i < dirs.length; i++){
                int rdash = rem.row + dirs[i][0] ;
                int cdash = rem.col + dirs[i][1] ;
                
                if(rdash < 0 || cdash < 0 || rdash >= n || cdash >= n || visited[rdash][cdash] == true){
                    continue ;
                }
                
                pq.add(new Pair(rdash, cdash, Math.max(rem.time, grid[rdash][cdash]) )) ;
            }
        }
        return -1 ;
    }
    
    public class Pair implements Comparable<Pair>{
        int row ;
        int col ;
        int time ;
        
        Pair(int row, int col, int time){
            this.row = row ;
            this.col = col ;
            this.time = time ;
        }
        //@override
        public int compareTo(Pair o){
            return this.time - o.time ;
        }
    }
    
}
