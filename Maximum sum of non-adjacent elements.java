import java.util.*;
public class Solution {
    public static int f(ArrayList<Integer> nums, int ind, int arr[]) {
        if (ind == 0) return nums.get(0);
        if (ind < 0) return 0;
        if(arr[ind] != -1) return arr[ind];
        int pick = nums.get(ind) + f(nums, ind - 2, arr);
        int notpick = 0 + f(nums, ind - 1, arr);
        return arr[ind] = Math.max(pick, notpick);
    }
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
        int n = nums.size();
        int arr[] = new int[n+1];
        Arrays.fill(arr, -1);
        //return f(nums, n - 1,arr);
        int prev = nums.get(0);
        int prev2 = 0;
        for(int i = 1; i < nums.size(); i++) {
            int take = nums.get(i);
            if(i > 1) take += prev2;
            int nottake = 0 + prev;
            
            int curi = Math.max(take, nottake);
            prev2 = prev;
            prev = curi;
        }
        return prev;
	}
}
