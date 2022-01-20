
import java.util.*;

public class countOfSubarraysWithEqual0s1sand2s {

    public static int solution(int[] arr) {
        int ans = 0 ;
        
        int countz = 0 ;
        int counto = 0 ;
        int countt = 0 ;
        
        int delta10 = counto - countz ;
        int delta21 = countt - counto ;
        
        String key = delta21 + "#" + delta10 ;
        
        HashMap<String, Integer> map = new HashMap<>() ;
        map.put(key, 1) ;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                countz ++ ;
                
            }else if(arr[i] == 1){
                counto ++ ;
                
            }else{
                countt ++ ;
                
            }
            delta10 = counto - countz ;
            delta21 = countt - counto ;
            
            key = delta21 + "#" + delta10 ;
            
            if(map.containsKey(key)){
                ans += map.get(key) ;
                map.put(key, map.get(key) + 1) ;
                
            }else{
                map.put(key, 1) ;
                
            }
        }
        return ans ;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}


