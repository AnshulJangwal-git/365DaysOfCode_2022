//Lintcode 856 - https://www.lintcode.com/problem/sentence-similarity/description

import java.util.* ;

public class sentenceSimilarity2 {
    /**
     * @param words1: a list of string
     * @param words2: a list of string
     * @param pairs: a list of string pairs
     * @return: return a boolean, denote whether two sentences are similar or not
     */
     static HashMap<String, String> parent ;
     static HashMap<String, Integer> rank ;

    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        // write your code here
        parent = new HashMap<>() ;
        rank = new HashMap<>() ;

        if(words1.length != words2.length){
            return false ;
        }

        for(int i = 0; i < pairs.size(); i++){
            String p1 = pairs.get(i).get(0) ;
            String p2 = pairs.get(i).get(1) ;

            union(p1, p2) ;
        }

        for(int i = 0; i < words1.length; i++){
            String w1 = words1[i] ;
            String w2 = words2[i] ;

            if(w1.equals(w2) == false && find(w1).equals(find(w2)) == false){
                return false ;
            }

        }
        return true ;
    }

    public static void union(String x, String y){
        String lx = find(x) ;
        String ly = find(y) ;

        if(lx.equals(ly) == false){
            if(rank.get(lx) > rank.get(ly)){
                parent.put(ly, lx) ;

            }else if(rank.get(ly) > rank.get(lx)){
                parent.put(lx, ly) ;

            }else{
                parent.put(lx, ly) ;
                rank.put(ly, rank.get(ly) + 1) ;

            }
        }
    }

    public static String find(String x){
        if(parent.containsKey(x) == false){
            parent.put(x, x) ;
            rank.put(x, 1) ;
        }

        if(parent.get(x).equals(x) == true){
            return x ;
        }

        String ans = find(parent.get(x)) ;
        parent.put(x, ans) ;

        return ans ;
    }
}