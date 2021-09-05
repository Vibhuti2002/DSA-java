package leetcode;

import java.util.Arrays;

public class Find_1st_and_last_position_in_sorted_Array {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 20;
        boolean FindFirstIndex;
        System.out.println(search(nums, target));
    }

    static  int[] search(int[] nums, int target){
        int[] ans = {-1,-1};
        int start = find(nums, target, true);
        int end = find(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    static int find(int[] nums, int target, boolean FindFirstIndex){
        int ans = -1;
        int start =0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(target<nums[mid]){
                end = mid-1;
            }
            else if(target>nums[mid]){
                start = mid +1;
            }
            else{
                ans =mid;
                if(FindFirstIndex){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}
