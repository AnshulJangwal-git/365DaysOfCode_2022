import java.util.*;

public class Main {
    public static void main(String[] args){
        String str = "aabcbcdbca" ;
        String ans = "" ;
        HashSet<Character> set = new HashSet<>() ;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i) ;
            if(set.contains(ch) == false){
                set.add(ch) ;
            }
        }

        System.out.println(set.size()) ;
    }
}
