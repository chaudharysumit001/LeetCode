class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int longestSequence = 0;
        for(int num : set) {
            // check if num is the starting number of a sequence
            if(!set.contains(num - 1)) {
                int currentNum = num;
                int currentSequence = 1;
                
                // find the length of the consecutive sequence
                while(set.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequence++;
                }
                
                // update the longest sequence if necessary
                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }
        return longestSequence;
    }
}
