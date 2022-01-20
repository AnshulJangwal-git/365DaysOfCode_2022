//Leetcode 1579 - https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
import java.util.* ;

class removeMaxNumberOfEdgestoKeepGraphFullyTraversal {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0])) ; //sorting the array on the basis of //type 3 preferences..
        
        int[] parenta = new int[n + 1] ;
        int[] parentb = new int[n + 1] ;
        int[] ranka = new int[n + 1] ;
        int[] rankb = new int[n + 1] ;
        
        for(int i = 0; i < n; i++){
            parenta[i] = i ;
            parentb[i] = i ;
            ranka[i] = 1 ;
            rankb[i] = 1 ;
        }
        
        int mergeda = 1 ; //counts of merged of alice nodes
        int mergedb = 1 ; //counts of merged of bob nodes
        
        int removedEdges = 0 ;
        
        for(int[] e : edges){
            if(e[0] == 3){
                boolean uniona = union(e[1], e[2], parenta, ranka) ;
                boolean unionb = union(e[1], e[2], parentb, rankb) ;
                
                if(uniona == true){
                    mergeda ++ ;   
                }
                
                if(unionb == true){
                    mergedb ++ ;
                    
                }
                
                if(uniona == false && unionb == false){
                    removedEdges ++ ;
                    
                }
            }else if(e[0] == 1){
                
                boolean uniona = union(e[1], e[2], parenta, ranka) ;
                if(uniona == true){
                    mergeda ++ ;
                    
                }else{
                    removedEdges ++ ;
                    
                }
                
            }else{
                boolean unionb = union(e[1], e[2], parentb, rankb) ;
                
                if(unionb == true){
                    mergedb ++ ;
                    
                }else{
                    removedEdges ++ ;
                    
                }
            }
        }
        if(mergeda != n || mergedb != n){  //if all merged or not
            return -1 ;
            
        }
        
        return removedEdges ;
    }
    
    public static boolean union(int x, int y, int[] parent, int[] rank){
        int lx = find(x, parent) ;
        int ly = find(y, parent) ;
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx ;
                
            }else if(rank[ly] > rank[lx]){
                parent[lx] = ly ;
                
            }else{
                parent[lx] = ly ;
                rank[ly] ++ ;
                
            }
            return true ;
        }
        return false ;
    }
    
    public static int find(int x, int[] parent){
        if(parent[x] == x){
            return x ;
        }
        
        int temp = find(parent[x], parent) ;    
        parent[x] = temp ;
        
        return temp ;
    }
    
}
