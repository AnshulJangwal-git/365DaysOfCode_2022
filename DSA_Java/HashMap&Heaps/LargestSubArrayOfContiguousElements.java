import java.util.*;
//Ques Link - https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/largest-subarray-with-contiguous-elements-official/ojquestion

public class LargestSubArrayOfContiguousElements {

	public static int solution(int[] arr) {
		// write your code here
		int ans = 0 ;
		for(int j = 0; j < arr.length - 1; j++){
		    int min = arr[j] ;
		    int max = arr[j] ;
		    
		    HashSet<Integer> cd = new HashSet<>() ;
		    cd.add(arr[j]) ;
		    
		    for(int i = j + 1; i < arr.length; i++){
		        if(cd.contains(arr[i])){
		            break ;
		        }
		        
		        cd.add(arr[i]) ;
		        min = Math.min(arr[i], min) ;
		        max = Math.max(arr[i], max) ;
		        
		        if(max - min == i - j){
		            int len = i - j + 1 ;
		            ans = Math.max(len , ans) ;
		        }
		    }
		}

		return ans ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}
}
