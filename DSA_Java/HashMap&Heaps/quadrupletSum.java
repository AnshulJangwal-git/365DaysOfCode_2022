//Leetcode 18 - https://leetcode.com/problems/4sum/
import java.util.*;

public class quadrupletSum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target, int n) {
		Arrays.sort(nums) ;
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
		int si = 0 ;
		int ei = n - 1 ;

		for(int i = si; i <= ei; i++){
			if(i != si && nums[i] == nums[i - 1]) continue ;

			ArrayList<ArrayList<Integer>> smallAns = threeSum(nums, target - nums[i],
				i + 1, ei) ;
			createRes(smallAns, ans, nums[i]) ;
		}
		return ans ;
	}

	public static ArrayList<ArrayList<Integer>> twoSum(int[] nums, int target, int si, 
		int ei){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;

		while(si < ei){
			int sum = nums[si] + nums[ei] ;

			if(sum > target) ei -- ;
			else if(sum < target) si ++ ;
			else{
				// ArrayList<Integer> smallAns = new ArrayList<>() ;
				// smallAns.add(nums[si]) ;
				// smallAns.add(nums[ei]) ;
				// ans.add(smallAns) ;
				ans.add(new ArrayList(Arrays.asList(nums[si], nums[ei]))) ;

				si ++ ;
				ei -- ;

				while(si < ei && nums[si] == nums[si - 1]) si ++ ;
				while(si < ei && nums[ei] == nums[ei + 1]) ei -- ;
			}
		}
		return ans ;
	}

	public static ArrayList<ArrayList<Integer>> threeSum(int[] nums, int target, int si,
		int ei){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;

		for(int i = si; i <= ei; i++){
			if(i != si && nums[i] == nums[i - 1]) continue ;

			ArrayList<ArrayList<Integer>> smallAns = twoSum(nums, target - nums[i],
				i + 1, ei) ;
			createRes(smallAns, ans, nums[i]) ;
		}
		return ans ;
	}

	

	public static void createRes(ArrayList<ArrayList<Integer>> smallAns,
		ArrayList<ArrayList<Integer>> ans, int val){
			
			for(ArrayList<Integer> list : smallAns){
				list.add(0, val) ;
				ans.add(list) ;
			}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target, n);
		Collections.sort(ans,(a,b)->{
            int i = 0;
            int j = 0;
            
            while(i < a.size()){
                if(a.get(i) == b.get(j)){
                    i++;
                    j++;
                }else{
                    return a.get(i) - b.get(j);
                }
            }
            
            return 0;
        }); 
		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

}

