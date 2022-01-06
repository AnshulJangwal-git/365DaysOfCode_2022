import java.util.*;
public class equivalentSubArrays {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
		//write your code here
		int ans = 0 ;
		HashSet<Integer> set = new HashSet<>() ;
		for(int i = 0; i < arr.length; i++){
		    set.add(arr[i]) ;
		}
		
		int k = set.size() ;
		
		HashMap<Integer, Integer> map = new HashMap<>() ;
		int i = -1 ;
		int j = -1 ;
		
		while(true){
		    boolean flag1 = false ;
		    boolean flag2 = false ;
		    
		    while(i < arr.length - 1){
		        i ++ ;
		        flag1 = true ;
		        map.put(arr[i], map.getOrDefault(arr[i], 0) + 1) ;
		        
		        if(map.size() == k){
		            ans += arr.length - i ;
		            break ;
		        }
		    }
		    
		    while(j < i){
		        flag2 = true ;
		        j ++ ;
		        if(map.get(arr[j]) == 1){
		            map.remove(arr[j]) ;
		            
		        }else{
		            map.put(arr[j], map.get(arr[j]) - 1) ;
		            
		        }
		        
		        if(map.size() == k){
		            ans += arr.length - i ;
		            
		        }else if(map.size() < k){
		            break ;
		        }
		    }
		    if(flag1 == false && flag2 == false){
		        break ;
		    }
		}
		
		System.out.println(ans) ;
		
	}


}
