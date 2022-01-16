//Leetcode 454 - https://leetcode.com/problems/4sum-ii/
import java.util.* ;

class quadrupletSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>() ;
        int n = nums1.length ;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1) ;
            }
        }
        
        int count = 0 ;
        for(int e1 : nums3){
            for(int e2 : nums4){
                int temp = 0 - (e1 + e2) ;
                if(map.containsKey(temp)){
                    count += map.get(temp) ;
                }
            }
        }
        return count ;
    }
}
