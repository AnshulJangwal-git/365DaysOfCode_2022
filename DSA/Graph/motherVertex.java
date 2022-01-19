//GFG  -  https://practice.geeksforgeeks.org/problems/mother-vertex/1/#
// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    // class GFG
    // {
    //     public static void main(String[] args) throws IOException
    //     {
    //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //         int T = Integer.parseInt(br.readLine().trim());
    //         while(T-->0)
    //         {
    //             String[] s = br.readLine().trim().split(" ");
    //             int V = Integer.parseInt(s[0]);
    //             int E = Integer.parseInt(s[1]);
    //             ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    //             for(int i = 0; i < V; i++)
    //                 adj.add(i, new ArrayList<Integer>());
    //             for(int i = 0; i < E; i++){
    //                 String[] S = br.readLine().trim().split(" ");
    //                 int u = Integer.parseInt(S[0]);
    //                 int v = Integer.parseInt(S[1]);
    //                 adj.get(u).add(v);
    //             }
    //             motherVertex obj = new motherVertex();
    //             int ans = obj.findMotherVertex(V, adj);
    //             System.out.println(ans);
    //        }
    //     }
    // }// } Driver Code Ends
    
    
    
    
    class motherVertex
    {
        //Function to find a Mother Vertex in the Graph.
        public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>graph)
        {
            Stack<Integer> stack = new Stack<>() ;
            boolean[] visited = new boolean[graph.size()] ;
            
            for(int i = 0; i < graph.size(); i++){
                if(visited[i] == false){
                    dfs(graph, i, visited, stack) ;
                }
            }
            
            int motherVertex = stack.pop() ;
            visited = new boolean[graph.size()] ;
            dfs(graph, motherVertex, visited) ;
            
            for(int i = 0; i < visited.length; i++){
                if(visited[i] == false){
                    return -1 ;
                }
            }
            return motherVertex ;
            
        }
        
        static void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited){
            visited[src] = true ;
            
            for(int nbrs : graph.get(src)){
                if(visited[nbrs] == false){
                    dfs(graph, nbrs, visited) ;
                }
            }
        }
        
        
        public static void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited,
            Stack<Integer> stack){
            visited[src] = true ;
            
            for(int nbrs : graph.get(src)){
                if(visited[nbrs] == false){
                    dfs(graph, nbrs, visited, stack) ;
                }
            }
            stack.push(src) ;
        }
        
    }
    
    
    
    
    
    
    
    
    