//Leetcode 990 - https://leetcode.com/problems/satisfiability-of-equality-equations/
import java.util.* ;
class satisfiabilityOfEqualityEquations {
    static int[] parent ;
    static int[] rank ;
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26] ;
        rank = new int[26] ;
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i ;
            rank[i] = 1 ;
        }
        
        for(String eqn : equations){
            if(eqn.charAt(1) == '='){
                union(eqn.charAt(0) - 'a', eqn.charAt(3) - 'a') ;
            }
        }
        
        for(String eqn : equations){
            if(eqn.charAt(1) == '!'){
                int lx = find(eqn.charAt(0) - 'a') ;
                int ly = find(eqn.charAt(3) - 'a') ;
                
                if(lx == ly){
                    return false ;
                }
            }
        }
        return true ;
    }
    
    public static void union(int x, int y){
        int lx = find(x) ; //leader of x 
        int ly = find(y) ; //leader of y
        
        //union by rank in DSU
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx ;
                
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly ;
                
            }else{
                parent[lx] = ly ;
                rank[ly] ++ ;
                
            }
        }
    }
    
    public static int find(int x){
        if(parent[x] == x){
            return x ;
        }
        
        int ans = find(parent[x]) ;
        parent[x] = ans ; //path compression in DSU
        
        return ans ;
    }
    
}
