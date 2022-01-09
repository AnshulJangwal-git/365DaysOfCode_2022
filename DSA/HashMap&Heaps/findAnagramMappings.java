//Lintcode813 - https://www.lintcode.com/problem/813/
import java.util.* ;

public class findAnagramMappings {
    /**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public static int[] anagramMappings(int[] arr1, int[] arr2) {
		// write your code here
		HashMap<Integer, Pair> map = new HashMap<>() ;
		for(int i = 0; i < arr2.length; i++){
		    if(map.containsKey(arr2[i])){
		        Pair p = map.get(arr2[i]) ;
		        p.list.add(i) ;
		        
		    }else{
		        Pair p = new Pair() ;
		        p.list.add(i) ;
		        
		        map.put(arr2[i], p) ;
		        
		    }
		}
		int[] ans = new int[arr1.length] ;
		for(int i = 0; i < arr1.length; i++){
		    Pair p = map.get(arr1[i]) ;
		    ans[i] = p.list.get(p.idx) ;
		    p.idx ++ ;
		}

		return ans ;
	}
    static class Pair{
        int idx = 0 ;
        ArrayList<Integer> list = new ArrayList<>() ;
    }
}
