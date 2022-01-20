//Leetcode 242 - https://leetcode.com/problems/valid-anagram/
import java.util.*;

public class validAnagrams {
	
	public static boolean solution(String s1, String s2){
		// write your code here
		if(s1.length() != s2.length()){
		    return false ;
		}
		
		HashMap<Character, Integer> map1 = new HashMap<>() ;
		for(int i = 0; i < s1.length(); i++){
		    char ch = s1.charAt(i) ;
		    map1.put(ch, map1.getOrDefault(ch, 0) + 1) ;
		}
		
		HashMap<Character, Integer> map2 = new HashMap<>() ;
		for(int i = 0; i < s2.length(); i++){
		    char ch = s2.charAt(i);
		    map2.put(ch, map2.getOrDefault(ch, 0) + 1) ;
		}
		
		if(map1.equals(map2) == false){
		    return false ;
		}else{
		    return true ;
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
