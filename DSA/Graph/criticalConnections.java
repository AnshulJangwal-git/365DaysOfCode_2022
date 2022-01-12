
import java.util.*;
import java.io.*;

class criticalConnections {
  static int[] parent ;
  static int[] low ;
  static int[] disc ;
  static boolean[] visited ;
  static int time ;
  static boolean[] bridgesCount ;
  
  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> edges) {
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
    for(int i = 0; i < n; i++){
        graph.add(new ArrayList<>()) ;
    }
    
    for(int i = 0; i < edges.size(); i++){
        int u = edges.get(i).get(0);
        int v = edges.get(i).get(1) ;
        
        graph.get(u).add(v) ;
        graph.get(v).add(u) ;
    }
    
    parent = new int[n] ;
    low = new int[n] ;
    disc = new int[n] ;
    visited = new boolean[n] ;
    time = 0 ;
    bridgesCount = new boolean[n] ;
    
    List<List<Integer>> ans = new ArrayList<>() ;
    bridges(0, graph, ans) ;
    
    int counts = 0 ;
    for(int i = 0; i < n; i++){
        if(bridgesCount[i] == true){
            counts ++ ;
        }
    }
    // System.out.println(counts) ;
    return ans ;
    
  }
  
  public static void bridges(int u, ArrayList<ArrayList<Integer>> graph, List<List<Integer>> ans){
      disc[u] = low[u] = time ;
      time ++ ;
      visited[u] = true ;
      
      ArrayList<Integer> nbrs = graph.get(u) ;
      for(int i = 0; i < nbrs.size(); i++){
          int v = nbrs.get(i) ;
          
          if(parent[u] == v){
              continue ;
              
          }else if(visited[v] == true){
              low[u] = Math.min(low[u], disc[v]) ;
              
          }else{
              parent[v] = u ;
              bridges(v, graph, ans) ;
              //while backtracking
              
              low[u] = Math.min(low[u], low[v]) ;
              if(low[v] > disc[u]){
                //   bridgesCount[u] = true ;
                  List<Integer> temp = new ArrayList<>() ;
                  temp.add(u) ;
                  temp.add(v) ;
                  ans.add(temp) ;
              }
          }
      }
      
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);
    List<List<Integer>> edges = new ArrayList<>();


    for (int i = 0; i < e; i++) {
      edges.add(new ArrayList<>());
      st = br.readLine().split(" ");
      edges.get(i).add(Integer.parseInt(st[0]));
      edges.get(i).add(Integer.parseInt(st[1]));
    }

    System.out.println(criticalConnections(n, edges));

  }

}
