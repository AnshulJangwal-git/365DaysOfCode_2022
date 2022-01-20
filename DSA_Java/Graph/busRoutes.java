import java.io.*;
import java.util.*;

//Leetcode 815 - https://leetcode.com/problems/bus-routes/
public class busRoutes {
    public static int numBusesToDestination(int[][] routes, int src, int tar) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>() ;

        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                int busStopNo = routes[i][j] ;
                ArrayList<Integer> busno = map.getOrDefault(busStopNo, new ArrayList<>()) ;
                busno.add(i) ;
                map.put(busStopNo, busno) ;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>() ;
        HashSet<Integer> busstopvis = new HashSet<>() ;
        HashSet<Integer> busvis = new HashSet<>() ;

        int level = 0 ;
        queue.addLast(src) ;
        busstopvis.add(src) ;

        while(queue.size() > 0){
            int size = queue.size() ;

            while(size --> 0){
                int rem = queue.removeFirst() ;
                if(rem == tar){
                    return level ;
                }

                ArrayList<Integer> buses = map.get(rem) ;
                for(int bus : buses){
                    if(busvis.contains(bus) == true){
                        continue ;
                    }

                    busvis.add(bus) ;

                    int[] arr = routes[bus] ;
                    for(int busstop : arr){
                        if(busstopvis.contains(busstop) == true){
                            continue ;
                        }

                        queue.addLast(busstop) ;
                        busstopvis.add(busstop) ;
                    }
                }
            }
            level ++ ;
        }

        return -1 ;
    }
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    String[] st1 = br.readLine().split(" ");
    int src = Integer.parseInt(st1[0]);
    int dest = Integer.parseInt(st1[1]);
    System.out.println(numBusesToDestination(arr, src, dest));

  }
}
