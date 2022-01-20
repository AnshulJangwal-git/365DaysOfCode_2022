import java.util.*;
public class countOfSubstringsHavingAllUniqueCharacters {

	public static int solution(String str) {
		// write your code here
		HashMap<Character, Integer> map = new HashMap<>() ;
		int i = -1 ;
		int j = -1 ;
		
		int count = 0 ;
		
		while(true){
		    boolean flag1 = false ;
		    boolean flag2 = false ;
		    
		    while(i < str.length() - 1){
		        i ++ ;
		        flag1 = true ;
		        char ch = str.charAt(i) ;
		        map.put(ch, map.getOrDefault(ch, 0) + 1) ;
		        
		        if(map.get(ch) == 2){
		            break ;
		            
		        }else{
		            count += i - j ;
		        }
		    }
		    
		    while(j < i){
		        j ++ ;
		        flag2 = true ;
		        char ch = str.charAt(j) ;
		        map.put(ch, map.get(ch) - 1) ;
		        if(map.get(ch) == 1){
		            count += i - j ;
		            break ;
		        }
		    }
		    if(flag1 == false && flag2 == false){
		        break ;
		    }
		}
		
		return count ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
