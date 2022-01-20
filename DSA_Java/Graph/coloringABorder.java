import java.util.* ;
import java.io.* ;
//Ques link - https://leetcode.com/problems/coloring-a-border/
public class coloringABorder {
    public static int[][] colorBorder(int[][] arr, int row, int col, int color) {
        dfs(arr, row, col, arr[row][col]) ;
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] < 0){
                    arr[i][j] = color ;
                }
            }
        }
        return arr ;
    }

    public static int[][] dirs = {
        {-1, 0} ,
        {0, -1} ,
        {0, 1} ,
        {1, 0} 
    } ;

    public static void dfs(int[][] arr, int row, int col, int color){
        int count = 0 ;
        arr[row][col] = -color ;

        for(int i = 0; i < dirs.length; i++){
            int rdash = row + dirs[i][0] ;
            int cdash = col + dirs[i][1] ;

            if(rdash < 0 || cdash < 0 || rdash >= arr.length || cdash >= arr[0].length 
                  || Math.abs(arr[rdash][cdash]) != color ){
                      continue ;
                  }
          count ++ ;

          if(arr[rdash][cdash] == color){
              dfs(arr, rdash, cdash, color) ;
          }

        }

        if(count == 4){
            arr[row][col] = color ;
        }
    }

//    public static void main(String[] args) throws NumberFormatException, IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         String[] st = br.readLine().split(" ");
//         int m = Integer.parseInt(st[0]);
//         int n = Integer.parseInt(st[1]);
    
//         int[][] arr = new int[m][n];
    
//         for (int i = 0; i < m; i++) {
//           st = br.readLine().split(" ");
//           for (int j = 0; j < n; j++) {
//             arr[i][j] = Integer.parseInt(st[j]);
//           }
//         }
//         st = br.readLine().split(" ");
//         int row = Integer.parseInt(st[0]);
//         int col = Integer.parseInt(st[1]);
//         int color = Integer.parseInt(st[2]);
        
        
        
//         colorBorder(arr,row,col,color);
        
        
//         for (int i = 0; i < m; i++) {
//           for (int j = 0; j < n; j++) {
//             System.out.print(arr[i][j]+"\t");
//           }
//           System.out.println();
//         }
//       }

}
