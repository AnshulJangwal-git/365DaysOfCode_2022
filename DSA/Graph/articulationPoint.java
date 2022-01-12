import java.util.*;
import java.io.*;

class articulationPoint {
  static int[] parent ;
  static int[] disc ;
  static int[] low ;
  static boolean[] visited ;
  static boolean[] ap ;
  static int time ;
  
  public static void dfs(int u, ArrayList<ArrayList<Integer>> graph){
    disc[u] = low[u] = time ;
    time ++ ;
    visited[u] = true ;
    int count = 0 ;
    
    ArrayList<Integer> nbrs = graph.get(u) ;
    for(int i = 0; i < nbrs.size(); i++){
        int v = nbrs.get(i) ;
        
        if(parent[u] == v){
            continue ;
            
        }else if(visited[v] == true){
            low[u] = Math.min(low[u], disc[v]) ;
            
        }else{
            parent[v] = u ;
            count ++ ;
            dfs(v, graph) ;
            
            low[u] = Math.min(low[u], low[v]) ;
            if(parent[u] == -1){
                if(count >= 2){
                    ap[u] = true ; //marking of articulation point
                }
            }else{
                if(low[v] >= disc[u]){
                    ap[u] = true ;  //marking of articulation point
                }
            }
        }
    }
    
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in) ;
    int vtces = sc.nextInt() ;
    int edges = sc.nextInt() ;
    
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
    for(int i = 0; i < vtces; i++){
        graph.add(new ArrayList<>()) ;
    }
    
    for(int i = 0; i < edges; i++){
        int u = sc.nextInt() - 1 ;
        int v = sc.nextInt() - 1 ;
        
        graph.get(u).add(v) ;
        graph.get(v).add(u) ;
    }
    
    parent = new int[vtces] ;
    disc = new int[vtces] ;
    low = new int[vtces] ;

    visited = new boolean[vtces] ;
    ap = new boolean[vtces] ;
        
    parent[0] = -1 ;
    time = 0 ;
    
    dfs(0, graph) ;
    
    int ans = 0 ;
    for(int i = 0; i < vtces; i++){
        if(ap[i] == true){
            ans ++ ;
        }
    }
    System.out.println(ans) ;
  }

}





