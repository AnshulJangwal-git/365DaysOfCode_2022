//Leetcode 525 - https://leetcode.com/problems/contiguous-array/
import java.util.*;

public class longestSubarrayWithEqualNumberOf0and1 {

    public static int solution(int[] arr) {
        int ans = 0 ;
        HashMap<Integer, Integer> map = new HashMap<>() ;
        int sum = 0 ;
        map.put(0, -1) ;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                sum += -1 ;
                
            }else if(arr[i] == 1){
                sum += 1 ;
                
            }
            
            if(map.containsKey(sum) == true){
                int len = i - map.get(sum) ;
                if(len > ans){
                    ans = len ;
                }
                
            }else{
                map.put(sum, i) ;
                
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

