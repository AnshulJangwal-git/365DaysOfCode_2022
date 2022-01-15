import java.util.*;

public class smallestSubarrayWithAllOccurencesOfTheMostFrequentElement {

    public static void solution(int[] arr) {
        HashMap<Integer, Integer> fmap = new HashMap<>() ;
		HashMap<Integer, Integer> smap = new HashMap<>() ;

		int hfq = 0 ;
		int si = 0 ;
		int ei = 0 ;
		int len = 0 ;

		for(int i = 0; i < arr.length; i++){
			if(fmap.containsKey(arr[i])){
				fmap.put(arr[i], fmap.get(arr[i]) + 1) ;

			}else{
				fmap.put(arr[i], 1) ;
				smap.put(arr[i], i) ;
			}

			if(fmap.get(arr[i]) > hfq){
				hfq = fmap.get(arr[i]) ;
				si = smap.get(arr[i]) ;
				ei = i ;
				// len = ei - si + 1 ;
			}else if(fmap.get(arr[i]) == hfq){
				int clen = i - smap.get(arr[i]) + 1 ;
				if(clen < len){
					len = clen ;
					si = smap.get(arr[i]) ;
					ei = i ;
					hfq = fmap.get(arr[i]) ;

				}
			}
		}
		System.out.println(arr[si]) ;
		System.out.println(si) ;
		System.out.println(ei) ;

    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
        solution(arr);
	}

}

