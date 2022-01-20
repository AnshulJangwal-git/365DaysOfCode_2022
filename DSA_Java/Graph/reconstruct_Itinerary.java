//Leetcode 332 - https://leetcode.com/problems/reconstruct-itinerary/
import java.util.* ;
// class reconstruct_Itinerary {
//     HashMap<String, PriorityQueue<String>> graph ;
//     LinkedList<String> ans ;
//     Stack<String> st ;
    
//     public List<String> findItinerary(List<List<String>> tickets) {
//         graph = new HashMap<>() ;
//         ans = new LinkedList<>() ;
//         st = new Stack<>() ;
        
//         for(List<String> ticket : tickets){
//             PriorityQueue<String> temp = graph.getOrDefault(ticket.get(0), new PriorityQueue<>()) ;
//             temp.add(ticket.get(1)) ;
//             graph.put(ticket.get(0), temp) ;
//         }
        
//         dfs("JFK") ;
//         while(st.size() > 0){
//             ans.add(st.pop()) ;
//         }
        
//         return ans ;
//     }
    
//     public void dfs(String src){
//         PriorityQueue<String> nbrs = graph.get(src) ;
        
//         while(nbrs != null && nbrs.size() > 0){
//             String nbr = nbrs.remove() ;
//             dfs(nbr) ;
//         }
//         st.push(src) ;
//         // ans.add(src) ;
//     }
// }







class reconstruct_Itinerary {
    HashMap<String, PriorityQueue<String>> graph ;
    LinkedList<String> ans ;
    // Stack<String> st ;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>() ;
        ans = new LinkedList<>() ;
        // st = new Stack<>() ;
        
        for(List<String> ticket : tickets){
            PriorityQueue<String> temp = graph.getOrDefault(ticket.get(0), new PriorityQueue<>()) ;
            temp.add(ticket.get(1)) ;
            graph.put(ticket.get(0), temp) ;
        }
        
        dfs("JFK") ;
        // while(st.size() > 0){
        //     ans.add(st.pop()) ;
        // }
        
        return ans ;
    }
    
    public void dfs(String src){
        PriorityQueue<String> nbrs = graph.get(src) ;
        
        while(nbrs != null && nbrs.size() > 0){
            String nbr = nbrs.remove() ;
            dfs(nbr) ;
        }
        // st.push(src) ;
        ans.addFirst(src) ;
        // ans.add(src) ;
    }
}