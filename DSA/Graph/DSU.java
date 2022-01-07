public class DSU {
    static int[] par ;
    public static void main(String[] args){
        int[][] relations = {
            {1, 2}, 
            {3, 4},
            {2, 4},
            {5, 6},
            {4, 5}
        } ;

        int n = 6 ;
        par = new int[n + 1] ;
        for(int i = 1; i <= n; i++){
            par[i] = i ;
        }
        
        for(int i = 0; i < relations.length; i++){
            int x = relations[i][0] ;
            int y = relations[i][1] ;

            union(x, y) ;
        }

        int gc = 0 ; //group counts
        //find number of groups..
        for(int i = 1; i <= n; i++){
            if(par[i] == i){
                //i is a set leader..
                gc ++ ;
            }
        }
        System.out.println(gc) ;
    }
    public static void union(int x, int y){
        int lx = find(x) ;
        int ly = find(y) ;

        par[lx] = ly ;
    }

    static int find(int x){
        if(par[x] == x){
            return x ;
        }else{
            return find(par[x]) ;
        }

    }
}
