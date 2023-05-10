class Solution {
    public int[] sortedSquares(int[] nums) {
        int []ans = new int[nums.length];
        int i =0, j=nums.length-1;
        int val = nums.length-1;
        int ls=0,rs=0;
        while(i<=j){
            ls = nums[i]*nums[i];
            rs = nums[j]*nums[j];
            if(ls>rs){
                ans[val]=ls;
                val--;
                i++;
            }
            else{
                ans[val]=rs;
                val--;
                j--;
            }
        }
        return ans;
    }
}