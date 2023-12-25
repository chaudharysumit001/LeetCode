class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap <>();
        for(int i = 0; i<nums.length;  i++){
            map.put(nums[i],i);
         }
        for(int j =0;j<nums.length;j++){
            int val = nums[j];
            int rem = target - val;
            if(map.containsKey(rem)){
                int index = map.get(rem);
                if(index == j)continue; // yaad rakhle bhai isko
                // same element twice condition
                return new int[]{j,index};
            }
            
        }
        return new int[]{};//empty array for just sake of question
    }
}