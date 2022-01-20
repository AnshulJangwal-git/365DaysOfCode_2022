//Leetcode 210 - https://leetcode.com/problems/course-schedule-ii/
import java.util.* ;

class courseSchedule2 {
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>()) ;
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0] ;
            int v = prerequisites[i][1] ;
            
            graph.get(v).add(u) ;
        }
        
        int[] ans = new int[n] ;
        int[] indegree = new int[n] ;
        
        for(int i = 0; i < n; i++){
            for(int nbrs : graph.get(i)){
                indegree[nbrs] ++ ;
            }
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>() ;
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.addLast(i) ;
            }
        }
        
        int idx = 0 ;
        while(queue.size() > 0){
            int rem = queue.removeFirst() ;
            ans[idx] = rem ;
            idx ++ ;
            
            for(int nbrs : graph.get(rem)){
                indegree[nbrs] -- ;
                
                if(indegree[nbrs] == 0){
                    queue.addLast(nbrs) ;
                }
            }
        }
        if(idx == n){
            return ans ;
            
        }else{
            return new int[0] ;
        }
    }
}

