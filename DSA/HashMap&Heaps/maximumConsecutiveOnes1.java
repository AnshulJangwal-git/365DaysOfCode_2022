import java.util.*;

public class maximumConsecutiveOnes1 {

    public static int solution(int[] arr){
        // write your code here
        int ans = 0 ;
        int j = -1 ;
        // int count = 0 ;
        HashMap<Integer, Integer> map = new HashMap<>() ;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                map.put(0, map.getOrDefault(arr[i], 0) + 1) ;
            }
            
            while(map.getOrDefault(0, 0) > 1){
                j ++ ;
                if(arr[j] == 0){
                    map.put(0, map.get(arr[j]) - 1) ;
                    
                }
            }
            
            int len = i - j ;
            if(len > ans){
                ans = len ;
            }
        }

        return ans;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
	}

}
