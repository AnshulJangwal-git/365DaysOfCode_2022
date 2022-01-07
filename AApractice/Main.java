import java.util.*;

public class Main {
    public static void main(String[] args){
        String words[] = {"abc", "abcd", "abcde"} ;

        for(String st : words){
            System.out.print(st + " ") ;
            System.out.println() ;
            for(char ch : st.toCharArray()){
                System.out.print(ch + " ") ;
                System.out.println() ;
            }
        }

    }
}
