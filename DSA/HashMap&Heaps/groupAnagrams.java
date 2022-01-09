//Leetcode 49 - https://leetcode.com/problems/group-anagrams/
import java.util.* ;
class groupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>() ;
        List<List<String>> retList = new ArrayList<>() ;
		if(strs.length == 0){
		    return retList ;
		}
		
		for(String str : strs){
		    HashMap<Character, Integer> fmap = new HashMap<>() ;
		    for(int i = 0; i < str.length(); i++){
		        char ch = str.charAt(i) ;
		        fmap.put(ch, fmap.getOrDefault(ch, 0) + 1) ;
		    }
		    
		    if(bmap.containsKey(fmap) == false){
		        ArrayList<String> list = new ArrayList<>() ;
		        list.add(str) ;
		        bmap.put(fmap, list) ;
		        
		    }else{
		        ArrayList<String> list = bmap.get(fmap) ;
		        list.add(str) ;
		    }
		}
		List<List<String>> ans = new ArrayList<>() ;
		
		for(ArrayList<String> list : bmap.values()){
		    ans.add(list) ;    
		}

		return ans ;
	}
}
