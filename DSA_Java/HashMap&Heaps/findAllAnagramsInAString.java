import java.util.*;

public class findAllAnagramsInAString {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		findAnagrams(s, p);
	}

    static boolean compare(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap){
        for(char sch : smap.keySet()){
            if(pmap.getOrDefault(sch, 0) != smap.getOrDefault(sch, 0)){
                return false ;
                
            }
        }
        return true ;
    }

	public static void findAnagrams(String s, String p) {
        HashMap<Character, Integer> smap = new HashMap<>() ;
        HashMap<Character, Integer> pmap = new HashMap<>() ;

        if(s.length() < p.length()){
            for(int i = 0; i < p.length(); i++){
                char chp = p.charAt(i) ;
                pmap.put(chp, pmap.getOrDefault(chp, 0) + 1) ;
            }
            
            for(int i = 0; i < p.length(); i++){
                char chs = s.charAt(i) ;
                smap.put(chs, smap.getOrDefault(chs, 0) + 1) ;
            }
            
            int i = p.length() ;
            int count = 0 ;
            // String ans = "" ;
            List<Integer> ans = new ArrayList<>() ;
            
            while(i < s.length()){
                if(compare(smap, pmap) == true){
                    count ++ ;
                    // sb.append((i - p.length()) + " ") ;
                    ans.add(i - p.length()) ;
                }
                
                char cha = s.charAt(i) ;
                smap.put(cha, smap.getOrDefault(cha, 0) + 1) ;
                
                char chr = s.charAt(i - p.length()) ;
                if(smap.get(chr) == 1){
                    smap.remove(chr) ;
                    
                }else{
                    smap.put(chr, smap.getOrDefault(chr, 0) - 1) ;
                    
                }
                
                i ++ ;
            }
            
            if(compare(smap, pmap) == true){
                count ++ ;
                // sb.append(i - p.length() + " ") ;
                ans.add(i - p.length()) ;
            }
            
            
    
            System.out.println(count) ;
            for(int val : ans){
                System.out.print(val + " ") ;
            }
        }

        
        
	}  
}
