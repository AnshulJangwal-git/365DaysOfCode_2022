//Leetcode 290 - https://leetcode.com/problems/word-pattern/
import java.util.* ;

class wordPattern {
    public boolean wordPattern(String pattern, String str) {
		String words[] = str.split(" ") ;
        if(words.length != pattern.length()){
            return false ;
        }
        
		HashMap<Character, String> map = new HashMap<>() ;
		HashMap<String, Boolean> visited = new HashMap<>() ;
		
		for(int i = 0; i < pattern.length(); i++){
		    char ch = pattern.charAt(i) ;
		    
		    if(map.containsKey(ch) == false){
		        if(visited.containsKey(words[i]) == true){
		            return false ;
		            
		        }else{
		            map.put(ch, words[i]) ;
		            visited.put(words[i], true) ;
		        }
		    }else{
		        if(map.getOrDefault(ch, "").equals(words[i]) == false){
		            return false ;
		        }
		    }
		}
		
		return true ;
	}
}
