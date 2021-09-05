package leetcode;

public class Search_in_rotated_sorted_array {
    public static void main(String[] args) {
        int[] nums = {3,5,1};
        int target = 3;
        System.out.println(findPivot(nums));
        System.out.println(search(nums, target));
    }
    static int search(int[] arr , int target){
       int pivot = findPivot(arr);
      if(pivot == -1){
          return Binarysearch(arr , target, 0, arr.length-1);
      }
      if(arr[pivot] == target){
          return pivot;
      }
        if(target >=arr[0]){
            return Binarysearch(arr, target, 0, pivot-1);
        }
        if(target <= arr[0]){
            return Binarysearch(arr, target,pivot+1, arr.length-1);
        }
        return Binarysearch(arr , target, 0, arr.length-1);
    }

    static int Binarysearch(int[] nums, int target, int start, int end){
        while(start<=end){
            int mid = start +(end-start)/2;
            if(target < nums[mid]){
                end = mid-1;
            }
            else if(target >nums[mid]){
                start = mid +1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    static int findPivot(int[] nums){
         int start = 0;
         int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start/2);
            if(mid<end && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid - 1]){
                return mid-1;
            }
            if(nums[start] > nums[mid]){
                end  =mid-1;
            }
            else{
                start = mid +1;
            }
        }
        return -1;
    }
}
