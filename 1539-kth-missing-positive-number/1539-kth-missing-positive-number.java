class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count=arr[0]-1;
        int i=1,prev;
        int ans=count;
        if(ans>=k) return k;
        while(count<k&&i<arr.length){
            prev=arr[i-1];
            while(prev!=arr[i]-1&&count<k){
                ans=prev+1;
                prev++;
                count++;
            }
        i++;
        }
        if(count<k) return arr[arr.length-1]+k-count;
        return ans;  
    }
}