// class Solution {
//   public int findPeakElement(int[] nums) {
//     int l = 0;
//     int r = nums.length - 1;

//     while (l < r) {
//       final int m = (l + r) / 2;
//       if (nums[m] >= nums[m + 1])
//         r = m;
//       else
//         l = m + 1;
//     }

//     return l;
//   }
// }

class Solution {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            
            if(arr[mid]<arr[mid+1]){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
}