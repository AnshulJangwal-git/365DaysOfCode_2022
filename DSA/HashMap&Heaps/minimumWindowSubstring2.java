import java.util.*;

public class minimumWindowSubstring2 {

	public static int solution(String str){
		// write your code here
		HashSet<Character> set = new HashSet<>() ;
		String ans = "" ;
		
		for(int i = 0; i < str.length(); i++){
		    char ch = str.charAt(i) ;
		    if(set.contains(ch) == false){
		        set.add(ch) ;
		    }
		}
		
// 		int mct = 0 ;
// 		int dmct = set.size() ;
		
		HashMap<Character, Integer> map = new HashMap<>() ;
		int i = -1 ;
		int j = -1 ;
		
		while(true){
		    boolean flag1 = false ;
		    boolean flag2 = false ;
		    
		    //Acquire...
		    while(i < str.length() - 1 && map.size() < set.size()){
		        i ++ ;
		        char ch = str.charAt(i) ;
		        map.put(ch, map.getOrDefault(ch, 0) + 1) ;
		        
		        flag1 = true ;
		    }
		    
		    //collect Answers(Work)
		    while(j < i && map.size() == set.size()){
		        String pans = str.substring(j + 1, i + 1) ;
		        if(ans.length() == 0 || pans.length() < ans.length()){
		            ans = pans ;
		        }
		        //Release
		        j ++ ;
		        char ch = str.charAt(j) ;
		        if(map.get(ch) == 1){
		            map.remove(ch) ;
		            
		        }else{
		            map.put(ch, map.get(ch) - 1) ;
		            
		        }
		        flag2 = true ;
		    }
		    if(flag1 == false && flag2 == false){
		        break ;
		    }
		}
		return ans.length();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
