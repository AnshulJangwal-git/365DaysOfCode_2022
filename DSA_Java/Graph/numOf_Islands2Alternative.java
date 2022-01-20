import java.util.*;
import java.io.*;

public class numOf_Islands2Alternative {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }

  static int[][] dirs = {
      {-1, 0} ,
      {0, -1} ,
      {1, 0} ,
      {0, 1}
  } ;

  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> ans = new ArrayList<>() ;
    if(m <= 0 || n <= 0){
        return ans ;
    }

    int count = 0 ;
    int[] par = new int[m * n] ;
    int rank[] = new int[m * n] ;

    Arrays.fill(par, -1) ;

    for(int i = 0; i < positions.length; i++){
        int row = positions[i][0] ;
        int col = positions[i][1] ;

        int cellno = row * n + col ;

        if(par[cellno] != -1){
            ans.add(count) ;
            continue ;
        }

        par[cellno] = cellno ;
        rank[cellno] = 1 ;
        count ++ ;

        for(int dir[] : dirs){
            int rdash = row + dir[0] ;
            int cdash = col + dir[1] ;

            int celldash = rdash * n + cdash ;

            if(rdash < 0 || cdash < 0 || rdash >= m || cdash >= n || par[celldash] == -1){
                continue ;
            }

            int lx = find(cellno, par) ; //src
            int ly = find(celldash, par) ; //nbrs

            if(lx != ly){
                if(rank[lx] > rank[ly]){
                    par[ly] = lx ;

                }else if(rank[lx] < rank[ly]){
                    par[lx] = ly ;

                }else{
                    par[lx] = ly ;
                    rank[ly] ++ ;
                }
                count -- ;
            }
        }
        ans.add(count) ;
    }
    return ans ;
  }

  static int find(int x, int par[]){
      if(par[x] == x){
          return x ;
      }

      int ans = find(par[x], par) ;
      par[x] = ans ;
      return ans ;
  }

}
