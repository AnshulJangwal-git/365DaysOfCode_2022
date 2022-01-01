package DSA.Graph;
import java.io.* ;
import java.util.* ;

public class NumberOfIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];
  
        for (int i = 0; i < arr.length; i++) {
           String parts = br.readLine();
           for (int j = 0; j < arr[0].length; j++) {
              arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
           }
        }
  
        // write your code here
        boolean[][] visited = new boolean[arr.length][arr[0].length] ;
        int count = 0 ;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 0 && visited[i][j] == false){
                    dfs(arr, i, j, visited) ;
                    count ++ ;
                }
            }
        }
        System.out.println(count) ;
     }

     static void dfs(int[][] arr, int i, int j, boolean[][] visited){
         if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j] == true){
             return ;
         }

         visited[i][j] = true ;

         dfs(arr, i - 1, j, visited) ;
         dfs(arr, i, j - 1, visited) ;
         dfs(arr, i + 1, j, visited) ;
         dfs(arr, i, j + 1, visited) ;
     }

}

//Leetcode200 Solution of Number Of Islands...
//Link - https://leetcode.com/problems/number-of-islands/

// class Solution {
//     public int numIslands(char[][] grid) {
//         int countOfComps = 0 ;
        
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 if(grid[i][j] == '1'){
//                     countOfComps ++ ;
//                     dfs(grid, i, j) ;
//                 }
//             }
//         }
//         return countOfComps ;
//     }
    
//     public static void dfs(char[][] grid, int i, int j){
//         if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
//             return ;
//         }
        
//         grid[i][j] = '0' ; //marking of visited
        
//         dfs(grid, i - 1, j) ;
//         dfs(grid, i, j + 1) ;
//         dfs(grid, i + 1, j) ;
//         dfs(grid, i, j - 1) ;
        
//     }
// }