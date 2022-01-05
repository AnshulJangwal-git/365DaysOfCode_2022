import java.util.* ;
import java.io.* ;

public class zero_oneBFS {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        String[] st = br.readLine().split(" ") ;

        int vtces = Integer.parseInt(st[0]) ;
        int edges = Integer.parseInt(st[1]) ;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>() ;
        for(int i = 0; i < vtces; i++){
            graph.add(new ArrayList<>()) ;
        }

        for(int i = 0; i < edges; i++){
            st = br.readLine().split(" ") ;
            int u = Integer.parseInt(st[0]) - 1 ;
            int v = Integer.parseInt(st[1]) - 1 ;

            graph.get(u).add(new Pair(v, 0)) ;
            graph.get(v).add(new Pair(u, 1)) ;
        }

        LinkedList<Pair> queue = new LinkedList<>() ;
        queue.addLast(new Pair(0, 0)) ; //v = 0, wt = 0

        boolean[] visited = new boolean[vtces] ;

        while(queue.size() > 0){
            Pair rem = queue.removeFirst() ; //remove
            if(rem.v == graph.size() - 1){
                System.out.println(rem.wt) ;
                return ;
            }

            visited[rem.v] = true ; //mark*
            for(Pair edge : graph.get(rem.v)){
                if(visited[edge.v] == false){
                    if(edge.wt == 0){
                        queue.addFirst(new Pair(edge.v, rem.wt + 0)) ;

                    }else{
                        queue.addLast(new Pair(edge.v, rem.wt + 1)) ;

                    }
                }
            }
        }
        System.out.println("-1") ;
    }
    
    public static class Pair{
        int v ;
        int wt ;

        Pair(int v, int wt){
            this.v = v ;
            this.wt = wt ;
        }
    }
    
}
