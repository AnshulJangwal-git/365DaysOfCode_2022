import java.util.* ;
// Leetcode 76 - https://leetcode.com/problems/minimum-window-substring/ 
class minimumWindowSubstring1 {
    public String minWindow(String s, String t){
	    String ans = "" ;
		HashMap<Character, Integer> map2 = new HashMap<>() ;
		
		for(int i = 0; i < t.length(); i++){
		    char ch = t.charAt(i) ;
		    map2.put(ch, map2.getOrDefault(ch, 0) + 1) ;
		}
		
		int mct = 0 ;
		int dmct = t.length() ;
		
		HashMap<Character, Integer> map1 = new HashMap<>() ;
		
		int i = -1 ;
		int j = -1 ;
		
		while(true){
		    int flag1 = 0 ;
		    int flag2 = 0 ; ;
		    
		    //Acquire..
		    while(i < s.length() - 1 && mct < dmct){
		        i ++ ;
		        char ch = s.charAt(i) ;
		        map1.put(ch, map1.getOrDefault(ch, 0) + 1) ;
		        
		        if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){
		            mct ++ ;
		        }
		        flag1 = 1 ;   
		    }
		    
		    //collect answers
		    while(j < i && mct == dmct){
		        String pans = s.substring(j + 1, i + 1) ;
		        if(ans.length() == 0 || pans.length() < ans.length()){
		            ans = pans ;
		        }
		        
		        //Released
		        j ++ ;
		        char ch = s.charAt(j) ;
		        if(map1.get(ch) == 1){
		            map1.remove(ch) ;
		            
		        }else{
		            map1.put(ch, map1.get(ch) - 1) ;
		            
		        }
		        if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){
		            mct -- ;
		        }
		        
		        flag2 = 1 ;
		    }
		    
		    if(flag1 == 0 && flag2 == 0){
		        break ;
		    }
		    
		}
		return ans ;
	}
}