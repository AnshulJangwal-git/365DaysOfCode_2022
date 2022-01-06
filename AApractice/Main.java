import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        int[] arr = new int[n] ;
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt() ;
        }


        int ans[] = pickEven(arr, n) ;
    }

    public static int[] pickEven(int[] arr, int n){
        int ans[] = new int[n] ;
        int idx = 0 ;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                ans[idx] = arr[i] ;
                idx ++ ;
            }
        }

        if(ans.length != 0){
            return ans ;
        }

        return new int[0] ;
    }
}
