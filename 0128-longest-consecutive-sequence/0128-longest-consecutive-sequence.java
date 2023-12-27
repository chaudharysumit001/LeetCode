class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longestSeq =0; 
        int currentSeq = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int currentNum = num;
                currentSeq = 1;
                
                while(set.contains(currentNum+1)){
                    currentSeq++;
                    currentNum++;
                }
                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }
               return longestSeq;
    }
}