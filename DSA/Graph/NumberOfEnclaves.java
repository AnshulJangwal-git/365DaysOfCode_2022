// package DSA.Graph;
//Ques Link - https://nados.pepcoding.com/content/eb9863ac-63ac-4b94-881f-0aeb24df0985/0c54b191-7b99-4f2c-acb3-e7f2ec748b2a/7fdb0602-0ac9-4484-aff9-a898aed5cd28/d108313e-68c8-4fc6-bb02-6e9a9010ef9e/7e07fddf-83bd-421e-848f-118f1f29541c/question/1310f58d-c780-4a3f-b719-4ab16494339a

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);

    int[][] arr = new int[m][n];

    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numEnclaves(arr));

  }

  public static int numEnclaves(int[][] arr) {
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(i == 0 || j == 0 || i == arr.length - 1 || j == arr[0].length - 1){
                    if(arr[i][j] == 1){
                        dfs(arr, i, j) ;
                    }
                }
            }
        }
        int count = 0 ;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 1){
                    count ++ ;
                }
            }
        }
        return count ;
    }

    public static void dfs(int[][] arr, int i, int j){
        arr[i][j] = 0 ;
        
        if(i - 1 >= 0 && arr[i - 1][j] == 1){
            dfs(arr, i - 1, j) ;
        }
        
        if(j - 1 >= 0 && arr[i][j - 1] == 1){
            dfs(arr, i, j - 1) ;
        }
        
        if(i + 1 < arr.length && arr[i + 1][j] == 1){
            dfs(arr, i + 1, j) ;
        }
        
        if(j + 1 < arr[0].length && arr[i][j + 1] == 1){
            dfs(arr, i, j + 1) ;
        }
    }
}

//Leetcode1020 - https://leetcode.com/problems/number-of-enclaves/

// class Solution {
//     public int numEnclaves(int[][] arr) {
//         for(int i = 0; i < arr.length; i++){
//             for(int j = 0; j < arr[0].length; j++){
//                 if(i == 0 || j == 0 || i == arr.length - 1 || j == arr[0].length - 1){
//                     if(arr[i][j] == 1){
//                         dfs(arr, i, j) ;
//                     }
//                 }
//             }
//         }
//         int count = 0 ;
//         for(int i = 0; i < arr.length; i++){
//             for(int j = 0; j < arr[0].length; j++){
//                 if(arr[i][j] == 1){
//                     count ++ ;
//                 }
//             }
//         }
//         return count ;
//     }
    
//     public static void dfs(int[][] arr, int i, int j){
//         arr[i][j] = 0 ;
        
//         if(i - 1 >= 0 && arr[i - 1][j] == 1){
//             dfs(arr, i - 1, j) ;
//         }
        
//         if(j - 1 >= 0 && arr[i][j - 1] == 1){
//             dfs(arr, i, j - 1) ;
//         }
        
//         if(i + 1 < arr.length && arr[i + 1][j] == 1){
//             dfs(arr, i + 1, j) ;
//         }
        
//         if(j + 1 < arr[0].length && arr[i][j + 1] == 1){
//             dfs(arr, i, j + 1) ;
//         }
//     }
    
// }
