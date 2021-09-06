package kk;

public class find_rotation_count_in_an_array {
    public static void main(String[] args) {
        //int[] arr ={15,18,2,3,6,12};
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(pivot(arr));
        System.out.println(count(arr));
    }
    static int count(int[] arr){
        int pivot = pivot(arr);
        return pivot+1;
    }

    static int pivot(int[] arr){
        int start =0;
        int end = arr.length-1;
        int count =0;
        while(start <= end){
            int mid = start + (end -start)/2;
            if(mid<end && arr[mid] > arr[mid +1]){
                return mid;
            }
            else if(mid > start && arr[mid] < arr[mid-1]){
                return mid -1;
            }
            if(arr[start] > arr[start+1]){
                return start;
            }start++;
            if(arr[end] < arr[end-1]){
                return end -1;
            }end--;
        }
        return -1;
    }
}
