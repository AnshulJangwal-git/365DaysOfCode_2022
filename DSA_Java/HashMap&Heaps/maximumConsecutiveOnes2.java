//Leetcode 1004 - https://leetcode.com/problems/max-consecutive-ones-iii/
class maximumConsecutiveOnes2 {
    public static int longestOnes(int[] arr, int k){
        int ans = 0 ;
        int count = 0 ;
        int j = -1 ;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                count ++ ;
            }
            
            while(count > k){
                j ++ ;
                if(arr[j] == 0){
                    count -- ;
                }
            }
            int len = i - j ;
            if(len > ans){
                ans = len ;
            }
        }

        return ans ;
    }
}
