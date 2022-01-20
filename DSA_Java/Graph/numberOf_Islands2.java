import java.util.* ;
//LintCode434 - https://www.lintcode.com/problem/434/

public class numberOf_Islands2 {
    // /**
    //  * @param n: An integer
    //  * @param m: An integer
    //  * @param operators: an array of point
    //  * @return: an integer array
    //  */

    static class Point{
        int x ;
        int y ;

        Point(int x, int y){
            this.x = x ;
            this.y = y ;
        }
        
    }

    static int par[] ;
    static int[] rank ;

    static int[][] dirs = {
        {-1, 0} ,
        {0, -1},
        {0, 1} ,
        {1, 0} 
    } ;

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> ans = new ArrayList<>() ;
        if(operators == null || operators.length == 0){
            return ans ;
        }

        int[][] mat = new int[n][m] ;

        par = new int[n * m] ;
        rank = new int[n * m] ;
        int count = 0 ;
        
        for(int i = 0; i < par.length; i++){
            par[i] = i ;
            rank[i] = 1 ;
        }

        for(int k = 0; k < operators.length; k++){
            int i = operators[k].x ;
            int j = operators[k].y ;

            if(mat[i][j] == 1){
                ans.add(count) ;
                continue ;
            }

            mat[i][j] = 1 ;
            count ++ ;

            for(int d = 0; d < dirs.length; d++){
                int ni = i + dirs[d][0] ;
                int nj = j + dirs[d][1] ;

                if(ni >= 0 && nj >= 0 && ni < n && nj < m && mat[ni][nj] == 1){
                    int sc = i * m + j ;   //src cell no
                    int nc = ni * m + nj ; //nbr cell no

                    //union by rank in DSU
                    int ls = find(sc) ; //leader of src
                    int ln = find(nc) ; //leader of nbr

                    if(ls != ln){
                        if(rank[ls] > rank[ln]){
                            par[ln] = ls ;

                        }else if(rank[ls] < rank[ln]){
                            par[ls] = ln ;

                        }else{
                            par[ls] = ln ;
                            rank[ln] ++ ;
                        }
                        count -- ;
                    }
                }
            }
            ans.add(count) ;
        }
        return ans ;
    }

    static int find(int x){
        if(par[x] == x){
            return x ;
        }

        int ans = find(par[x]) ;
        par[x] = ans ; //path compression in DSU
        return ans ;
    }
}
