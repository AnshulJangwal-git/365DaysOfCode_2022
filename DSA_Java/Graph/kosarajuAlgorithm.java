
import java.io.*;
import java.util.*;

public class kosarajuAlgorithm {
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(kosaraju(graph, n));
	}

	public static int kosaraju(ArrayList<ArrayList<Integer>> graph, int N) {
		//step1 - Random order DFS and stack filling while backtracking in dfs..
		boolean visited[] = new boolean[N] ;
		LinkedList<Integer> stack = new LinkedList<>() ;

		for(int i = 0; i < N; i++){
			if(visited[i] == false){
				dfs(i, graph, visited, stack) ;
			}
		}

		//step2 - Reverse all the edges of a given graph and to get a new graph..
		ArrayList<ArrayList<Integer>> ngraph = new ArrayList<>() ;
		for(int i = 0; i < N; i++){
			ngraph.add(new ArrayList<>()) ;
		}

		for(int i = 0; i < N; i++){
			ArrayList<Integer> nbrs = graph.get(i) ;
			for(int nbr : nbrs){
				ngraph.get(nbr).add(i) ;
			}
		}

		//step3 - Again need to do dfs taking src as from the top of filled stack and count
		//		  the number of strongly connected components..
		visited = new boolean[N] ;
		int countSCC = 0 ;

		while(stack.size() > 0){
			int rem = stack.removeFirst() ;
			ArrayList<Integer> nbrs = graph.get(rem) ;
			for(int nbr : nbrs){
				if(visited[nbr] == false){
					dfs(ngraph, rem, visited) ;
					countSCC ++ ;
				}
			}
		}

		return countSCC ;
    }	

	public static void dfs(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited,
		LinkedList<Integer> stack){
			visited[src] = true ;
			ArrayList<Integer> nbrs = graph.get(src) ;

			for(int nbr : nbrs){
				if(visited[nbr] == false){
					dfs(nbr, graph, visited, stack) ;
				}
			}
			stack.addFirst(src) ;
		}

	public static void dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited){
			visited[src] = true ;
			ArrayList<Integer> nbrs = graph.get(src) ;

			for(int nbr : nbrs){
				if(visited[nbr] == false){
					dfs(graph, nbr, visited) ;
				}
			}
		}

}
