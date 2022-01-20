// package DSA.Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumberOfDistinctIslands {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
    
        int[][] arr = new int[n][m];
    
        for (int i = 0; i < n; i++) {
          st = br.readLine().split(" ");
          for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
          }
        }
    
        System.out.println(numDistinctIslands(arr));
        
      }

  static StringBuilder comp = new StringBuilder() ;
  public static int numDistinctIslands(int[][] arr) {
    //write your code here
    HashSet<String> set = new HashSet<>() ;

    for(int i = 0; i < arr.length; i++){
        for(int j = 0; j < arr[0].length; j++){
            if(arr[i][j] == 1){
                comp = new StringBuilder() ;
                dfs(arr, i, j) ;
                set.add(comp.toString()) ;
            }
        }
    }
    return set.size() ;
  }

      public static void dfs(int[][] arr, int i, int j){
        arr[i][j] = 0 ;
  
        if(i - 1 >= 0 && arr[i - 1][j] == 1){
            comp.append('t') ;
            dfs(arr, i - 1, j) ;
        }
  
        if(j - 1 >= 0 && arr[i][j - 1] == 1){
            comp.append('l') ;
            dfs(arr, i, j - 1) ;
        }
  
        if(i + 1 < arr.length && arr[i + 1][j] == 1){
            comp.append('d') ;
            dfs(arr, i + 1, j) ;
        }
  
        if(j + 1 < arr[0].length && arr[i][j + 1] == 1){
            comp.append('r') ;
            dfs(arr, i, j + 1) ;
        }
  
        comp.append("backtrack") ;
    }
}






//LintCode 860
//Ques Link - https://www.lintcode.com/problem/860/

// public class Solution {
//     /**
//      * @param grid: a list of lists of integers
//      * @return: return an integer, denote the number of distinct islands
//      */


//     public static StringBuilder comp = new StringBuilder() ;
//     public int numberofDistinctIslands(int[][] arr) {
//         // write your code here
//         HashSet<String> set = new HashSet<>() ;
//         for(int i = 0; i < arr.length; i++){
//             for(int j = 0; j < arr[0].length; j++){
//                 if(arr[i][j] == 1){
//                     comp = new StringBuilder() ;
//                     dfs(arr, i, j) ;
//                     set.add(comp.toString()) ;
//                 }
//             }
//         }
//         return set.size() ;
//     }

//     public static void dfs(int[][] arr, int i, int j){
//         arr[i][j] = 0 ;

//         if(i - 1 >= 0 && arr[i - 1][j] == 1){
//             comp.append('t') ;
//             dfs(arr, i - 1, j) ;
//         }

//         if(j - 1 >= 0 && arr[i][j - 1] == 1){
//             comp.append('l') ;
//             dfs(arr, i, j - 1) ;
//         }

//         if(i + 1 < arr.length && arr[i + 1][j] == 1){
//             comp.append('d') ;
//             dfs(arr, i + 1, j) ;
//         }

//         if(j + 1 < arr[0].length && arr[i][j + 1] == 1){
//             comp.append('r') ;
//             dfs(arr, i, j + 1) ;
//         }

//         comp.append("backtracking") ;
//     }
// }
