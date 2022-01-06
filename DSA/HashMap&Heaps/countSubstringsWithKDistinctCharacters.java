import java.util.*;

public class countSubstringsWithKDistinctCharacters {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}
    
	public static int solution(String str, int k){
	    if(k == 1){
	        return solutionFork1(str) ;
	        
	    }
	    
		int ans = 0 ;
		HashMap<Character, Integer> big = new HashMap<>() ;
		HashMap<Character, Integer> small = new HashMap<>() ;
		
		int j = -1 ;
		int ib = -1 ;
		int is = -1 ;
		
		while(true){
		    boolean flag1 = false ;
		    boolean flag2 = false ;
		    boolean flag3 = false ;
		    
		    while(ib < str.length() - 1){
		        flag1 = true ;
		        ib ++ ;
		        char ch = str.charAt(ib) ;
		        big.put(ch, big.getOrDefault(ch, 0) + 1) ;
		        
		        if(big.size() == k + 1){
		            remove(big, ch) ;
		            ib -- ;
		            break ;
		        }
		    }
		    
		    while(is < ib){
		        is ++ ;
		        flag2 = true ;
		        char ch = str.charAt(is) ;
		        small.put(ch, small.getOrDefault(ch, 0) + 1) ;
		        
		        if(small.size() == k){
		            remove(small, ch) ;
		            is -- ;
		            break ;
		        }
		    }
		    
		    while(j < is){
		        flag3 = true ;
		        if(big.size() == k && small.size() == k - 1){
		            ans += ib - is ;
		        }
		        
		        //Release
		        j ++ ;
		        char ch = str.charAt(j) ;
		        remove(big, ch) ;
		        remove(small, ch) ;
		        
		        if(big.size() < k || small.size() < k - 1){
		            break ;
		        }
		    }
		    if(flag1 == false && flag2 == false && flag3 == false){
		        break ;
		    }
		}

		return ans ;
	}
	
	static int solutionFork1(String str){
	    int ans = 0 ;
	    
	    HashMap<Character, Integer> map = new HashMap<>() ;
	    int i = -1 ;
	    int j = -1 ;
	    
	    while(true){
	        boolean flag1 = false ;
	        boolean flag2 = false ;
	        
	        while(i < str.length() - 1){
	            i ++ ;
	            flag1 = true ;
	            char ch = str.charAt(i) ;
	            
	            map.put(ch, map.getOrDefault(ch, 0) + 1) ;
	            if(map.size() == 2){
	                remove(map, ch) ;
	                i -- ;
	                break ;
	            }
	        }
	        
	        while(j < i){
	            flag2 = true ;
	            if(map.size() == 1){
	                ans += i - j ;
	            }
	            
	            j ++ ;
	            char ch = str.charAt(j) ;
	            remove(map, ch) ;
	            
	            if(map.size() == 0){
	                break ;
	            }
	        }
	        if(flag1 == false && flag2 == false){
	            break ;
	        }
	    }
	    return ans ;
	}

    public static void remove(HashMap<Character, Integer> map, char ch){
        if(map.get(ch) == 1){
            map.remove(ch) ;
            
        }else{
            map.put(ch, map.get(ch) - 1) ;
        }
    }

}

