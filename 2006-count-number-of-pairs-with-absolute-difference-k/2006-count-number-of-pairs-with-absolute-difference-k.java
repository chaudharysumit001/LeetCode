class Solution {
    public int countKDifference(int[] nums, int k) {
        int sum =0;
        int count =0;
        for(int i =0; i<nums.length;i++){
            for(int j =i; j<nums.length;j++){
                sum = Math.abs(nums[i]-nums[j]);
                if(sum == k){
                    count++;
                    //System.out.println("Value of 1st array   " + nums[i] +"Value of Second array   " + nums[j] +"  "+ sum);
                    sum = 0;
                }
            }
        }
        return count;
        
    }
}