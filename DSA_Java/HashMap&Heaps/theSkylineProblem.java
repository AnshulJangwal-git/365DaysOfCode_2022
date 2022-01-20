//Leetcode 218 - https://leetcode.com/problems/the-skyline-problem/
import java.util.* ;
class theSkylineProblem {
    public class Pair implements Comparable<Pair> {
        int x ;
        int ht ;
        
        public Pair(int x, int ht){
            this.x = x ;
            this.ht = ht ;
        }
        
        public int compareTo(Pair o){
            if(this.x != o.x){
                return this.x - o.x ;
            }else{
                return this.ht - o.ht ;
            }
        }
        
    }
    
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list = new ArrayList<>() ;
        
        for(int i = 0; i < buildings.length; i++){
            int sp = buildings[i][0] ;
            int ep = buildings[i][1] ;
            int ht = buildings[i][2] ;
            
            list.add(new Pair(sp, -ht)) ;
            list.add(new Pair(ep, ht)) ;
        }
        
        Collections.sort(list) ;
        List<List<Integer>> ans = new ArrayList<>() ;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()) ;
        int cht = 0 ;
        pq.add(0) ;
        
        for(int i = 0; i < list.size(); i++){
            int x = list.get(i).x ;
            int ht = list.get(i).ht ;
            
            if(ht < 0){
                pq.add(-ht) ;
                
            }else{
                pq.remove(ht) ; // O(n) time complexity..
                
            }
            
            if(cht != pq.peek()){
                ans.add(new ArrayList(Arrays.asList(x, pq.peek()))) ;
                
                cht = pq.peek() ;
            }
        }
        return ans ;
    }
}



















