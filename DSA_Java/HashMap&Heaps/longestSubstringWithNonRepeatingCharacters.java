import java.util.* ;
//Leetcode 3 - https://leetcode.com/problems/longest-substring-without-repeating-characters/
class longestSubstringWithNonRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
    // int ans = 0 ;
    String ans = "" ;
    
        HashMap<Character, Integer> map = new HashMap<>() ;
        int i = -1 ;
        int j = -1 ;
        
        while(true){
            boolean flag1 = false ;
            boolean flag2 = false ;
            
            //Acquire until substring becomes invalid(map.get(ch) == 2)
            while(i < s.length() - 1){
                i ++ ;
                flag1 = true ;
                
                char ch = s.charAt(i) ;
                map.put(ch, map.getOrDefault(ch, 0) + 1) ;
                
                if(map.get(ch) == 2){
                    break ;
                }else{
                    // int len = i - j ;
                    // if(len > ans){
                    //     ans = len ;
                    // }
                    String pans = s.substring(j + 1, i + 1) ;
                    if(pans.length() > ans.length()){
                        ans = pans ;
                    }
                }
                // flag1 = true ;
            }
            //Release..
            while(j < i){
                flag2 = true ;
                
                j ++ ;
                char ch = s.charAt(j) ;
                map.put(ch, map.get(ch) - 1) ;
                
                if(map.get(ch) == 1){
                    break ;
                }
            }
            
            if(flag1 == false && flag2 == false){
                break ;
            }
        }
        return ans.length() ;
    }
    }
