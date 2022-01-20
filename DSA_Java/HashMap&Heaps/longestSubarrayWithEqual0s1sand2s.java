import java.util.*;
public class longestSubarrayWithEqual0s1sand2s {

    public static int solution(int[] arr) {
        int ans = 0 ;
        int countz = 0 ;
        int counto = 0 ;
        int countt = 0 ;

        int delta10 = counto - countz ;
        int delta21 = countt - counto ;

        String key = delta21 + "#" + delta10 ;
        HashMap<String, Integer> map = new HashMap<>() ;
        map.put(key, -1) ; //map.put(key, idx) 

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                countz ++ ;

            }else if(arr[i] == 1){
                counto ++ ;

            }else if(arr[i] == 2){
                countt ++ ;

            }
            delta10 = counto - countz ;
            delta21 = countt - counto ;

            key = delta21 + "#" + delta10 ;
            
            if(map.containsKey(key) == true){
                int idx = map.get(key) ;
                int len = i - idx ;
                ans = Math.max(ans, len) ;

            }else{
                map.put(key, i) ;

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

