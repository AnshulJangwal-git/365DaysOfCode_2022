class maximumConsecutiveOnes_LeetcodeEasy {
    public int findMaxConsecutiveOnes(int[] arr) {
        int ans = 0 ;
        int j = -1 ;
        int count = 0 ;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                count ++ ;
            }
            
            while(count > 0){
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
