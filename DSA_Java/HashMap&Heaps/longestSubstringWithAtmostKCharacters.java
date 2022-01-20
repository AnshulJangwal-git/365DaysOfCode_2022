import java.util.* ;
//Ques Link - https://www.lintcode.com/problem/longest-substring-with-at-most-k-distinct-characters/description
public class longestSubstringWithAtmostKCharacters {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String str, int k) {
        // write your code here
        int ans = 0 ;
        int i = -1 ;
        int j = -1 ;

        HashMap<Character, Integer> map = new HashMap<>() ;
        
        while(true){
            boolean f1 = false ;
            boolean f2 = false ;

            while(i < str.length() - 1){
                f1 = true ;
                i ++ ;
                char ch = str.charAt(i) ;
                map.put(ch, map.getOrDefault(ch, 0) + 1) ;

                if(map.size() <= k){
                    int len = i - j ;
                    if(ans < len){
                        ans = len ;
                    }
                }else{
                    break ;
                }
            }
            
            while(j < i){
                f2 = true ;
                j ++ ;
                char ch = str.charAt(j) ;
                if(map.get(ch) == 1){
                    map.remove(ch) ;

                }else{
                    map.put(ch, map.getOrDefault(ch, 0) - 1) ;
                }

                if(map.size() > k){
                    continue ;

                }else{
                    int len = i - j ;
                    if(ans < len){
                        len = ans ;
                    }
                    break ;
                }
            }

            if(f1 == false && f2 == false){
                break ;
            }
        }
        return ans ;
    }

}
