import java.util.*;

public class countDistinctElementsInEveryWindowOfSize_k {

	public static ArrayList<Integer> solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>() ;
        HashMap<Integer, Integer> map = new HashMap<>() ;
        
        int i = 0 ;
        
        while(i <= k - 2){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1) ;
            i ++ ;
        }
        
        int j = 0 ;
        while(i < arr.length){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1) ; //acquire..
            
            list.add(map.size()) ; //work...
            
            // j ++ ;
            int freq = map.get(arr[j]) ;
            if(freq == 1){
                map.remove(arr[j]) ;
                
            }else{
                map.put(arr[j], freq - 1) ;
            }
            i ++ ;
            j ++ ;
        }
		return list ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}